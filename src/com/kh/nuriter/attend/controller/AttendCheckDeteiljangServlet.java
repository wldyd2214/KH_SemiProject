package com.kh.nuriter.attend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.attend.model.service.AttendService;
import com.kh.nuriter.attend.model.vo.Attendprint;
import com.kh.nuriter.attend.model.vo.Enter;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

/**
 * Servlet implementation class AttendCheckDeteiljangServlet
 */
@WebServlet("/attendcheckdeteiljang.nu")
public class AttendCheckDeteiljangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendCheckDeteiljangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nunum = request.getParameter("nunum");
		String usernumber = request.getParameter("usernumber");
		String date = request.getParameter("date");
		
		
		String datejang = date;
		
		System.out.println("서블릿 오는 date : " + date);
		
		/*ArrayList<HashMap<String, Object>> en = new AttendService().enterprint(nunum);*/
		ArrayList<Enter> en = new AttendService().enterprint(nunum);
		
		System.out.println("서블릿 enterprint: " + en);
		
		ArrayList<Attendprint> att = new AttendService().attendprint(nunum);
		
		ArrayList<Attendprint> att2 = new AttendService().attendprint2(nunum, date);
		/*ArrayList<HashMap<String, Object>> att = new AttendService().attendprint(nunum);*/
		
		System.out.println("서블릿 : att" + att );
		
		Nuriter n = new NuriterService().selectOpenOne(nunum);
		
		String page ="";
		
		System.out.println(n);
		
		System.out.println("datejang: " + datejang);
		if(n != null){
			page = "views/attend/csCheckjang.jsp";
			request.setAttribute("n", n);
			request.setAttribute("en", en);
			/*request.setAttribute("att", att);*/
			request.setAttribute("att2", att2);
			request.setAttribute("datejang", datejang);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
		/*// 페이징처리 추가
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개가 보여질 것인지
		int maxPage; // 전체 페이지에서 가장 마지막 페이지
		int startPage; // 한번에 표시될 페이지가 시작할 페이지
		int endPage; // 한번에 표시될 페이지가 끝나는 페이지

		// 게시판은 1페이지부터 시작함
		currentPage = 1;

		// 현재 페이지가 1페이지가 아닌 경우
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		Nuriboss n = new Nuriboss();
		String userNum = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber());
		System.out.println("duserNum : " + userNum);
		// 전체 목록 갯수와 목록 전체를 리턴받음,
		int listCount = new NuriterService().getListCount(userNum);	
		System.out.println("d게시글 수 : " + listCount);

		// 한 페이지에 보여줄 게시물 수
		limit = 10;

		// 총 페이지 수 계산
		maxPage = (int) ((double) listCount / limit + 0.9);

		// 현재 페이지에 보여줄 시작 페이지 수
		startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

		// 목록 아래 보여질 마지막 페이지 수
		endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 페이지 정보를 공유할 vo객체 생성
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Nuriter> list = new NuriterService().selectOpenList1(currentPage, limit, userNum);
		System.out.println("개설 중인 누리터 리스트 : " + list);

		String page = "";

		if (list != null) {
			page = "/views/attend/csCheckjang.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "개설중인 누리터 조회!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
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
