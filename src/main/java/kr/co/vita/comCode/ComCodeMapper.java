package kr.co.vita.comCode;

import java.util.HashMap;
import java.util.List;


public interface ComCodeMapper {
	
	public List<HashMap<String, Object>> comCodeGrpList(HashMap<String, Object> param) throws Exception;
	
}