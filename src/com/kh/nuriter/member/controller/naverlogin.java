package com.kh.nuriter.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;

/**
 * Servlet implementation class naverlogin
 */
@WebServlet("/naverlogin1")
public class naverlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public naverlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String access_token = "";
	      String refresh_token = "";
	      
	      String clientId = "p7rY8Kd2Yc3e2TAc4l38";//애플리케이션 클라이언트 아이디값";
	       String clientSecret = "Uz34XH8F1Y";//애플리케이션 클라이언트 시크릿값";
	       String code = request.getParameter("code");
	       String state = request.getParameter("state");
	       String redirectURI = URLEncoder.encode("http://localhost:8001/ns/views/member/naver.jsp", "UTF-8");
	       String apiURL;
	       
	       apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	       apiURL += "client_id=" + clientId;
	       apiURL += "&client_secret=" + clientSecret;
	       apiURL += "&redirect_uri=" + redirectURI;
	       apiURL += "&code=" + code;
	       apiURL += "&state=" + state;
	       
	       System.out.println("apiURL="+apiURL);
	       
	       StringBuffer rese = null;
	       
	       try {
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         System.out.print("responseCode="+responseCode);
	         if(responseCode==200) { // 정상 호출
	           br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {  // 에러 발생
	           br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         String inputLine;
	         rese = new StringBuffer();
	         while ((inputLine = br.readLine()) != null) {
	           rese.append(inputLine);
	         }
	         br.close();
	         if(responseCode==200) {
	            System.out.println();
	           System.out.println("성공 : "+rese.toString());
	         }
	       } catch (Exception e) {
	          System.out.println();
	         System.out.println("실패 : "+e);
	       }
	       
	       JSONObject json = (JSONObject)JSONValue.parse(rese.toString());
	       refresh_token = (String)json.get("refresh_token");
	       access_token = (String)json.get("access_token");
	       
	      try {
	         String token = access_token;// 네이버 로그인 접근 토큰;
	         String header = "Bearer " + token; // Bearer 다음에 공백 추가
	            apiURL = "https://openapi.naver.com/v1/nid/me";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Authorization", header);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response1 = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response1.append(inputLine);
	            }
	            br.close();
	            
	            json = (JSONObject)JSONValue.parse(response1.toString());
	            json = (JSONObject)JSONValue.parse(json.get("response").toString());
	            System.out.println("전체 : "+response1.toString());
	            
	            request.setAttribute("nickname", json.get("nickname"));
	            request.setAttribute("email", json.get("email"));
	            request.setAttribute("name", json.get("name"));
	            request.setAttribute("id", json.get("id"));
	            request.setAttribute("refresh_token", refresh_token);
	            
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	      
	      /*Member loginUser = new MemberService().memberSNSLogin(refresh_token);*/
	       
	      /* HttpSession session = request.getSession();
	      if(loginUser != null){
	         session.setAttribute("loginUser", loginUser);
	         session.setAttribute("msg", "로그인성공");
	         request.setAttribute("bool", true);
	      }else{
	         session.setAttribute("msg", "로그인실패");
	         request.setAttribute("bool", false);
	      }*/
	      
	      String page = "/views/member/naver.jsp";
	      RequestDispatcher view = request.getRequestDispatcher(page);
	      view.forward(request, response);      //보내준다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
