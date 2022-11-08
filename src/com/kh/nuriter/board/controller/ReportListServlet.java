package com.kh.nuriter.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.board.model.sevice.BoardService;
import com.kh.nuriter.board.model.vo.reportNuri;
import com.kh.nuriter.notice.model.vo.PageInfo;

/**
 * Servlet implementation class ReportListServlet
 */
@WebServlet("/reportlist.rl")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이징 처리
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage=1;
		System.out.println("오니,,");
		
		if(request.getParameter("currentPage") != null){
			currentPage =Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new BoardService().reportListCount();
		
		limit =10;
		
		maxPage =(int)((double)listCount /limit +0.9);
		
		startPage = (((int)((double)currentPage / limit +0.9))-1) *10+ 1;
		
		endPage = startPage + limit -1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<reportNuri> rlist = new BoardService().selectReportList(currentPage, limit);
		
		String page ="";
		
		if(rlist != null){
			page="views/admin/reportedNuriboss.jsp";
		
			request.setAttribute("rlist", rlist);
			request.setAttribute("pi", pi);
			
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "실패 ");
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
