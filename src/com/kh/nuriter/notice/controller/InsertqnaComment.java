package com.kh.nuriter.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class InsertqnaComment
 */
@WebServlet("/insertqnacomment.iqc")
public class InsertqnaComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertqnaComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String boardNum =request.getParameter("boardNum");
			String content =request.getParameter("content");
			String writer = (String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber()));
			
			
			System.out.println("보드넘"+boardNum);
			System.out.println(content);
			System.out.println(writer);
			
			
			int result = new NoticeService().InsertqnaComment(boardNum,content,writer);
			
			ArrayList<HashMap<String, Object>> commentList = new NoticeService().selectqnaComment(boardNum);
	
			if(commentList != null) {
				System.out.println("된거냐?");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(commentList, response.getWriter());
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
