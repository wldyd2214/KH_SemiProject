package com.kh.nuriter.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.notice.model.vo.Notice;

/**
 * Servlet implementation class SelectOneNoticeServlet
 */
@WebServlet("/selectOne.no")
public class SelectOneNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		System.out.println("num : " + num);
		
		Notice n = new NoticeService().selectOne(num);
		
		String page = "";
		
		if(n != null){
			page = "views/notice/noticeDetail.jsp";
			request.setAttribute("n", n);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세보기 실패!");
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
