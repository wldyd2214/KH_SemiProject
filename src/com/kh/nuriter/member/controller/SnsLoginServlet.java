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
 * Servlet implementation class SnsLoginServlet
 */
@WebServlet("/snslogin.me")
public class SnsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnsLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("useremail");
		String idNum=request.getParameter("idNum");
		String nickName=request.getParameter("nickname");
		String refreshToken=request.getParameter("refreshToken");
		
		Member m=new Member();
		m.setUserEmail(userEmail);
		m.setNickName(nickName);
		/*m.setToken(refreshToken);*/

		//4. 받은 결과에 따라 뷰 페이지 내보내기
		/*String page = "";*/
		/*if(loginUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			page ="index.jsp";
			System.out.println(page);
			response.sendRedirect("index.jsp");
			
			
		}else{
			page = "views/common/errorPage.jsp";
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "로그인 에러!!!");
			request.setAttribute("msg", "로그인 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}*/
		
		/*int result=new MemberService().snsMember(m);
		System.out.println("서블릿 result : " + result);
		
		if(result == 99){
			request.setAttribute("msg", "로그인 성공");*/
			Member loginUser = new MemberService().snsloginMember(userEmail);
			System.out.println("서블릿  유저: " +loginUser);
			
			/*String page = "";*/
			if(loginUser != null){
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
				ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
				ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
				/*page ="index.jsp";*/
				/*System.out.println(page);*/
				/*response.sendRedirect("<%=request.getContextPath()%>/");*/
				/*RequestDispatcher view=request.getRequestDispatcher(page);
				view.forward(request, response);*/
				request.setAttribute("pictureList", pictureList);
				request.setAttribute("pictureList2", pictureList2);
				request.setAttribute("pictureList3", pictureList3);
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}else{
				int result=new MemberService().snsMember(m);

				if(result==99){
					response.sendRedirect("index.jsp");
				}else if(result<99&&result>0){
					request.setAttribute("msg", "회원가입 성공!!");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}else{	
				/*page = "views/common/errorPage.jsp";*/
				/*page = "views/common/errorPage.jsp";*/
				/*request.setAttribute("msg", "로그인 에러!!!");*/
				request.setAttribute("msg", "로그인 및 회원가입 실패!!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
				System.out.println("서블릿 result : " + result);
			}
		/*}
		else if(result<99&&result>0){
			request.setAttribute("msg", "가입 성공");
		}
		else{
			request.setAttribute("msg", "로그인 및 가입 실패");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
