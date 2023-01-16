package kr.co.vita.comCode;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComCodeService {
    
    @Autowired
    ComCodeMapper mapper;
    
    public List<HashMap<String, Object>> comCodeGrpList(HashMap<String, Object> param) throws Exception{
        return mapper.comCodeGrpList(param);
    }
    
}