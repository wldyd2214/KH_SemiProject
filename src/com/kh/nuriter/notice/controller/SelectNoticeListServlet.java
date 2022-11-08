package com.kh.nuriter.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.notice.model.vo.Notice;
import com.kh.nuriter.notice.model.vo.PageInfo;

/**
 * Servlet implementation class SelectNoticeListServlet
 */
@WebServlet("/selectList.no")
public class SelectNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectNoticeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징처리
		int currentPage;	// 현재 페이지 번호
		int limit;			// 한 페이지에 나타낼 게시글 수
		int maxPage;		// 가장 마지막 페이지
		int startPage;		// 현재 페이지에서 첫번째 페이지 번호
		int endPage;		// 현재 페이지에서 마지막 페이지 번호
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//공지사항 개수 조회
		int listCount = new NoticeService().getListCount();
		
		limit = 5;
		maxPage = (int)((double)listCount / limit + 0.9) ;
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		//공지사항 목록 조회
		ArrayList<Notice> list = new NoticeService().selectList(currentPage, limit);

		String page = "";

		if(list != null){
			page="views/notice/notice.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회 실패!");
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
