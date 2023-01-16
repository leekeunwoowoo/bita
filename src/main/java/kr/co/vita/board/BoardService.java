package kr.co.vita.board;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    
    @Autowired
    BoardMapper boardMapper;
    
    public List<HashMap<String, Object>> boardList(HashMap<String, Object> param) throws Exception{
        return boardMapper.boardList(param);
    }
    
    public int boardInsert(HashMap<String, Object> param) throws Exception{
    	return boardMapper.boardInsert(param);
    }
    
    public int boardListCount(HashMap<String, Object> param) throws Exception{
        return boardMapper.boardListCount(param);
    }
    
    public HashMap<String, Object> boardDtlSearch(HashMap<String, Object> param) throws Exception{
        return boardMapper.boardDtlSearch(param);
    }
    
    public int updBoardDtlSearchHit(HashMap<String, Object> param) throws Exception{
    	return boardMapper.updBoardDtlSearchHit(param);
    }

}