package com.kh.nuriter.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.nuriter.common.JDBCTemplate.*;

import com.kh.nuriter.board.model.vo.board;
import com.kh.nuriter.board.model.vo.reportNuri;




public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao(){
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//넣기
	public int InsertReportNuri(Connection con, reportNuri rNuri) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertReportNuri");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rNuri.getBoardTitle());
			pstmt.setString(2, rNuri.getBoardContent());
			pstmt.setString(3, (rNuri.getUserNum())+"");
			pstmt.setString(4, rNuri.getN_ownerNum());
			pstmt.setString(5, rNuri.getNuriNum());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			
		}
		

		return result ;
	}
	//페이징
	public int reportListCount(Connection con) {
		int listCount =0;
		Statement stmt =null;
		ResultSet rset =null;
		
		
		String query = prop.getProperty("reportListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount =rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}
		return listCount;
	}


	//전체조회
	public ArrayList<reportNuri> selectReportList(Connection con, int currentPage, int limit) {
		ArrayList<reportNuri> rlist =null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		reportNuri rn = null;
		
		String query =prop.getProperty("selectReportList");
		
		try {
			pstmt =con.prepareStatement(query);
			
			int startNum =(currentPage -1)* limit + 1;
			int endNum = startNum + limit-1;
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rset = pstmt.executeQuery();
			
			rlist = new ArrayList<reportNuri>();
			
			while(rset.next()){
				rn = new reportNuri();
				
				rn.setBoardNum(rset.getString("board_number"));
				rn.setBoardTitle(rset.getString("board_title"));
				rn.setBoardContent(rset.getString("board_content"));
				rn.setOwnerNickname(rset.getString("nuriboss"));
				rn.setUserNum(rset.getInt("user_number"));
				rn.setBoardDate(rset.getDate("board_date"));
				rn.setNuriNickname(rset.getString("reporter"));
				rn.setN_ownerNum(rset.getString("owner_number"));
				
				rlist.add(rn);
				System.out.println("리스트"+rlist);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return rlist;
	}


	public reportNuri reporDetail(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		reportNuri rn =null;
		
		String query =prop.getProperty("reportDetail");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				rn = new reportNuri();
				
				rn.setBoardNum(rset.getString("board_number"));
				rn.setBoardTitle(rset.getString("board_title"));
				rn.setBoardContent(rset.getString("board_content"));
				rn.setOwnerNickname(rset.getString("nuriboss"));
				rn.setUserNum(rset.getInt("user_number"));
				rn.setN_ownerNum(rset.getString("owner_number"));
				rn.setBoardDate(rset.getDate("board_date"));
				rn.setNuriNickname(rset.getString("reporter"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
			
		}
		
		
		return rn;
	}


	public int reportapprove(Connection con, String ownerNum) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("reportapprove");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1,ownerNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result;
	}


	public int InsertRegister(Connection con, reportNuri rn2) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("insertRegister");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, rn2.getUserNum()+"");
			pstmt.setString(2, rn2.getBoardTitle());
			pstmt.setString(3, rn2.getBoardContent());
			pstmt.setDate(4, rn2.getBoardDate());
			pstmt.setString(5,rn2.getN_ownerNum());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			
		}
		
		return result;
	}

}
