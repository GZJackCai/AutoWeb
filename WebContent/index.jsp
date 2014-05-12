<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/new_index.js"></script>
</head>

<body>
	<!--聊天窗口-->
	<div id="float">
		<div class="consulting">
			<div class="consulting_list">
				<a class="fl zaixian" href="#" target="_blank">在线</a> <span
					class="fl">客服邀请您聊天</span> <a class="fr dianhua" href="#"
					target="_blank">电话</a>
			</div>
			<p class="consulting_q">您好，请问有什么需要帮到您的吗？</p>
			<p class="consulting_btn">
				<a class="fl jslt_btn" href="#" target="_blank">接受聊天</a><a
					class="fl jslt_btn" href="#" target="_blank">取消</a>
			</p>
		</div>
	</div>
	<!--导航 开始-->
	<%@ include file="/WEB-INF/nav.jsp"%>
	<!--导航 结束-->
	<!--搜索 开始-->
	<%@ include file="/WEB-INF/search.jsp"%>
	<!--搜索 结束-->
	<!---->
	<div class="box">
		<ul class="list01_lf fl">
			<li><a href="#" target="_blank"><img src="images/img01.jpg"
					width="225" height="80" alt="" /></a></li>
			<li><a href="#" target="_blank"><img src="images/img01.jpg"
					width="225" height="80" alt="" /></a></li>
			<li><a href="#" target="_blank"><img src="images/img01.jpg"
					width="225" height="80" alt="" /></a></li>
		</ul>
		<!--焦点图 开始-->
		<div class="list01_center fl">
			<div class="kp_list01_lf" id="focus">
				<ul>
					<li><a href="http://wh.001car.com/2014/05/08/7030.shtml"
						target="_blank"><img
							src="http://mat.001car.com/wh/tupian/201405/2014050801.jpg"
							height="260" width="515" alt="宝马2系敞篷版低伪谍照 或巴黎车展发布" /></a></li>
					<li><a href="http://wh.001car.com/2014/05/07/6993.shtml"
						target="_blank"><img
							src="http://mat.001car.com/wh/tupian/201405/2014050701.png"
							height="260" width="515" alt="马6阿特兹上市会武汉龙泰店火热招募中" /></a></li>
					<li><a href="http://wh.001car.com/2014/05/06/6978.shtml"
						target="_blank"><img
							src="http://mat.001car.com/wh/tupian/201405/2014050601.jpg"
							height="260" width="515" alt="中国男生在美国驾20万美金法拉利跑车遇车祸身亡" /></a></li>
					<li><a href="http://wh.001car.com/2014/05/04/6893.shtml"
						target="_blank"><img
							src="http://mat.001car.com/wh/tupian/201405/2014050401.jpg"
							height="260" width="515" alt="过程一波三折 大众接近完成收购斯堪尼亚" /></a></li>
					<li><a href="http://wh.001car.com/2014/04/28/6819.shtml"
						target="_blank"><img
							src="http://mat.001car.com/wh/tupian/201404/2014042902.jpg"
							height="260" width="515" alt="锦里沟热情礼遇海恒新粤传祺“祺兵连”" /></a></li>
				</ul>
			</div>
		</div>
		<!--焦点图 end-->
		<div class="list01_rgt fr">
			<!--登录-->
			<div class="login">
				<span class="phone"></span>
				<ul class="login_box">
					<li><label>用户名</label> <input class="text login_text"
						type="text" value="" /></li>
					<li><label>用户名</label> <input class="text login_text"
						type="text" value="" /></li>
					<li><input class="login_btn" type="button" value="登录" /><input
						class="login_btn" type="button" value="免费注册" /></li>
				</ul>
				<div class="list_rgt_img">
					<img src="images/img01.jpg" width="230" height="80" alt="" />
				</div>
			</div>
		</div>
		<!--list02 开始-->
		<div class="cl list02">
			<!--集团新闻-->
			<div class="newsbox fl mt10">
				<div class="news">
					<div class="news_title">集团新闻</div>
					<ul class="news_list">
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
					</ul>
					<a class="news_more" href="#" target="_blank">更多...</a>
				</div>
			</div>
			<!--集团新闻-->
			<div class="newsbox fl mt10 ml10">
				<div class="news">
					<div class="news_title">大事记</div>
					<ul class="news_list">
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
						<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季</a></li>
					</ul>
					<a class="news_more" href="#" target="_blank">更多...</a>
				</div>
			</div>
			<!--集团新闻-->
			<div class="newsbox fr mt10">
				<div class="news">
					<div class="news_title">集团介绍</div>
					<div class="news_txt">
						<p>优6采用与纳智捷 5
							Sedan相同平台，车身长宽高分别为4625/1825/1645mm，轴距为2720mm。优6外观看上去俨然就是新款U7的缩小版，但相对小一级的体型少了一丝粗犷，多了一分跨界风。</p>
						<p class="pt10">优6采用与纳智捷 5
							Sedan相同平台，车身长宽高分别为4625/1825/1645mm，轴距为2720mm。优6外观看上去俨然就是新款U7的缩小版，但相对小一级的体型少了一丝粗犷，多了一分跨界风。</p>
					</div>
					<a class="news_more" href="#" target="_blank">详情...</a>
				</div>
			</div>
		</div>
		<!-- 配件分类 开始-->
		<div class="cl fittingclass fl">
			<h1 class="title_index">产品列表</h1>
			<div class="classbox" id="widgetList0">
			</div>
			<a class="news_more" href="jaxrs/widget/list" target="_blank">更多...</a>
		</div>
		<!-- 配件分类 结束-->
		<div class="fittingclass fr" id="pushWidgetList">
			<h1 class="title_index">产品列表</h1>
			<div class="fittingclass_bg01"></div>
			<div class="fittingclass_bg02"></div>
			
		</div>
		<!--汽车维修查询 开始-->
		<div class="cl servicesearch fl">
			<dl class="service_box">
				<dt>汽车维修故障查询：</dt>
				<dd>
					<input class="service_text fl" type="text" value="" /><a
						class="service_btn fr" href="#">查询</a>
				</dd>
			</dl>
			<div class="service_list">
				<h2>常用故障列表</h2>
				<ul>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
					<li><a href="#" target="_blank">武汉宝泽10周年庆盛大开启—狂潮第一季？</a></li>
				</ul>
			</div>
		</div>
		<!--汽车维修查询 结束-->
		<!--汽车品牌 开始-->
		<div class="car fl">
			<h1 class="car_titile">品牌列表</h1>
			<div class="car_list">
				<dl>
					<dt>A-F</dt>
					<dd>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
					</dd>
				</dl>
				<dl>
					<dt>A-F</dt>
					<dd>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
					</dd>
				</dl>
				<dl>
					<dt>A-F</dt>
					<dd>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
					</dd>
				</dl>
				<dl>
					<dt>A-F</dt>
					<dd>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
						<a href="#" target="_blank">奥迪</a> <a href="#" target="_blank">奥迪</a>
					</dd>
				</dl>
			</div>
		</div>
		<!--汽车品牌 结束-->
		<!--维修视频 开始-->
		<div class="video fr">
			<h2 class="video_title">维修视频</h2>
			<ul class="video_list">
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
				<li><a href="#" target="_blank"><img src="images/img03.jpg"
						width="110" height="60" alt="" /></a></li>
			</ul>
		</div>
		<!--维修视频 结束-->
	</div>
