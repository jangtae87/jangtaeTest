package com.open.myBoard.common.utile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.open.myBoard.common.vo.ResultVo;

public class BaseController {
	
	protected static Logger log = LoggerFactory.getLogger(BaseController.class);

	public ModelAndView responseResultMap(ModelAndView modelAndView){
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setResultMsg("");
		
		modelAndView.addObject("data", resultVo);
		
		return modelAndView;
	}
	
}
