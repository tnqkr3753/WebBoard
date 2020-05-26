package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@RequestMapping("/getBoardList.do")
	public void getList(BoardVO vo, Model m) {
		//검 색 기 능 때문에 BoardVO를 지정 했지만 지금은 필요 없뜸
		List<BoardVO> list = service.getBoardList(vo);
		m.addAttribute("boardList",list);
	}
	@RequestMapping("/{step}.do")
	public String insertBoard(@PathVariable String step) { //하는일이 없는 컨트롤러 줄이기
		return step;
	}
	@RequestMapping("/saveBoard.do")
	public String saveBoard(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	@RequestMapping("/getBoard.do")
	public void getBoard(BoardVO vo,Model m) {
		m.addAttribute("board", service.getBoard(vo));
	}

}
