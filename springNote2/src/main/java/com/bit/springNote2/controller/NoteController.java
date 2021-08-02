package com.bit.springNote2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.springNote2.dao.IDao;


@Controller
public class NoteController {
	
	@Autowired
	private SqlSession sqlSession; //servlet-context.xml에서 생선된 객체를 주입 받아서 사용
	
	@RequestMapping(value = "noteForm")
	public String noteForm() {
		return "noteForm";
	}
	
	@RequestMapping(value = "write")
	public String write(HttpServletRequest req, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(req.getParameter("writer"), req.getParameter("content"));
		return "redirect:list"; //noteList.jsp로 redirect
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		return "noteList"; //noteList.jsp 호출
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest req, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list"; //noteList.jsp로 redirect
	}
}
