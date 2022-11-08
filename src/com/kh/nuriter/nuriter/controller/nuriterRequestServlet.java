package com.kh.nuriter.nuriter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nuriterRequestServlet
 */
@WebServlet("/requestNuriter.nu")
public class nuriterRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nuriterRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuriNum = request.getParameter("nuriNum");	
		String nuriTitle = request.getParameter("nuriTitle");
		String content = request.getParameter("content");
		
		request.setAttribute("nuriNum", nuriNum);
		request.setAttribute("nuriTitle", nuriTitle);
		request.setAttribute("content", content);
		
		System.out.println(nuriNum);
		System.out.println(nuriTitle);
		System.out.println(content);
		
		request.getRequestDispatcher("views/member/categoryUpdateDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
