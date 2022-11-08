package com.kh.nuriter.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.board.model.sevice.BoardService;
import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.notice.model.vo.Notice;

/**
 * Servlet implementation class SelectqnaDetail
 */
@WebServlet("/selectqnadetail.sdq")
public class SelectqnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectqnaDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("num");
		
	      Notice n = new NoticeService().SelectqnaDetail(boardNum);
	      
	      String page = "";

			if(n != null){
				page = "views/notice/qnaDetail.jsp";
				request.setAttribute("n", n);
				
			}else{
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "상세보기 실패!");
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
