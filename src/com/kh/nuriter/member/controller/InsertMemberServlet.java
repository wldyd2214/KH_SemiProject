package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		*/
		System.out.println("회원가입 호출됨");
		
		//request 객체에서 파라메터 꺼내기
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String birthDate = request.getParameter("birthdate");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String bankName = request.getParameter("bankname");
		String bankNumber = request.getParameter("banknumber");
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = "";
		
		System.out.println("date : " + birthDate);
		System.out.println(userEmail);
		System.out.println(password);
		
		java.sql.Date day = null;
		
		if(birthDate != " " || birthDate != null){
			
			String[] dateArr = birthDate.split("-");
			int[] arr = new int[dateArr.length];
			
			for(int i=0; i<dateArr.length; i++){
				
				arr[i] = Integer.parseInt(dateArr[i]);
				System.out.println(dateArr[i]);
			}
			
			
			System.out.println("year" + arr[0]);
			System.out.println("month" + arr[1]);
			System.out.println("day" + arr[2]);
			day=new java.sql.Date(new GregorianCalendar(arr[0], arr[1]-1, arr[2]).getTimeInMillis());
			
		}else{
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		System.out.println(day);
		
		
		if(hobby != null){
			for(int i = 0; i < hobby.length; i++){
				if(i == 0){
					hobbys += hobby[i];
				}else{
					hobbys += ", " + hobby[i];
				}
			}
		}
				
		
		//member객체 생성
		Member m = new Member();
				
		 m.setUserEmail(userEmail);
		 m.setPassword(password);
		 m.setUserName(userName);
		 m.setNickName(nickName);
		 m.setBirthDate(day);
		 m.setPhone(phone);
		 m.setAddress(address);
		 m.setBankName(bankName);
		 m.setBankNumber(bankNumber);
		 m.setHobby(hobbys);
		
		//서비스로 전달
		int result = new MemberService().insertMember(m);
		
		System.out.println(result);
		
		//처리 결과에 따른 뷰 페이지 결정
		String page = "";
		
		if(result > 0){
			ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
			ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
			ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
			
			page = "index.jsp";
			request.setAttribute("msg", "회원 가입에 성공하셨습니다!! 환영합니다!");
			request.setAttribute("pictureList", pictureList);
			request.setAttribute("pictureList2", pictureList2);
			request.setAttribute("pictureList3", pictureList3);
			/*response.sendRedirect(request.getContextPath() + "/home");*/
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입에 실패하셨습니다!!");
		
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
