package com.krakentouch.server.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	// 日志
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);
	/**  
	* 将byte[]转换成string    
	* @param butBuffer  
	*/  
	public static String byteToString(byte [] b){   
	       StringBuffer stringBuffer = new StringBuffer();   
	       for (int i = 0; i < b.length; i++)   
	       {   
	           stringBuffer.append((char) b [i]);   
	       }   
	       return stringBuffer.toString();   
	}   
	  
	/**  
	* 将bytebuffer转换成string    
	* @param str  
	*/  
	public static IoBuffer stringToIoBuffer(String str){   
	  
	       byte bt[] = str.getBytes();   
	  
	       IoBuffer ioBuffer = IoBuffer.allocate(bt.length);   
	       ioBuffer.put(bt, 0, bt.length);   
	       ioBuffer.flip();   
	       return ioBuffer;   
	}   
	/**  
	* 将IoBuffer转换成string    
	* @param str  
	*/  
	public static IoBuffer byteToIoBuffer(byte [] bt,int length){   
	  
	       IoBuffer ioBuffer = IoBuffer.allocate(length);   
	       ioBuffer.put(bt, 0, length);   
	       ioBuffer.flip();   
	       return ioBuffer;   
	}   
	/**  
	* 将IoBuffer转换成byte    
	* @param str  
	*/  
	public static byte [] ioBufferToByte(Object message){   
	      if (!(message instanceof IoBuffer))   
	      {   
	          return null;   
	      }   
	      IoBuffer ioBuffer = (IoBuffer)message;   
	      byte[] b = new byte[ioBuffer.limit()];   
	      ioBuffer.get(b);   
	      return b;   
	}   
	/**  
	* 将IoBuffer转换成string    
	* @param butBuffer  
	*/  
	public static String ioBufferToString(Object message){   
	      if (!(message instanceof IoBuffer))   
	      {   
	        return "";   
	      }   
	      IoBuffer ioBuffer = (IoBuffer) message;   
	      byte[] b = new byte [ioBuffer.limit()];   
	      ioBuffer.get(b);   
	      StringBuffer stringBuffer = new StringBuffer();   
	  
	      for (int i = 0; i < b.length; i++)   
	      {   
	  
	       stringBuffer.append((char) b [i]);   
	      }   
	       return stringBuffer.toString();   
	} 
	
	
	/***
	 * 解析XML格式的命令
	 * @param commandStr
	 * @return 包含命令的map
	 * @throws DocumentException 
	 */
	public static Map<String,String> parseCommand(String commandStr) throws DocumentException{
		LOG.debug("parseCommand(String commandStr) " + commandStr);
		Map<String,String> retMap = new HashMap<String,String>();
		Document doc = null;
		try {
			//去除首尾的空格
			commandStr = commandStr.trim();
			doc = DocumentHelper.parseText(commandStr); // 将字符串转为XML
			LOG.debug("doc: " + doc);
			Element rootElt = doc.getRootElement(); // 获取根节点
			LOG.debug("rootElt: " + rootElt);
			Iterator<?> it = rootElt.elementIterator();
			while(it.hasNext()){
				Element element = (Element) it.next();
				//是否该元素只含有text或是空元素
				if(element.isTextOnly()){
					String name = element.getName();
					String value = element.getText();
					retMap.put(name, value);
				}else{
					Iterator<?> elementIt = element.elementIterator();
					while(elementIt.hasNext()){
						Element element2 = (Element) elementIt.next();
						//是否该元素只含有text或是空元素
						if(element2.isTextOnly()){
							String name = element2.getName();
							String value = element2.getText();
							retMap.put(name, value);
						}
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
			throw e;
		}
		return retMap;
	}

}
