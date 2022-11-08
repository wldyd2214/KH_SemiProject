package com.kh.nuriter.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.nuriter.admin.model.service.AdminService;
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class SelectAdminCountServlet
 */
@WebServlet("/selectAdminPark.am")
public class SelectAdminCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAdminCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberCount = new AdminService().selectMemberCount(); 
		System.out.println(memberCount);
		
		int activatedMemberCount = new AdminService().selectActivatedCount();
		System.out.println(activatedMemberCount);
		
		int memberJoinCount = new AdminService().selectJoinCount();
		System.out.println(memberJoinCount);
		
		int nuriterCount = new AdminService().selectNuriterCount();
		System.out.println(nuriterCount);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		ArrayList<HashMap<String, Object>> commentList = new ArrayList<HashMap<String, Object>>();
		
		hmap.put("memberCount", memberCount);
		hmap.put("activatedMemberCount", activatedMemberCount);
		hmap.put("memberJoinCount", memberJoinCount);
		hmap.put("nuriterCount", nuriterCount);
		
		commentList.add(hmap);
		
		System.out.println(commentList);
		
		if(commentList != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(commentList, response.getWriter());
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
