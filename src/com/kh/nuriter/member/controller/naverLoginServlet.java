package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

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
 * Servlet implementation class naverLoginServlet
 */
@WebServlet("/naverlogin")
public class naverLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public naverLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("useremail");
		String name=request.getParameter("name");
		String nickName=request.getParameter("nickname");
		/*String birthday=request.getParameter("birthday");*/
		
		System.out.println(userEmail);
		/*System.out.println(birthday);*/
		System.out.println("오냐?");
		
		/*java.sql.Date day = null;
		
		if(birthday != " " || birthday != null){
			
			String[] dateArr = birthday.split("-");
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
		}*/
		
		Member m=new Member();
		m.setUserEmail(userEmail);
		m.setUserName(name);
		m.setNickName(nickName);
		/*m.setBirthDate(day);*/
		
		
		Member loginUser = new MemberService().snsloginMember1(userEmail);
		System.out.println("서블릿  유저: " +loginUser);
		
		
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
			int result=new MemberService().snsMember1(m);

			if(result==99){
				response.sendRedirect("index.jsp");								
				/*request.getRequestDispatcher("index.jsp").forward(request, response);*/
				
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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
