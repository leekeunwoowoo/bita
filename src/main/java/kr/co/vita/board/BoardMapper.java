package kr.co.vita.board;

import java.util.HashMap;
import java.util.List;

public interface BoardMapper {
	public List<HashMap<String, Object>> boardList(HashMap<String, Object> param) throws Exception;
	public int boardListCount(HashMap<String, Object> param) throws Exception;
	public int boardInsert(HashMap<String, Object> param) throws Exception;
	public HashMap<String, Object> boardDtlSearch(HashMap<String, Object> param) throws Exception;
	public int updBoardDtlSearchHit(HashMap<String, Object> param) throws Exception;
}

