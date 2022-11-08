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
 * Servlet implementation class SelectNuriBossDetailListServlet
 */
@WebServlet("/selectNuriBossDetailList.nu")
public class SelectNuriBossDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNuriBossDetailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }                                                                                                                                                                                                                                                                                                             

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		currentPage = 1;

		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount = new NuriterService().getNuribossListCount();

		limit = 5;

		maxPage = (int)((double)listCount / limit + 0.9) ;

		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;

		endPage = startPage + limit - 1;

		if(maxPage < endPage){
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		
		ArrayList<Nuriboss> bossList = new NuriterService().selectNuribossList(currentPage, limit);
		
		System.out.println("누리장 신청회원 전체보기 이동 완료!");
		
		String page = "";
		
		if(bossList != null){
			page="views/admin/nuribossAllList.jsp";
			request.setAttribute("bossList", bossList);
			request.setAttribute("pi", pi);
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "누리장 신청회원 조회 실패!");
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
