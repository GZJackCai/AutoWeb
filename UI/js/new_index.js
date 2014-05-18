// JavaScript Document
/* 
 * 武汉站首页JS
 */
if (typeof $ == 'undefined') {
    var $ = jQuery;
}
$(function() {

    var sWidth = $("#focus").width(); //获取焦点图的宽度（显示面积）
    var len = $("#focus ul li").length; //获取焦点图个数
    var index = 0;
    var picTimer;

    //以下代码添加数字按钮和按钮后的半透明条，还有上一页、下一页两个按钮
    var btn = "<div class='btnBg'></div><div class='btn'>";
    for (var i = 0; i < len; i++) {
        btn += "<span></span>";
    }
    btn += "</div><div class='preNext pre'></div><div class='preNext next'></div>";
    $("#focus").append(btn);
    $("#focus .btnBg").css("opacity", 0.5);

    //为小按钮添加鼠标滑入事件，以显示相应的内容
    $("#focus .btn span").css("opacity", 0.4).mouseenter(function() {
        index = $("#focus .btn span").index(this);
        showPics(index);
    }).eq(0).trigger("mouseenter");

    //上一页、下一页按钮透明度处理
    $("#focus .preNext").css("opacity", 0.2).hover(function() {
        $(this).stop(true, false).animate({"opacity": "0.5"}, 300);
    }, function() {
        $(this).stop(true, false).animate({"opacity": "0.2"}, 300);
    });

    //上一页按钮
    $("#focus .pre").click(function() {
        index -= 1;
        if (index == -1) {
            index = len - 1;
        }
        showPics(index);
    });

    //下一页按钮
    $("#focus .next").click(function() {
        index += 1;
        if (index == len) {
            index = 0;
        }
        showPics(index);
    });

    //本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度
    $("#focus ul").css("width", sWidth * (len));

    //鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
    $("#focus").hover(function() {
        clearInterval(picTimer);
    }, function() {
        picTimer = setInterval(function() {
            showPics(index);
            index++;
            if (index == len) {
                index = 0;
            }
        }, 4000); //此4000代表自动播放的间隔，单位：毫秒
    }).trigger("mouseleave");

    //显示图片函数，根据接收的index值显示相应的内容
    function showPics(index) { //普通切换
        var nowLeft = -index * sWidth; //根据index值计算ul元素的left值
        $("#focus ul").stop(true, false).animate({"left": nowLeft}, 300); //通过animate()调整ul元素滚动到计算出的position
        //$("#focus .btn span").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
        $("#focus .btn span").stop(true, false).animate({"opacity": "0.4"}, 300).eq(index).stop(true, false).animate({"opacity": "1"}, 300); //为当前的按钮切换到选中的效果
    }





    /*导航下拉菜单*/
    $("ul.nav_rgt li a.top_nav_a").live('mouseover', function() {
        $("ul.nav_rgt li div.nav_erji").hide();
        $(this).next().fadeIn(100, function() {
        });
    });
    $("div.box, div.main_nav, div.glob_nav").live('mouseover', function() {
        $("div.nav_erji").fadeOut(100, function() {
        });
    });

    /*资讯－最新上市、即将上市*/
    $("ul.sp_nclisting_tit li").live('mouseover', function() {
        $("ul.sp_nclisting_tit li").removeClass("nchover");
        $(this).addClass("nchover");
        var index = $(this).attr('index');
        $("#cars-table-wrapper table").hide();
        $("#cars-table-" + index).show();
    });

    /*300宽焦点图自动更新*/
    scrollImageFo300Focus("#slider-images-1 li");
    scrollImageFo300Focus("#slider-images-2 li");
    scrollImageFo300Focus("#slider-images-3 li");
    function scrollImageFo300Focus(name) {
        $(name + ':first').siblings().hide();
        setInterval(function() {
            $(name + ':visible').fadeOut('100', function() {
                $(this).next()[0] === undefined ?
                        $(name + ':first').fadeIn("slow") : $(this).next().fadeIn("slow");
            });
        }, 6000)
    }

    /*热销车型小型顶级替换*/
    $("ul.hotcar_hd li").mouseover(function(){
        var idx = $(this).index();
        $("div.cooperation").children().hide();
        $("div.cooperation").children().eq(idx).fadeIn(800);
    });

    /*热销车型小型、微型...替换*/
    $("div.cooperation_hd ul li").mouseover(function(){
        var idx = $(this).index();
        var father = $(this).parent();
        $(father).children().removeClass('cooperation_selected');
        $(this).addClass('cooperation_selected');
        
        var container = $(this).parent().parent().next();
        $(container).children().hide();
        $(container).children().eq(idx).fadeIn(700);
    });
    
    /*横向滚动样式*/
    function scrollHeng(ye){
        $(ye).parent().children().removeClass('yuan_01');
        $(ye).addClass('yuan_01');
        var idx = $(ye).index();
        var toObject = $(ye).parent().attr('to');
        var moveX = parseInt($(ye).parent().attr('move'));
        var moveLeft = moveX * idx;
        var currentMarginLeft = parseInt($("#"+toObject).css('marginLeft'));
        moveLeft = moveLeft + currentMarginLeft;
        event.preventDefault();
        $("#"+toObject).animate({  
            marginLeft: "-="+moveLeft+"px" 
        }, "normal");
    }    
    $('ul.yema_yuan li').click(function() {
        //点加上样式
        scrollHeng($(this));
    });

    //行情_购车优惠点击样式
    $("a.hq_list_phe").live('click',function(){
       var ph = $(this).attr('ph');
       alert('联系电话：'+ph);
    }); 
    
    //选车中心TAB点击样式控制
     $("#choose_tabs li a").live('mouseover', function() {
         $("a.choose_nav_up").removeClass("choose_nav_up");
         $(this).addClass("choose_nav_up");
         var toTab = $(this).attr("to");
         $("div.choose_cnt").hide();
         $("#"+toTab).show();
    });

});


/*导航*/
//所有页面加载完成后的样式，放在这里  
$(window).load(function(){
    //导航样式
    $('ul#nav_all li').bind('mouseover',function(){
        //父菜单高亮
        $(this).parent().children().removeAttr('class');
        $(this).addClass('nav_hover');
        //子菜单高亮
        if($(this).children().size() > 1){  //有子菜单的才高亮子菜单，排除 “网站首页”
            $('div.ch_menu').addClass('hide');
            $(this).children('div').removeClass('hide');
        }
    });
//    $('ul#nav_all li').bind('mouseout',function(){
//        $(this).parent().children().removeAttr('class');
//        $(this).children('div').addClass('hide');
//        $("div.ch_menu").addClass('hide');
//    });
    $('div.ch_menu').bind('mouseout',function(){
                          $(this).parent().removeAttr('class');
                          $(this).addClass('hide');
    });
});    
