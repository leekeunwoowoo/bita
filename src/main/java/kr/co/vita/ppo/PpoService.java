package kr.co.vita.ppo;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PpoService {
    
    @Autowired
    PpoMapper boardMapper;
    
    public List<HashMap<String, Object>> selPpoList(HashMap<String, Object> param) throws Exception{
        return boardMapper.selPpoList(param);
    }
    
    public int selPpoListCount(HashMap<String, Object> param) throws Exception{
        return boardMapper.selPpoListCount(param);
    }
    /*
    public int boardInsert(HashMap<String, Object> param) throws Exception{
    	return boardMapper.boardInsert(param);
    }
    
    public HashMap<String, Object> boardDtlSearch(HashMap<String, Object> param) throws Exception{
        return boardMapper.boardDtlSearch(param);
    }
    
    public int updBoardDtlSearchHit(HashMap<String, Object> param) throws Exception{
    	return boardMapper.updBoardDtlSearchHit(param);
    }
	*/
}