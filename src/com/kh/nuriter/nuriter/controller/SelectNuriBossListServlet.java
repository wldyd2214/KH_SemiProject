package com.kh.nuriter.nuriter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriboss;
import com.kh.nuriter.nuriter.model.vo.PageInfo;

/**
 * Servlet implementation class SelectNuriBossListServlet
 */
@WebServlet("/selectNuribossList.nu")
public class SelectNuriBossListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectNuriBossListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("누리보스 목록 불러오는 서블릿 이동 완료!");
		
		//페이징처리
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		int currentPage2;
		int maxPage2;
		int startPage2;
		int endPage2;

		currentPage = 1;
		currentPage2 = 1;

		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		if(request.getParameter("currentPage2") != null){
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		System.out.println("1번 : " +currentPage  );
		System.out.println("2번 : " +currentPage2  );

		int listCount = new NuriterService().getNuribossListCount();
		int listCount2 = new NuriterService().getNuribossListCount2();

		limit = 5;

		maxPage = (int)((double)listCount / limit + 0.9);
		maxPage2 = (int)((double)listCount2 / limit + 0.9);

		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		startPage2 = (((int)((double)currentPage2 / limit + 0.9)) -1) * limit + 1;

		endPage = startPage + limit - 1;
		endPage2 = startPage2 + limit - 1;


		if(maxPage < endPage){
			endPage = maxPage;
		}

		if(maxPage2 < endPage2){
			endPage2 = maxPage2;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		PageInfo pi2 = new PageInfo(currentPage2, listCount2, limit, maxPage2, startPage2, endPage2);

		ArrayList<Nuriboss> bossList = new NuriterService().selectNuribossList(currentPage, limit);
		ArrayList<Nuriboss> bossList2 = new NuriterService().selectNuribossList2(currentPage2, limit);

		String page = "";

		if(bossList.size() != 0){
			request.setAttribute("bossList", bossList);
			request.setAttribute("pi", pi);
		}
		page="views/admin/nuribossList.jsp";
		request.setAttribute("bossList2", bossList2);
		request.setAttribute("pi2", pi2);
		
		
		
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
