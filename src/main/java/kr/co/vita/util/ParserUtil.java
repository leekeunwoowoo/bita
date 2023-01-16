package kr.co.vita.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ParserUtil {
	
	public HashMap<String, Object> httpParameter(HttpServletRequest request) {
		Enumeration<String> paramKeys = request.getParameterNames();
		HashMap<String, Object> map = new HashMap<String, Object>();
		while (paramKeys.hasMoreElements()) {
		     String key = paramKeys.nextElement();
		     map.put(key, request.getParameter(key));
		}
		return map;
	}
}
