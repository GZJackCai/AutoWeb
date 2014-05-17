package com.care.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.care.domain.UserOrder;
import com.care.mybatis.bean.Order;
import com.care.mybatis.bean.OrderItem;
import com.care.mybatis.bean.OrderNoSeqs;
import com.care.mybatis.dao.OrderItemMapper;
import com.care.mybatis.dao.OrderMapper;
import com.care.mybatis.dao.OrderNoSeqsMapper;

@Service
public class OrderServiceImple implements OrderService {
	@Resource
	private OrderMapper orderMapper;

	@Resource
	private OrderItemMapper orderItemMapper;
	@Resource
	protected DataSourceTransactionManager txManager;

	@Resource
	private OrderNoSeqsMapper orderNoSeqsMapper;

	private static final String format = "yyyyMMdd";;

	/**
	 * 生成订单序列号 </br> 8位年月日+6位用户ID+6位自增序列号 yyyyMMdd|000001|000001
	 * 
	 * @param userId
	 * @return
	 */
	public String genSeqs(Integer userId) {

		OrderNoSeqs record = new OrderNoSeqs();
		Date date = new Date();
		record.setDate(date);
		record.setUserId(userId);

		int id = orderNoSeqsMapper.insertSelective(record);
		String strDate = new SimpleDateFormat(format).format(date);
		String strUserId = String.format("%06d", userId);
		String strId = String.format("%06d", id);
		return strDate + strUserId + strId;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.care.service.OrderService#saveOrder(com.care.mybatis.bean.Order,
	 * java.util.List)
	 */
	@Override
	public void saveOrder(UserOrder uo, List<OrderItem> items) {

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);

		try {
			Integer uId = uo.getUser().getId();
			Order o = uo.getOrder();
			o.setcId(uId);
			String no = genSeqs(uId);
			o.setNo(no);

			orderMapper.insertSelective(uo.getOrder());
			Integer oId = o.getId();

			for (OrderItem item : items) {
				item.setoId(oId);
				orderItemMapper.insertSelective(item);
			}
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			throw e;
		}

	}
}
