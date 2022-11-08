package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet({"/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		System.out.println("오니?");
		ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
		ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
		ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
		/*String page = "";*/
		
		request.getSession().invalidate();
		/*page = "index.jsp";
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
		request.setAttribute("pictureList", pictureList);
		request.setAttribute("pictureList2", pictureList2);
		request.setAttribute("pictureList3", pictureList3);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		/*response.sendRedirect("index.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
