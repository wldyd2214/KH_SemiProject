package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;

/**
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/findUser")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("UTF-8");
		
		String searchCondition = request.getParameter("searchCondition");*/
		
		//System.out.println(searchCondition);
		
		//ArrayList<Member> list = null;
		
		String userName = request.getParameter("findName");
		String phone = request.getParameter("findTel"); 
			
		Member loginUser = new MemberService().finId(userName, phone);
		
		if(loginUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			/*page ="index.jsp";
			System.out.println(page);*/
			response.sendRedirect("views/member/idResult.jsp");
			
			
		}else{
			/*page = "views/common/errorPage.jsp";*/
			/*page = "views/common/errorPage.jsp";*/
			/*request.setAttribute("msg", "로그인 에러!!!");*/
			request.setAttribute("msg", "회원정보가 존재하지 않습니다.");
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
