package com.open.myBoard.mainboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.open.myBoard.common.utile.BaseController;
import com.open.myBoard.common.utile.SHAUtile;
import com.open.myBoard.common.utile.StringUtile;
import com.open.myBoard.mainboard.service.MainBoardService;
import com.open.myBoard.mainboard.vo.BoardVO;

@Controller
public class MainBoardController extends BaseController {

	private String viewPath = "/mainBoard/";
	
	@Autowired
	private MainBoardService mainBoardService;
	
	@RequestMapping(value = "/mainBoardView.do")
	public @ResponseBody ModelAndView mainBoardView(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		modelAndView.setViewName("home");
		
		return modelAndView;
	}

	@RequestMapping(value = "/mainBoardList.do")
	public @ResponseBody ModelAndView mainBoardList(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		String category = StringUtile.convertDefulte(request.getParameter("category"),"1");
	
		BoardVO boardVO = new BoardVO();
		boardVO.setCategory(category);
		
		List<BoardVO> boardVOList = mainBoardService.getBoardList(boardVO);
		
		log.debug(" ddd " + boardVO.getSeq());
		
		modelAndView.addObject("boardVoList", boardVOList);
		modelAndView.setViewName( viewPath + "listView");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/writeView.do")
	public @ResponseBody ModelAndView writeView(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		modelAndView.setViewName( viewPath + "write");
		return modelAndView;
	}

	@RequestMapping(value = "/insertBoard.do")
	public @ResponseBody ModelAndView insertBoard(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		String title = (String) request.getParameter("title");
		String text = (String) request.getParameter("text");
		String writer = (String) request.getParameter("writer");
		String password= (String) request.getParameter("password");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setText(text);
		boardVO.setWriter(writer);
		boardVO.setPassword(SHAUtile.sha1(password));
		
		String seq = mainBoardService.selectSeq();
		boardVO.setSeq(Integer.parseInt(seq));
		
		mainBoardService.insertWriteData(boardVO);
		
		//modelAndView.setViewName("/mainBoard/listView");
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/view.do")
	public @ResponseBody ModelAndView view(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		String seq = request.getParameter("seq");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(seq));
		
		List<BoardVO> boardVOList = mainBoardService.getBoardList(boardVO);

		if (boardVOList.size() == 0) {
			throw new Exception("게시글이 없습니다.");
		}
		
		modelAndView.setViewName( viewPath + "view");
		modelAndView.addObject("getWrite", boardVOList.get(0));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateBoard.do")
	public @ResponseBody ModelAndView updateBoard(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("=========" + request.getRequestURL() + "=========");
		
		String seq = (String) request.getParameter("seq");
		String title = (String) request.getParameter("title");
		String text = (String) request.getParameter("text");
		String writer = (String) request.getParameter("writer");
		String password= (String) request.getParameter("password");

		BoardVO boardVO = new BoardVO();
		
		boardVO.setSeq(Integer.parseInt(seq));
		boardVO.setTitle(title);
		boardVO.setText(text);
		boardVO.setWriter(writer);
		boardVO.setPassword(password);
		
		mainBoardService.updateWriteData(boardVO);
		
		//modelAndView.setViewName("/mainBoard/listView");
		modelAndView.setViewName( viewPath + "write");
		
		return modelAndView;
	}

	
	
	
}
