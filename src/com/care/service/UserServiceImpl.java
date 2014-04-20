package com.care.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.mybatis.bean.User;
import com.care.mybatis.bean.UserExample;
import com.care.mybatis.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.care.service.UserService#getUserById(int)
	 */
	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.care.service.UserService#addUser(com.care.mybatis.bean.User)
	 */
	@Override
	public int addUser(User user) {
		user.setTime(new Date());
		return userMapper.insertSelective(user);
	}

	@Override
	public User login(String email, String password) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andPasswordEqualTo(password).andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(userExample);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);

	}

	@Override
	public int saveUser(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int updateUser(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		return userMapper.updateByExampleSelective(user, example);
	}

	@Override
	public int saveUpdateUser(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		int c = userMapper.updateByExampleSelective(user, example);
		if (c < 1) {
			c = userMapper.insertSelective(user);
		}
		return c;
	}

}
