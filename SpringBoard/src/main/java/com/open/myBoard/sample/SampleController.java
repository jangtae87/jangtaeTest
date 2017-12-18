package com.open.myBoard.sample;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.open.myBoard.common.utile.BaseController;
import com.open.myBoard.common.vo.ResultVo;
import com.open.myBoard.sample.service.SampleService;
import com.open.myBoard.sample.vo.ListVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SampleController extends BaseController {
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/sampleTest.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SQLException {
		log.debug("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		String gradeName = sampleService.getGradeName();
		
		log.debug("gradeName : " + gradeName);
		
		return "home";
	}
	

	@RequestMapping(value="/getJsonByVO")
	public @ResponseBody ResultVo getJsonByVO() {

		Calendar cal = Calendar.getInstance( );
	    ArrayList<ListVo> list = new ArrayList<ListVo>();
	    ListVo vo = null;
	    ResultVo objectVO = new ResultVo();

	    //1번째 데이터
	    vo = new ListVo();
	    vo.setIdx(1);
	    vo.setTitle("VO방식의 제목입니다");
	    vo.setCreate_date(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
	    list.add(vo);

	    //2번째 데이터
	    vo = new ListVo();
	    vo.setIdx(1);
	    vo.setTitle("VO방식의 제목입니다2");
	    vo.setCreate_date(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
	    list.add(vo);

	    //objectVO.setList(list);
	    objectVO.setSuccess(true);
	    objectVO.setTotal_count(10);

	    return objectVO; 
	}


	
}
