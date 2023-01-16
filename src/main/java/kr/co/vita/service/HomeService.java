package kr.co.vita.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.vita.mapper.HomeMapper;
 
@Service
public class HomeService {
    
    @Autowired
    HomeMapper homeMapper;
    
    public List<HashMap<String, Object>> testList() throws Exception{
        
        return homeMapper.testList();
        
    }
}