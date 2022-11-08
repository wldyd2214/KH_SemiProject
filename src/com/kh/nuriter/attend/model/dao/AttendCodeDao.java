package com.kh.nuriter.attend.model.dao;

import static com.kh.nuriter.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.nuriter.attend.model.vo.AttendCode;
import com.kh.nuriter.nuriter.model.dao.NuriterDao;

public class AttendCodeDao {
	
	private Properties prop = new Properties();
	
	public AttendCodeDao() {
		String fileName = AttendCodeDao.class.getResource("/sql/attend/attend-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AttendCode selectOneCode(Connection con, String nunum) {
		AttendCode c = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("attendcodeOne");
		
try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			rset = pstmt.executeQuery();
			System.out.println("dao"+ nunum);
			System.out.println("rest : " + rset);
			
			while(rset.next()){	
				  c = new AttendCode();
	              c.setAttendCodeid(rset.getString("attendcode_id"));
	              c.setNuriNumber(rset.getString("nuri_number"));
	              c.setAttendCodeDate(rset.getDate("attendcode_date"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		
		return c;
	}

	public int insertOneCode(AttendCode ac, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttendCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ac.getNuriNumber());
			
			result = pstmt.executeUpdate();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		System.out.println("dao result : " +result);
		return result;
		
	}

	public AttendCode codeCheck(Connection con, String nunum) {
		AttendCode atcode = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("codeCheck");
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			rset = pstmt.executeQuery();
			System.out.println("dao 체크코드1 : "+ nunum);
			System.out.println("rest1 : " + rset);
			
			while(rset.next()){	
				atcode = new AttendCode();
				atcode.setAttendCodeid(rset.getString("attendcode_id"));
				atcode.setNuriNumber(rset.getString("nuri_number"));
				atcode.setAttendCodeDate(rset.getDate("attendcode_date"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao atcode : " + atcode);
		return atcode;
	}

}