<!-- 底部开始 -->
<%@ include file="/WEB-INF/footer.jsp"%>
<!-- 底部结束 -->
	<script>
	$(function(){
		// 加载产品列表
		var widgetListURL = "jaxrs/ui/autoWidgetList";
		$.getJSON(widgetListURL, function(data){
			console.log("widgetListURL=>", data)
			var div0 = $("#widgetList0");
			var div0_dl = $("<dl/>");
			$.each(data[0], function(k, v){				
				//<dt>发动机</dt>
				$("<dt>"+v.type+"</dt>").appendTo(div0_dl);
				div0_dl.appendTo(div0);
				var div0_dd = $("<dd/>");
				div0_dl.append(div0_dd);
				$.each(v.widgets, function(k, v){
					div0_dd.append($("<a href=\"<%=request.getContextPath()%>/jaxrs/brand/"+ v.widget.id +"\" target=\"_blank\">"+ v.widget.name +"</a><em>|</em>"));
				});
					
				
			})
			
			//pushWidgetList
			var div1 = $("#pushWidgetList");
		
			$.each(data[1], function(k, v){
					//<dt>发动机</dt>
					var div_img = $("<div class=\"class_img\"></div>");
					var div_p = $("<p class=\"cp_hd\" >推荐产品:"+v.type+"</p>")
					div_img.append(div_p)
					
					var div1_ul = $("<ul/>");
					$.each(v.widgets, function(k, v){
						var li = $("<li><a href=\"<%=request.getContextPath()%>/jaxrs/brand/"+ v.widget.id +"\" target=\"_blank\"> <img alt=\""+v.widget.name+"\" src="+v.widget.img+" height=\"55\" width=\"55\" >"+v.widget.name+"</img></a></li>");
						div1_ul.append(li)
					})
					div_img.append(div1_ul)
					div1.append(div_img);
			})
		});
	});
</script>
</body>
</html>


