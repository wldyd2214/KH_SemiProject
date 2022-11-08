package com.kh.nuriter.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.notice.model.service.NoticeService;
import com.kh.nuriter.notice.model.vo.Notice;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/updateNotice.no")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		
		System.out.println("공지사항 수정한 작성일(date) : " + date);
		
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
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		System.out.println("공지사항 수정한 작성일(day) : " + day);
		
		Notice n = new Notice();
		
		n.setbNumber(num);
		n.setbTitle(title);
		n.setbDate(day);
		n.setbContent(content);

		System.out.println("수정된 공지사항 정보 : " + n);
		
		int result = new NoticeService().updateNotice(n);
		
		System.out.println(result);
		
		
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/selectList.no");
		}else{
			request.setAttribute("msg", "공지사항 수정 실패!");
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
