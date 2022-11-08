package com.kh.nuriter.nuriter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

/**
 * Servlet implementation class UpdateNuriterServlet
 */
@WebServlet("/updateNuriter.nu")
public class UpdateNuriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNuriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result2 = 0;
		
		Nuriter n = null;
		
		String nuriNum = request.getParameter("nuriNum");
		String title = request.getParameter("nuriTitle");
		String content = request.getParameter("summerText");
		
		System.out.println(title);
		System.out.println(content);
		int result = new NuriterService().updateNuriter(nuriNum, title, content);
		
		if(result > 0) {
			result2 = new NuriterService().updateBoard(nuriNum, title, content);
			
			n = new NuriterService().selectOne(nuriNum);
		}else {
			result2 = 0;
		}
		
		String page = "";
		
		if(result2 > 0) {
			page = "views/member/categoryDetail.jsp";
			request.setAttribute("n", n);
			request.setAttribute("num", nuriNum);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 상세 조회 실패");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
