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
import com.kh.nuriter.nuriter.model.vo.Nuriter;
import com.kh.nuriter.nuriter.model.vo.PageInfo;

/**
 * Servlet implementation class SelectNuribossMyNuriterListServlet
 */
@WebServlet("/selectNuribossNuriterList.nu")
public class SelectNuribossMyNuriterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectNuribossMyNuriterListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("승인된 누리장의 누리터목록 가져오는 서블릿 이동 완료!");
		String userNum = request.getParameter("userNum");
		System.out.println("유저번호 : " + userNum);

		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		currentPage = 1;

		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount = new NuriterService().getListCount(userNum);

		limit = 5;

		maxPage = (int)((double)listCount / limit + 0.9) ;

		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;

		endPage = startPage + limit - 1;

		if(maxPage < endPage){
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Nuriter> list = new NuriterService().selectEndedNuriterList(currentPage, limit, userNum);
		System.out.println("기간 끝난 누리터 목록 : " + list);
		
		String page = "";
		
		if(list != null){
			page="views/admin/giveMoneyToNuriboss.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "기간 끝난 누리터 조회 실패!");
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
