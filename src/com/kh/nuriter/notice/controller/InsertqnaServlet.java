package com.kh.nuriter.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.notice.model.vo.Notice;

/**
 * Servlet implementation class Insertqna
 */
@WebServlet("/insert.qi")
public class InsertqnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertqnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String userNum = request.getParameter("userNum");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		
		
		java.sql.Date bDate = null;
	      
	      if(date != "" || date != null) {
	         String[] dateArr = date.split("-");
	         
	         int[] arr = new int[dateArr.length];
	         
	         for(int i = 0; i < dateArr.length; i++) {
	            arr[i] = Integer.parseInt(dateArr[i]);
	         }
	         
	         bDate = new java.sql.Date(new GregorianCalendar(arr[0], arr[1] - 1, arr[2]).getTimeInMillis());
	         
	         System.out.println(bDate);
	      }else {
	    	  bDate = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
	      }
		
		
		
		
		Notice n = new Notice();
		n.setUserNumber(userNum);
		n.setbContent(content);
		n.setbTitle(title);
		n.setbDate(bDate);
		
		
		int result = new NoticeService().Insertqna(n);
		
		String page = "";
		
		if(result >0){
			 response.sendRedirect(request.getContextPath()+"/selectqnalist.sql");			
		}else{
			System.out.println("실패");
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
