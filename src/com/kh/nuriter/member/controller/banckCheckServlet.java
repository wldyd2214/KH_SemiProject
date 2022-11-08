package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.member.model.service.MemberService;

@WebServlet("/banckCheck")
public class banckCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public banckCheckServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=  request.getParameter("#userName");
        String phone =  request.getParameter("#phone");
        String bancknumber =request.getParameter("#bancknumber");
        String date = request.getParameter("#date");
        
        java.sql.Date day = null;
		
		if(date != " " || date != null){
			
			String[] dateArr = date.split("-");
			int[] arr = new int[dateArr.length];
			
			for(int i=0; i<dateArr.length; i++){
				
				arr[i] = Integer.parseInt(dateArr[i]);
				System.out.println(dateArr[i]);
			}
			int da =0;
			if(arr[0] >=2000){
				da = arr[0]-2000;
			}else{
				da = arr[0]-1900;
			}

			System.out.println("year" + arr[0]);
			System.out.println("month" + arr[1]);
			System.out.println("day" + arr[2]);
			day=new java.sql.Date(new GregorianCalendar(da, arr[1]-1, arr[2]).getTimeInMillis());
			
		}else{
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		System.out.println(day);
        
		
		/*String userId = request.getParameter("userId");
		int result = new MemberService().updateInvestorMember(userId);*/
		
		/*if(result > 0){*/
			/*request.setAttribute("msg", "투자자로 회원정보 변경이 완료되었습니다. 재로그인 해주세요");*/
			/*request.getSession().invalidate();*/
		/*}else{
			request.setAttribute("msg", "투자자로 회원정보 변경에 실패하였습니다.");
		}*/
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("phone", bancknumber);
		request.setAttribute("day", day);
		
		RequestDispatcher view = request.getRequestDispatcher("views/member/banckCheck.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
