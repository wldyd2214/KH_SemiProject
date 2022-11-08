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
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항 작성 후 서블릿 이동");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String userNumber = request.getParameter("userNumber");
		
		System.out.println(writer);
		System.out.println(userNumber);
		
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		
		java.sql.Date day = null;
		
		if(date != "" || date != null){
			String[] dateArr = date.split("-");
			int[] arr = new int[dateArr.length];
			
			for(int i = 0; i < dateArr.length; i++){
				arr[i] = Integer.parseInt(dateArr[i]);
			}
			
			day = new java.sql.Date(new GregorianCalendar(arr[0], arr[1]-1, arr[2]).getTimeInMillis());
		}else{
			System.out.println("날짜를 입력해 주세요!");
		}
		
		Notice n = new Notice();
		n.setbTitle(title);
		n.setUserNumber(userNumber);
		n.setbDate(day);
		n.setbContent(content);
		
		int result = new NoticeService().insertNotice(n);
		
		String page = "";
		
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/selectList.no");
			/*page="views/notice/notice.jsp";
			request.setAttribute("list", new NoticeService().selectList());*/
		}else{
			request.setAttribute("msg", "공지사항 등록 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			/*page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 등록 실패!");*/
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
