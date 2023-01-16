package kr.co.vita.mapper;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

public interface HomeMapper {
	public List<HashMap<String, Object>> testList() throws Exception;
}
