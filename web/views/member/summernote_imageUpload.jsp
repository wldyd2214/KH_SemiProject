<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %> 

<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%-- <%
    // 이미지 업로드할 경로
	String uploadPath = "D:imageTest";
    int size = 1000 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
	
	String fileName = ""; // 파일명
	
	
  	  try{
        // 파일업로드 및 업로드 후 파일명 가져옴
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement(); 
		fileName = multi.getFilesystemName(file); 
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
 	String uploadPath2 = uploadPath +"/" +fileName;
    
    // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
	JSONObject jobj = new JSONObject();
	jobj.put("url", uploadPath2); 
	System.out.println("11");
	
	response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
	System.out.println(jobj.toJSONString());
	out.print(jobj.toJSONString()); 
	
%> --%>
<%
 request.setCharacterEncoding("euc-kr");
 String realFolder = "";
 String filename1 = "";
 int maxSize = 1024*1024*5;
 String encType = "euc-kr";
 String savefile = "images/nuriter";
 ServletContext scontext = getServletContext();
 realFolder = scontext.getRealPath(savefile);
 
 try{
  MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

  Enumeration<?> files = multi.getFileNames();
     String file1 = (String)files.nextElement();
     filename1 = multi.getFilesystemName(file1);
 } catch(Exception e) {
  e.printStackTrace();
 }
 
 String fullpath = realFolder + "\\" + filename1;

 System.out.println("경로 : " +fullpath);
 System.out.println("경로2 : " + request.getContextPath()+"/images/nuriter/" + filename1);
 String path2 = request.getContextPath()+"/images/nuriter/" + filename1;
 System.out.println("filename : " + filename1);
 
 JSONObject jobj = new JSONObject();
	jobj.put("url", path2); 
	
	String data = jobj.toString();
	System.out.println("url : " + data);
	
	response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
	out.print(jobj.toJSONString()); 
 
 
%>

