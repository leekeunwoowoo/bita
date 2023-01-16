package kr.co.vita.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.tools.packager.Log;

import kr.co.vita.service.HomeService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@RestController
@Slf4j
public class HomeController {
	
	@Autowired
	HomeService service;

    /**
     *
     * @return
    
    @GetMapping(value = {"/", "/index"})
    public String index() {
    	System.out.println("call servlet is root");
        return "/index";
    }
    */ 

	/**
     */
//	@CrossOrigin 
	@GetMapping("/api/boardList")
    public List<HashMap<String, Object>> boardList() {
		Log.info("====================================");
		List<HashMap<String, Object>> result = null;
		try {
			Log.info(service.testList().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("====================================");
		try {
			result = service.testList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }
	
	@GetMapping("/api/testList")
	public String SelectAllFromUser() {
		System.out.println("====================================");
		try {
			System.out.println(service.testList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====================================");
		return "asdf";
	}
	
	@GetMapping("/api/select/analytics")
	public String SelectAnalytics() {
		System.out.println("====================================");
		try {
			System.out.println(service.testList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====================================");
		return "asdf";
	}

}