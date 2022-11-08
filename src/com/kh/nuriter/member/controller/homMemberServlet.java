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
import com.kh.nuriter.nuriter.model.vo.Nuriter;
import com.kh.nuriter.nuriter.model.vo.PageInfo;

/**
 * Servlet implementation class homMemberServlet
 */
@WebServlet("")
public class homMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값에 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 전송값 꺼내서 변수에 기록하기
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
				
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
				
		//3. 서비스 호출
		Member loginUser = new MemberService().loginCheck(userId, password);
		
		
		/*if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}*/
		
		/*int listCount = new NuriterService().getNuriterListCount(category);*/
		
		/*System.out.println("listCount => " + listCount);
		
		limit = 8;
		
		maxPage = (int)((double)listCount / limit + 0.9) ;
		
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}*/
		
		/*PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);*/
		
		System.out.println("누리터 리스트 서블릿 이동 완료!");
		/*ArrayList<Nuriter> list = new NuriterService().selectNuriterList(category); //해당 카테고리에 대한 리스트를 ArrayList로 가져온다.
		
		System.out.println(list);*/
		
		ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
		ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
		ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
		
		System.out.println("pictureList => " + pictureList);
		System.out.println("pictureList => " + pictureList2);
		System.out.println("pictureList => " + pictureList3);

		//4. 받은 결과에 따라 뷰 페이지 내보내기
		/*String page = "";
		if(loginUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);*/
			/*request.setAttribute("list", list);*/
			/*request.setAttribute("pi", pi);*/
			request.setAttribute("pictureList", pictureList);
			request.setAttribute("pictureList2", pictureList2);
			request.setAttribute("pictureList3", pictureList3);
			/*page ="index.jsp";
			System.out.println(page);*/
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		/*}*/
			
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
