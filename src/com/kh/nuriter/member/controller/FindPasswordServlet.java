package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.wrapper.LoginWrapper;


/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.me")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userEmail = request.getParameter("findEmail");
	     
	      Member loginUser = new MemberService().checkEmail(userEmail);
	    
	      String page = "";
	      //기존 회원 여부 확인
	      if(loginUser != null){

	         /*response.getWriter().println(2);*/
	    	  	 String authenticationNum = randomStr();
		         String subject = "누리터 임시 비밀번호";
		         String text = "누리터의" + "\n[임시비밀번호 : " + authenticationNum + "]";
		         
		         String username = "isr1059@gmail.com";
		         String password = "dlwlsgml06!";
		         
		         String exPassword="null";
	    			  			
		         exPassword = LoginWrapper.getSha512(authenticationNum);
		          
		          Member m = new Member();
			      m.setUserEmail(userEmail);
			      m.setPassword(exPassword);
			      
			      System.out.println("멤버 : " + m);
			      
			      int result = new MemberService().passwordUpdate(m);
		          
			      	Properties props = new Properties(); 
		         
		              props.put("mail.smtp.user",username); 
		              props.put("mail.smtp.password", password);
		              props.put("mail.smtp.host", "smtp.gmail.com"); 
		              props.put("mail.smtp.port", "25"); 
		              props.put("mail.debug", "true"); 
		              props.put("mail.smtp.auth", "true"); 
		              props.put("mail.smtp.starttls.enable","true"); 
		              props.put("mail.smtp.EnableSSL.enable","true");
		              props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		              props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		              props.setProperty("mail.smtp.port", "465");   
		              props.setProperty("mail.smtp.socketFactory.port", "465"); 
		          
		              Session session = Session.getInstance(props, new javax.mail.Authenticator() { 
		              protected PasswordAuthentication getPasswordAuthentication() { 
		              return new PasswordAuthentication(username, password); 
		              }});
		              System.out.println("??");
		              try{
		                  Message message = new MimeMessage(session); 
		                  message.setFrom(new InternetAddress(username));// 
		                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userEmail)); 
		                  message.setSubject(subject);
		                  message.setText(text);
		                  Transport.send(message); 
		                  System.out.println("SEND");
		                  
		                  
		              } catch(Exception e){
		                  e.printStackTrace();
		              }
		              
		              if(result > 0) {
		     	         HttpSession session1 = request.getSession();
		     	         session1.setAttribute("loginUser", m);
		     	         
		     	         response.sendRedirect("views/member/passwordResult.jsp");
		     	      }else {
		     	         page = "views/common/errorPage.jsp";
		     	         request.setAttribute("msg", "회원 정보 수정에 실패하였습니다!!");
		     	         //뷰 페이지로 전달
		     	         RequestDispatcher view = request.getRequestDispatcher(page);
		     	         view.forward(request, response);
		     	         
		     	      }
		              
		         response.getWriter().println(authenticationNum);
		         System.out.println("임시비밀번호 : " + authenticationNum);

	      }else{
	         
	    	  page = "views/common/errorPage.jsp";
		      request.setAttribute("msg", "회원 정보가 존재하지 않습니다!!");
	      }
	      

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	  public static String randomStr(){ 
	         char strCollection[] = new char[] { 
	                           '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
	                           'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 
	                           '!','@','#','$','%','^','&','*','(',')'};

	         String ranStr = ""; 

	         for (int i = 0; i < 5; i++) { 
	           int selectRandomStr = (int)(Math.random()*(strCollection.length));
	           ranStr += strCollection[selectRandomStr]; 
	         } 
	         
	       return ranStr; 
	     }
	  
	  

}
