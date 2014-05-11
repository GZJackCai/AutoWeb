package com.care.config;

import java.io.Serializable;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.FileUtils;

import com.care.utils.XMLUtil;

/**
 * 
 * @author gaojie/joy gaojie314@gmail.com http://my.oschina.net/u/139611
 */
@XmlRootElement
public class Config implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FILE_NAME = "config.xml";
	private static Config instance;

	public static void refresh(String confBaseURI) {
		try {
			instance = XMLUtil.parseXml(FileUtils.getFile(confBaseURI), Config.class);
		} catch (JAXBException e) {
			System.err.printf("%s: 解析出错!\n", confBaseURI.toString());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		} finally {
			if (instance == null)
				System.exit(1);
		}
	}
	public static Config getInstance(String confURI) throws URISyntaxException {
		refresh(confURI);
		return instance;
	}

	public static Config getInstance() {
		return instance;
	}


}
