package com.kh.nuriter.admin.model.service;

import static com.kh.nuriter.common.JDBCTemplate.close;
import static com.kh.nuriter.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.nuriter.admin.model.dao.AdminDao;

public class AdminService {

	public int getListCount() {
		Connection con = getConnection();        
	    int listCount = new AdminDao().getListCount(con);
	         
	    close(con);
	         
	    return listCount;
	}

	public int selectMemberCount() {
		Connection con = getConnection();  
		
	    int memberCount = new AdminDao().selectMemberCount(con);
	         
	    close(con);
	         
	    return memberCount;
	}

	public int selectActivatedCount() {
		Connection con = getConnection();  
		
	    int activatedCount = new AdminDao().selectActivatedCount(con);
	         
	    close(con);
	         
	    return activatedCount;
	}

	public int selectJoinCount() {
		Connection con = getConnection();  
		
	    int memberJoinCount = new AdminDao().selectJoinCount(con);
	         
	    close(con);
	         
	    return memberJoinCount;
	}

	public int selectNuriterCount() {
		Connection con = getConnection();  
		
	    int nuriterCount = new AdminDao().selectNuriterCount(con);
	         
	    close(con);
	         
	    return nuriterCount;
	}

}
