package com.kh.nuriter.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.board.model.sevice.BoardService;
import com.kh.nuriter.board.model.vo.reportNuri;

/**
 * Servlet implementation class ReportapproveServlet
 */
@WebServlet("/reportapprove.rp")
public class ReportapproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportapproveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num =request.getParameter("num");
		String ownerNum = request.getParameter("ownerNum");
		 int result = new BoardService().reportapprove(ownerNum);
		 
		 
		 
		 
		 
		 if(result >0){
			 response.sendRedirect(request.getContextPath()+"/reportlist.rl");
		 }else{
				request.setAttribute("msg", "공지사항 수정 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
