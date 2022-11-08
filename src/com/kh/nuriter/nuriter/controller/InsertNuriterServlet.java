package com.kh.nuriter.nuriter.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.nuriter.common.MyFileRenamePolicy;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Attachment;
import com.kh.nuriter.nuriter.model.vo.Nuriter;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertNuriterServlet
 */
@WebServlet("/insert.nu")
public class InsertNuriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNuriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//폼 전송을 multipart/form-data로 전송하는 경우에는
				//기존처럼 request.getParameter로 값을 받을 수 없다.
				//cos.jar가 파일도 받고 다른 값들도 받아주는 역할을 한다.
				//com.orelilly.servlet의 약자이다.
				if(ServletFileUpload.isMultipartContent(request)) {
					//전송 파일에 대한 용량 제한 : 10MB
					int maxSize = 1024 * 1024 * 10;
					
					//웹서버 컨테이너 경로 추출함
					String root = request.getSession().getServletContext().getRealPath("/");
					
					System.out.println(root);
					
					String savePath = root + "thumbnail_uploadFiles/";
					
					
					//사용자가 올린 파일명을 그대로 저장하지 않는 것이 일반적이다.
					//1. 같은 파일명이 있는 경우 이전 파일 덮어쓸 수 있다.
					//2. 한글로된 파일명, 특수기호, 띄어쓰기 등은 서버에 따라 문제가 생길 수 도 있다.
					//DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
					//같은 파일명이 존재하는지 검사하고
					//있을 경우 파일명 뒤에 숫자를 붙여준다.
					//ex : aaa.zip, aaa1.zip, aaa2.zip
					/*MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());*/
					
					//FileRenamePolicy 상속 후 오버라이딩
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					//다중 파일을 묶어서 업로드 하기 위해 컬렉션을 생성한다
					//저장한 파일의 이름을 저장할 arrayLisy를 생성한다
					ArrayList<String> saveFiles = new ArrayList<String>();
					//원본파일의 이름을 저장할 arrayList를 생성한다.
					ArrayList<String> originFiles = new ArrayList<String>();
					
					//파일이 전송된 이름을 반환한다.
					Enumeration<String> files= multiRequest.getFileNames();
					
					//각 파일의 정보를 구해온 후 DB에 저장할 목적의 데이터를 꺼내온다
					while(files.hasMoreElements()) {
						String name = files.nextElement();
						
						saveFiles.add(multiRequest.getFilesystemName(name)); //바뀐 이름
						originFiles.add(multiRequest.getOriginalFileName(name)); //원본 이름
					}
					
					String writer = (String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber()));
					String category = multiRequest.getParameter("category");
					String title = multiRequest.getParameter("title");
					String fromDate = multiRequest.getParameter("fromDate");
					String toDate = multiRequest.getParameter("toDate");
					String startTime = multiRequest.getParameter("timepicker1");
					String endTime = multiRequest.getParameter("timepicker2");
					String placeOne = multiRequest.getParameter("placeOne");
					String placeTwo = multiRequest.getParameter("placeTwo");
					String placeTree = multiRequest.getParameter("placeTree");
					String place = placeOne + " | " + placeTwo + " | " + placeTree;
					String summerText = multiRequest.getParameter("summerText");
					String price = multiRequest.getParameter("price");
					String personnel = multiRequest.getParameter("personnel");
					int attendCount = Integer.parseInt(multiRequest.getParameter("count")); 
					
					/*System.out.println(writer);
					System.out.println(category);
					System.out.println(title);
					System.out.println(fromDate);
					System.out.println(toDate);
					System.out.println(startTime);
					System.out.println(endTime);*/
					System.out.println(place);
					/*System.out.println(price);
					System.out.println(personnel);
					System.out.println(saveFiles);
					System.out.println(originFiles);*/
					
					java.sql.Date startDay = null;
					
					if(fromDate != "" || fromDate != null) {
						String[] dateArr = fromDate.split("-");
						
						int[] arr = new int[dateArr.length];
						
						for(int i = 0; i < dateArr.length; i++) {
							arr[i] = Integer.parseInt(dateArr[i]);
						}
						
						startDay = new java.sql.Date(new GregorianCalendar(arr[0], arr[1] - 1, arr[2]).getTimeInMillis());
						
						System.out.println(startDay);
					}else {
						startDay = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
					}
					
					java.sql.Date endDay = null;
					
					if(toDate != "" || toDate != null) {
						String[] dateArr = toDate.split("-");
						
						int[] arr = new int[dateArr.length];
						
						for(int i = 0; i < dateArr.length; i++) {
							arr[i] = Integer.parseInt(dateArr[i]);
						}
						
						endDay = new java.sql.Date(new GregorianCalendar(arr[0], arr[1] - 1, arr[2]).getTimeInMillis());
						
						System.out.println(endDay);
					}else {
						endDay = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
					}
					
					Nuriter n = new Nuriter();
					n.setOwnerNum(writer); //누리장 번호
					n.setCategoryNum(category); //카테고리ID
					n.setNuriTitle(title); //누리터 제목
					n.setStartDate(startDay); //시작일
					n.setEndDate(endDay); //종료일
					n.setStartTime(startTime + " ~ " + endTime); //시작 종료시간
					n.setPlace(place); //장소
					n.setContent(summerText); //내용
					n.setPrice(price); //가격
					n.setPersonnel(personnel); //총원
					n.setAttendCount(attendCount); //총 출석일수
					
					//Attachment객체 생성해서 arrayList객체 생성
					ArrayList<Attachment> fileList = new ArrayList<Attachment>();
					//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
					for(int i  = originFiles.size() - 1; i >= 0; i--) {
						Attachment at = new Attachment();
						at.setPath(savePath);
						at.setOrigin(originFiles.get(i));
						at.setChange(saveFiles.get(i));
						
						fileList.add(at);
					}
					
					int result = new NuriterService().insertNuriter(n, fileList); //누리터 생성
					
					if(result > 0) {
						//에러 페이지로 forward
						request.setAttribute("msg", "누리터 개설 성공!");
						request.getRequestDispatcher("views/common/successPage.jsp").forward(request, response);
					}else {
						//실패시 저장된 사진 삭제
						for(int i = 0; i < saveFiles.size(); i++) {
							//파일시스템에 저장된 이름으로 파일 객체 생성함
							File failedFile = new File(savePath + saveFiles.get(i));
							
							failedFile.delete();
						}
						
						//에러 페이지로 forward
						request.setAttribute("msg", "누리터 개설 실패!");
						request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
					}
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
