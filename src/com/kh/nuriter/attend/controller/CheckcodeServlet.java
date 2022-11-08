package com.kh.nuriter.attend.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.attend.model.service.AttendCodeService;
import com.kh.nuriter.attend.model.service.AttendService;
import com.kh.nuriter.attend.model.vo.AttendCode;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

/**
 * Servlet implementation class CheckcodeServlet
 */
@WebServlet("/checkcode")
public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckcodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("달력 서블릿 호출됨");
		
		String nunum = request.getParameter("nunum");
		
		System.out.println("서블릿 : " +nunum);
		
		AttendCode ac = new AttendCode();
		ac.setNuriNumber(nunum);
		
		String code = null;
		
			int result = new AttendCodeService().insertOneCode(ac);
			
			if(result >0){
				AttendCode cf = new AttendCodeService().selectOneCode(nunum);
				code=cf.getAttendCodeid();
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(code);
				System.out.println("서블릿c"+cf);
				
				System.out.println(cf.getAttendCodeid());
			}
	
		else{
			AttendCode c = new AttendCodeService().selectOneCode(nunum);
			code=c.getAttendCodeid();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(code);
			
			System.out.println("검색 서블릿c"+c);
			
			System.out.println(c.getAttendCodeid());
			
		}
		/*System.out.println("달력 서블릿 호출됨");
		
		 char strCollection[] = new char[] { 
                 '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
                 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 
                 '!','@','#','$','%','^','&','*','(',')'};

		 String ranStr = ""; 

		 for (int i = 0; i < 5; i++) { 
			 int selectRandomStr = (int)(Math.random()*(strCollection.length));
			 ranStr += strCollection[selectRandomStr]; 
		 } 
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().print(ranStr);
		 System.out.println(ranStr);*/
		

		/*String userNum = String.valueOf(((Member)(request.getSession().getAttribute("list"))).getUserNumber());*/
		
		/*int listCount = new NuriterService().getMyNuriListCount(userNum);
		
		System.out.println("누리장 누리터 수 : " + listCount);
		*/
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
