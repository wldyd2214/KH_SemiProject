package com.kh.nuriter.nuriter.controller;

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
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/insertComment.nu")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuriNum = request.getParameter("nuriNum");
		String content = request.getParameter("content");
		String writer = (String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber()));
		
		System.out.println("댓글 서블릿 도착: " + nuriNum + " " + content);
		
		int result = new NuriterService().insertNuriterComment(nuriNum, content, writer);
		
		ArrayList<HashMap<String, Object>> commentList = new NuriterService().selectNuriterComment(nuriNum);
		
		if(commentList != null) {
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
