package com.kh.nuriter.attend.model.dao;

import static com.kh.nuriter.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.nuriter.attend.model.vo.Attend;
import com.kh.nuriter.attend.model.vo.Attendprint;
import com.kh.nuriter.attend.model.vo.Enter;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

public class AttendDao {
private Properties prop = new Properties();
	
	public AttendDao() {
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
	
	
	public int insertattend(Connection con, String checkcode, String usernum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttend");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,checkcode);
			pstmt.setString(2, usernum);
			
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


	public Attend attendCheck(Connection con, String checkcode, String usernum) {
		Attend attend = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("attendCheck");
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, checkcode);
			pstmt.setString(2, usernum);
			
			rset = pstmt.executeQuery();
			System.out.println("dao 체크코드2 : "+ checkcode);
			System.out.println("rest1 : " + rset);
			
			while(rset.next()){	
				attend = new Attend();
				attend.setAttendNumber(rset.getString("attend_number"));
				attend.setAttendCodeId(rset.getString("attendcode_id"));
				attend.setUserNumber(rset.getString("user_number"));
				attend.setAttendDate(rset.getDate("attend_date"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		return attend;
	}


	public ArrayList<Attend> attendOk(Connection con, String usernum) {
		ArrayList<Attend> attend = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("attendOk");
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usernum);
			
			rset = pstmt.executeQuery();
			System.out.println("dao 유저넘버 : "+ usernum);
			System.out.println("rest1 : " + rset);
			
			if(rset != null){
			attend = new ArrayList<Attend>();	
			while(rset.next()){	
				Attend attend1 = new Attend();
				attend1.setAttendNumber(rset.getString("attend_number"));
				attend1.setAttendCodeId(rset.getString("attendcode_id"));
				attend1.setUserNumber(rset.getString("user_number"));
				attend1.setAttendDate(rset.getDate("attend_date"));
			
				attend.add(attend1);
			}
		 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		return attend;
	}


	public ArrayList<Attendprint> attendprint(Connection con, String nunum) {
		/*ArrayList<HashMap<String, Object>> att = null;
		HashMap<String, Object> hmap = null;*/
		
		ArrayList<Attendprint> att = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("attendPrint");
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			
			rset = pstmt.executeQuery();
			System.out.println("dao nunum : "+ nunum);
			System.out.println("rest1 : " + rset);
			
			if(rset != null){
			/*att = new ArrayList<HashMap<String, Object>>();*/
			att = new ArrayList<Attendprint>();
			while(rset.next()){
				Attendprint attend1 = new Attendprint();
				attend1.setAttendCodeId(rset.getString("attendcode_id"));
				attend1.setNickName(rset.getString("nickname"));
				attend1.setNuriNumber(rset.getString("nuri_number"));
				attend1.setAttendDate(rset.getDate("attend_date"));
			
				att.add(attend1);
				/*hmap = new HashMap<String, Object>();
				
				hmap.put("attendcode_id", rset.getString("attendcode_id"));
				hmap.put("nickname",rset.getString("nickname"));
				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("attend_date", rset.getDate("attend_date"));
				
				att.add(hmap);	*/
			}
		 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		return att;
	}


	public ArrayList<Enter> enterprint(Connection con, String nunum) {
		/*ArrayList<HashMap<String, Object>> en = null;
		HashMap<String, Object> hmap = null;*/
		ArrayList<Enter> en = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("enterPrint");
		
		System.out.println(query);
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			
			rset = pstmt.executeQuery();
			
			System.out.println("dao nunum : "+ nunum);
			System.out.println("rest1 : " + rset);
			
			if(rset != null){
			/*en = new ArrayList<HashMap<String, Object>>();*/
			en = new ArrayList<Enter>();
			
			while(rset.next()){
				Enter enter = new Enter();
				enter.setNuriNumber(rset.getString("user_number"));
				enter.setNickName(rset.getString("nickname"));
				enter.setNuriNumber(rset.getString("nuri_number"));
				enter.setEnterDate(rset.getDate("enter_date"));
				enter.setTerminateDate(rset.getDate("terminate_date"));
				enter.setPhone(rset.getString("phone"));
			
				en.add(enter);
				
				/*hmap = new HashMap<String, Object>();
				
				hmap.put("user_number", rset.getString("user_number"));
				hmap.put("nickname",rset.getString("nickname"));
				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("enter_date", rset.getDate("enter_date"));
				hmap.put("terminate_date", rset.getDate("terminate_date"));
				hmap.put("phone", rset.getString("phone"));
				
				en.add(hmap);*/
				
			}
		 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao enterprint : " + en);
		return en;
	}

	public ArrayList<Attendprint> attendprint2(Connection con, String nunum, String date) {
		/*ArrayList<HashMap<String, Object>> att2 = null;
		HashMap<String, Object> hmap2 = null;*/
		
		ArrayList<Attendprint> att2 = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query=null;*/		
		String query = prop.getProperty("attendPrint2");
		
		try {	
			/*pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();*/
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(2, nunum);
			pstmt.setString(1, date);
			
			rset = pstmt.executeQuery();
			System.out.println("dao nunum : "+ nunum);
			System.out.println("rest1 : " + rset);
			
			if(rset != null){
			/*att2 = new ArrayList<HashMap<String, Object>>();*/
			att2 = new ArrayList<Attendprint>();
			while(rset.next()){
				Attendprint attend1 = new Attendprint();
				attend1.setAttendCodeId(rset.getString("attendcode_id"));
				attend1.setNickName(rset.getString("nickname"));
				attend1.setNuriNumber(rset.getString("nuri_number"));
				attend1.setAttendDate(rset.getDate("attend_date"));
			
				att2.add(attend1);
				/*hmap = new HashMap<String, Object>();
				
				hmap.put("attendcode_id", rset.getString("attendcode_id"));
				hmap.put("nickname",rset.getString("nickname"));
				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("attend_date", rset.getDate("attend_date"));
				
				att.add(hmap);	*/
			}
		 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
			
		}
		
		return att2;
}
  
	public int getListCount(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, nuriNum);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


	public ArrayList<Member> selectMyNuriMemberList(Connection con, int currentPage, int limit, String nuriNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> list = null;

		String query = prop.getProperty("selectMyNuriMemberList");

		try {
			// stmt = con.createStatement();
			// rset = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);

			// 조회 시작 할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, nuriNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<Member>();
				while (rset.next()) {
					Member m = new Member();
					m.setUserNumber(rset.getInt("user_number"));
					m.setNickName(rset.getString("nickname"));
					System.out.println(m.getNickName());
					m.setPhone(rset.getString("phone"));
					System.out.println(m.getPhone());

					list.add(m);

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close(stmt);
			close(rset);
			close(pstmt);
		}

		return list;
	}

}
