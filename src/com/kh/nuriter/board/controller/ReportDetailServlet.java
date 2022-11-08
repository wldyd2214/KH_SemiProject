package com.kh.nuriter.board.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.board.model.sevice.BoardService;
import com.kh.nuriter.board.model.vo.reportNuri;

/**
 * Servlet implementation class ReportDatailServlet
 */
@WebServlet("/reportdetail.rd")
public class ReportDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String userNum = request.getParameter("userNum");
		String ownerNum = request.getParameter("ownerNum");
		String bTitle =request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bDate =request.getParameter("bDate");
		
		java.sql.Date reportDate = null;
	      
	      if(bDate != "" || bDate != null) {
	         String[] dateArr = bDate.split("-");
	         
	         int[] arr = new int[dateArr.length];
	         
	         for(int i = 0; i < dateArr.length; i++) {
	            arr[i] = Integer.parseInt(dateArr[i]);
	         }
	         
	         reportDate = new java.sql.Date(new GregorianCalendar(arr[0], arr[1] - 1, arr[2]).getTimeInMillis());
	         
	         System.out.println(reportDate);
	      }else {
	    	  reportDate = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
	      }
		
		/*System.out.println("num : "+num);
		System.out.println("userNum : "+userNum);
		System.out.println("ownerNum :"+ownerNum);
		System.out.println("bTitle : "+bTitle);
		System.out.println("bContent : "+bContent);
		System.out.println("bDate : "+ bDate);*/
		
		reportNuri rn = new BoardService().reportDetail(num);
		
		int result =0;
		
		reportNuri rn2 = new reportNuri();
		rn2.setUserNum(Integer.parseInt(userNum));
		rn2.setBoardTitle(bTitle);
		rn2.setBoardContent(bContent);
		rn2.setBoardDate(reportDate);
		rn2.setN_ownerNum(ownerNum);
		

		String page = "";

		if(rn != null){
			result = new BoardService().InsertRegister(rn2);
			page = "views/admin/reportedDetail.jsp";
			request.setAttribute("rn", rn);
			
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
