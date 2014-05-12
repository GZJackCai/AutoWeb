<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>配件详情</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/accessory-detail.css" />
	
</head>
<body>
<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->
<div class="box">

	<%
	AutoWidget widget = (AutoWidget)request.getAttribute("autoWidget");
	AutoType type = (AutoType)request.getAttribute("autoType");
	AutoBrand brand = (AutoBrand)request.getAttribute("autoBrand");
	AutoWidgetType widgetType =(AutoWidgetType) request.getAttribute("autoWidgetType");
	%>

	<div class="path"><span class="mr10">您的位置：</span><a href="#" target="_blank">首页</a><em>》</em><a href="#" target="_blank">配件大全</a><em>》</em><a href="#" target="_blank">配件大全品牌</a><em>》</em><span>配件大全车型</span></div>
	<h1 class="a_detail_title"><%= widget.getName() %></h1>
    <div class="fl a_detail_box">
    	<table width="500" border="0" align="center" cellpadding="0" cellspacing="5">
          <tr>
          	<td width="110" align="center" valign="top">
            <img src="<%=request.getContextPath() %>/images/gotop.gif" width="100" height="14" id="gotop" />
            <div id="showArea">
                <img src="<%=request.getContextPath() %>/images/img06.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img06.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img07.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img07.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img08.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img08.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img06.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img06.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img07.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img07.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img07.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img08.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img06.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img06.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img07.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img07.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img08.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img08.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img06.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img06.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img07.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img07.jpg" link="http://www.lanrentuku.com" />
                <img src="<%=request.getContextPath() %>/images/img08.jpg" alt="" width="80" height="50" border="0" class="thumb_img" rel="<%=request.getContextPath() %>/images/img08.jpg" link="http://www.lanrentuku.com" />
            </div>
            <img src="<%=request.getContextPath() %>/images/gobottom.gif" width="100" height="14" id="gobottom" /></td>
            <td class="max_img" width="420" align="center"><img src="<%=request.getContextPath() %>/images/img08.jpg" alt="" width="420" height="400" border="0" id="main_img" rel="images/img08.jpg" link="http://www.lanrentuku.com" /></td>
          </tr>
</table>
    </div>
    <div class="fr detail_box_rgt">
    	<h2><%= widget.getName() %></h2>
        <dl>
        	<dt>价格：</dt>
            <dd class="deatil_jg">￥<%= widget.getPrice() %></dd>
        </dl>
        <dl>
        	<dt>配件所属品牌：</dt>
            <dd><%= brand.getName() %></dd>
        </dl>
        <dl>
        	<dt>适用车型：</dt>
            <dd><%= type.getName() %></dd>
        </dl>
        <dl>
        	<dt>配件所属分类：</dt>
            <dd><%= widgetType.getName() %></dd>
        </dl>
        <dl>
        	<dt>配件名称：</dt>
            <dd><%= widget.getName() %></dd>
        </dl>
        <dl>
        	<dt>经销商：</dt>
            <dd><%= widget.getUserId() %></dd>
        </dl>
        <dl>
        	<dt>当前库存：</dt>
            <dd><%= widget.getQuantity() %></dd>
        </dl>
        <dl>
        	<dt>购买数量：</dt>
            <dd><input type="text" value="1" />件</dd>
        </dl>
        <dl>
        	<dd><a class="deatil_gwc" href="#">加入购物车</a><a class="deatil_gm" href="#" target="_blank">立即购买</a></dd>
        </dl>
    </div>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/detail_img.js"></script>
<script type="text/javascript">
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "nchover";
	// 操作内容
	for(i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
	
	
}
</script> 
    <div class="cl " id="con">
    	<ul class="deatil_tab" id="tags">
        	<li class="nchover"><a onClick="selectTag('tagContent0',this)" 
  href="javascript:void(0)">商家介绍</a></li>
            <li><a  onClick="selectTag('tagContent1',this)" 
  href="javascript:void(0)">商家介绍</a></li>
            <li><a onClick="selectTag('tagContent2',this)" 
  href="javascript:void(0)">商家介绍</a></li>
            <li><a onClick="selectTag('tagContent3',this)" 
  href="javascript:void(0)">商家介绍</a></li>
        </ul>
    <div id="tagContent">
    <div class="cl d_jiashao" id="tagContent0">
    	<h4>一汽大众奥迪200方向盘电话接听开关介绍：</h4>
        <p>本销售事业部是目前中国最大最全的全车系正品长安CM8汽车配件销售中心，涵盖（2606）种配件，是国内最大的在线销售平台。长安CM8配件事业部成立以来以最完善的服务最优惠的价格得到全国用户信赖与支持，我们承诺非正品无条件双倍赔偿，真正实现用户购物零风险。
    提示：由于汽配极其复杂，为了您准确订购与节省时间，请直接“快速订购”，或拨打订购电话：北京：010-51659881 广州:020-61136645。我们销售专员会及时与您联系。</p>
    </div>
    <div class="cl d_jiashao hide"  id="tagContent1">
    	<h4>2一汽大众奥迪200方向盘电话接听开关介绍：</h4>
        <p>本销售事业部是目前中国最大最全的全车系正品长安CM8汽车配件销售中心，涵盖（2606）种配件，是国内最大的在线销售平台。长安CM8配件事业部成立以来以最完善的服务最优惠的价格得到全国用户信赖与支持，我们承诺非正品无条件双倍赔偿，真正实现用户购物零风险。
    提示：由于汽配极其复杂，为了您准确订购与节省时间，请直接“快速订购”，或拨打订购电话：北京：010-51659881 广州:020-61136645。我们销售专员会及时与您联系。</p>
    </div>
    <div class="cl d_jiashao hide"  id="=tagContent2">
    	<h4>3一汽大众奥迪200方向盘电话接听开关介绍：</h4>
        <p>本销售事业部是目前中国最大最全的全车系正品长安CM8汽车配件销售中心，涵盖（2606）种配件，是国内最大的在线销售平台。长安CM8配件事业部成立以来以最完善的服务最优惠的价格得到全国用户信赖与支持，我们承诺非正品无条件双倍赔偿，真正实现用户购物零风险。
    提示：由于汽配极其复杂，为了您准确订购与节省时间，请直接“快速订购”，或拨打订购电话：北京：010-51659881 广州:020-61136645。我们销售专员会及时与您联系。</p>
    </div>
    <div class="cl d_jiashao hide"  id="tagContent3">
    	<h4>4一汽大众奥迪200方向盘电话接听开关介绍：</h4>
        <p>本销售事业部是目前中国最大最全的全车系正品长安CM8汽车配件销售中心，涵盖（2606）种配件，是国内最大的在线销售平台。长安CM8配件事业部成立以来以最完善的服务最优惠的价格得到全国用户信赖与支持，我们承诺非正品无条件双倍赔偿，真正实现用户购物零风险。
    提示：由于汽配极其复杂，为了您准确订购与节省时间，请直接“快速订购”，或拨打订购电话：北京：010-51659881 广州:020-61136645。我们销售专员会及时与您联系。</p>
    </div>
    </div>
    </div>
</div>
<!-- 底部开始 -->
<%@ include file="/WEB-INF/footer.jsp"%>
<!-- 底部结束 -->
</body>
</html>
