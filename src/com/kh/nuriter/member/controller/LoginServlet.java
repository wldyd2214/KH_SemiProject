
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값에 한글이 있을 경우 인코딩 처리
		/*request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");*/
		
		//2. 전송값 꺼내서 변수에 기록하기
		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userEmail);
		System.out.println("password : " + password);
		
		//3. 서비스 호출
		Member loginUser = new MemberService().loginCheck(userEmail, password);
		System.out.println("로그인 유저 : " + loginUser);
		
		//4. 받은 결과에 따라 뷰 페이지 내보내기
		String page = "";
		if(loginUser != null && !loginUser.getActivated().equals("N")){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
			ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
			ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
			
			
			
			/*page ="index.jsp";*/
			/*page ="request.getContextPath()/";*/
			System.out.println(page);
			/*response.sendRedirect("index.jsp");*/
			request.setAttribute("pictureList", pictureList);
			request.setAttribute("pictureList2", pictureList2);
			request.setAttribute("pictureList3", pictureList3);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else{
			/*page = "views/common/errorPage.jsp";*/
			/*page = "views/common/errorPage.jsp";*/
			/*request.setAttribute("msg", "로그인 에러!!!");*/
			request.setAttribute("msg", "로그인 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		/*RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}