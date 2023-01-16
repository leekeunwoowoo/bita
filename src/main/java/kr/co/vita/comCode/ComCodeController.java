package kr.co.vita.comCode;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.vita.util.ParserUtil;

@RestController
public class ComCodeController {
	
	private final Logger logger = LoggerFactory.getLogger("ComCodeController");
	
	@Autowired
	ComCodeService service;
	
	
	@PostMapping("/api/comCode")
    public HashMap<String, Object> comCodeGrpList(HttpServletRequest request) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ParserUtil putil = new ParserUtil();
		HashMap<String, Object> param = null;
		param = putil.httpParameter(request);
		logger.info("Parameter:"+param.toString());
		List<HashMap<String, Object>> result = null;
		try {
			result = service.comCodeGrpList(param);
			res.put("result", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    }
	
	

}