package com.care.listener;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.care.config.Config;
import com.care.utils.JSONUtil;

/**
 * Application Lifecycle Listener implementation class Bootstarp
 * 
 */
@WebListener
public class Bootstarp implements ServletContextListener {
	private Logger log = LoggerFactory.getLogger(getClass());
	private static ApplicationContext ctx;
	private static Config config;
	private static String spt = File.separator;
	private static String CONF_PATH="confPath";

	public void contextInitialized(ServletContextEvent event) {
		try {
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			ServletContext servletContext = event.getServletContext();
			// -DconfURI=
			String confPath = System.getProperty(CONF_PATH, servletContext.getInitParameter(CONF_PATH));
			if (StringUtils.isEmpty(confPath)) {
				Path path = FileSystems.getDefault().getPath(servletContext.getRealPath("/"));
				confPath = path.getParent().toString() + spt + "config";
			}
			log.info("Loading confPath:{}", confPath);
			// 初始化conf.xml配置
			config = Config.getInstance(confPath+spt+"config.xml");
			//log.info("Config:{}", JSONUtil.toJson(config));

			// 初始化spring容器
			String os = System.getProperty("os.name");
			String pre = "";
			if(os.equals("Linux")){
				pre = "file://";
			}
			String springXml = pre  + confPath + spt + "spring.xml";
			log.info("Loading spring:{}", springXml);
			ctx = new FileSystemXmlApplicationContext(springXml);
			log.info("ApplicationContext:{}", JSONUtil.toJson(ctx.getBeanDefinitionNames()));
		} catch (Exception e) {
			log.error("contextInitialized", e);
			//System.exit(-1);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}

	public static Config getConfig() {
		return config;
	}
}
