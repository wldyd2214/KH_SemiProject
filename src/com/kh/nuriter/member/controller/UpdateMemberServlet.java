package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //인코딩
	      request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
	      
	      //request 객체에서 파라메터 꺼내기
	      int userNumber = Integer.parseInt(request.getParameter("userNumber"));
	      String userEmail = request.getParameter("userEmail");
	      String newPassword = request.getParameter("newPassword");
	      String oldPassword2 = request.getParameter("oldPassword2");
	      System.out.println("기존 비밀번호 : " + oldPassword2);
	      System.out.println("신규 비밀번호 : " + newPassword);
	      String nickName = request.getParameter("nickName");
	      String phone = request.getParameter("phone");
	      String address = request.getParameter("address");
	      String[] hobby = request.getParameterValues("hobby");
	      String hobbys = "";
	      for (int i = 0; i < hobby.length; i++) {
	         if(i == 0) {
	            hobbys += hobby[i];
	         }else {
	            hobbys += ", " + hobby[i];
	         }
	      }
	       
	      //member객체 생성
	      Member m = new Member();
	      //신규비밀번호가 null값일 경우 기존비밀번호로 대체
	      if(newPassword.equals("z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==")){
	      m.setUserNumber(userNumber);
	      m.setUserEmail(userEmail);
	      m.setPassword(oldPassword2);
	      m.setNickName(nickName);
	      m.setPhone(phone);
	      m.setAddress(address);
	      m.setHobby(hobbys);
	      }else{
	      m.setUserNumber(userNumber);
		  m.setUserEmail(userEmail);
		  m.setPassword(newPassword);
		  m.setNickName(nickName);
		  m.setPhone(phone);
		  m.setAddress(address);
		  m.setHobby(hobbys);
	      }
	      
	      System.out.println("회원정보 : " + m);
	      
	      //service로직으로 전달
	      int result = new MemberService().updateMember(m);
	      
	      //처리 결과에 따른 뷰 페이지 결정
	      String page = "";
	      
	      if(result > 0) {
	    	  request.getSession().invalidate();
	    	  ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
			  ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
			  ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
	    	  
			  request.setAttribute("pictureList", pictureList);
		      request.setAttribute("pictureList2", pictureList2);
			  request.setAttribute("pictureList3", pictureList3);
			  request.getRequestDispatcher("index.jsp").forward(request, response);
	  		 /* response.sendRedirect("index.jsp");*/
	      }else {
	         page = "views/common/errorPage.jsp";
	         request.setAttribute("msg", "회원 정보 수정에 실패하였습니다!!");
	         //뷰 페이지로 전달
	         RequestDispatcher view = request.getRequestDispatcher(page);
	         view.forward(request, response);
	         
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
