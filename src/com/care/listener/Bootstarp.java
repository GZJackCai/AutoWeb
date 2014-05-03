package com.care.listener;

import java.io.File;
import java.net.URI;
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
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.care.config.Config;
import com.care.utils.HttpUtil;
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

	public void contextInitialized(ServletContextEvent event) {
		try {
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			ServletContext servletContext = event.getServletContext();
			// -DconfURI=
			String rootURIStr = System.getProperty("confURI", servletContext.getInitParameter("confURI"));
			if (StringUtils.isEmpty(rootURIStr)) {
				Path path = FileSystems.getDefault().getPath(servletContext.getRealPath(spt));
				rootURIStr = "file://" + path.getParent().toString() + spt + "config";
			}
			log.info("Loading RootURIStr:{}", rootURIStr);
			// 初始化conf.xml配置
			URI confURI = HttpUtil.buildURI(rootURIStr + spt + Config.FILE_NAME, null);
			config = Config.getInstance(confURI);
			log.info("Config:{}", JSONUtil.toJson(config));

			// 初始化spring容器
			String springXml = rootURIStr + spt + "spring.xml";
			log.info("Loading spring:{}", springXml);
			Resource res = new UrlResource(springXml);
			ctx = new GenericXmlApplicationContext(res);
			log.info("ApplicationContext:{}", JSONUtil.toJson(ctx.getBeanDefinitionNames()));
		} catch (Exception e) {
			log.error("contextInitialized", e);
			System.exit(-1);
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
