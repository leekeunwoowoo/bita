package kr.co.vita.ppo;

import java.util.HashMap;
import java.util.List;

public interface PpoMapper {
	public List<HashMap<String, Object>> selPpoList(HashMap<String, Object> param) throws Exception;
	public int selPpoListCount(HashMap<String, Object> param) throws Exception;
	//public int boardInsert(HashMap<String, Object> param) throws Exception;
	//public HashMap<String, Object> boardDtlSearch(HashMap<String, Object> param) throws Exception;
	//public int updBoardDtlSearchHit(HashMap<String, Object> param) throws Exception;
}

