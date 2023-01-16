package kr.co.vita.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.vita.util.ParserUtil;

@RestController
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger("LoggerController");
	
	@Autowired
	BoardService service;
	
	
	@PostMapping("/api/board/boardList")
    public HashMap<String, Object> boardList(HttpServletRequest request) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ParserUtil putil = new ParserUtil();
		HashMap<String, Object> param = null;
		param = putil.httpParameter(request);
		param.put("pageSize", (param.get("page") == "1" ? "0" : ((Integer.parseInt(param.get("page").toString())-1) * 10)));
		logger.info("Parameter:"+param.toString());
		List<HashMap<String, Object>> result = null;
		try {
			result = service.boardList(param);
			res.put("result", result);
			res.put("totCount", service.boardListCount(param));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			res.put("rtnMsg", "Fail");
			res.put("rtnCode", "99");
		}
		return res;
    }
	
	@PostMapping("/api/board/boardInsert")
    public HashMap<String, Object> boardInsert(HttpServletRequest request) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ParserUtil putil = new ParserUtil();
		HashMap<String, Object> param = null;
		param = putil.httpParameter(request);
		logger.info("Parameter:"+param.toString());
		List<HashMap<String, Object>> result = null;
		try {
			service.boardInsert(param);
			res.put("rtnMsg", "Success");
			res.put("rtnCode", "00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			res.put("rtnMsg", "Fail");
			res.put("rtnCode", "99");
		}
		return res;
    }
	
	@PostMapping("/api/board/boardDtlSearch")
	public HashMap<String, Object> boardDtlSearch(HttpServletRequest request) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ParserUtil putil = new ParserUtil();
		HashMap<String, Object> param = null;
		param = putil.httpParameter(request);
		logger.info("Parameter:"+param.toString());
		try {
			try {
				service.updBoardDtlSearchHit(param);
			} catch(Exception e) {
			}
			res.put("result", service.boardDtlSearch(param));
			res.put("rtnMsg", "Success");
			res.put("rtnCode", "00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			res.put("rtnMsg", "Fail");
			res.put("rtnCode", "99");
		}
		return res;
    }

}