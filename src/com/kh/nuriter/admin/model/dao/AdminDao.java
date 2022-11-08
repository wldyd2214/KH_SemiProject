package com.kh.nuriter.admin.model.dao;

import static com.kh.nuriter.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.nuriter.attend.model.dao.AttendCodeDao;

public class AdminDao {
private Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = AttendCodeDao.class.getResource("/sql/admin/admin-query.properties").getPath();
	
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

	public int getListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);

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

	public int selectMemberCount(Connection con) {
		PreparedStatement pstmt = null;
		int memberCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectMemberCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return memberCount;
	}

	public int selectActivatedCount(Connection con) {
		PreparedStatement pstmt = null;
		int activateCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectActivateCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				activateCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return activateCount;
	}

	public int selectJoinCount(Connection con) {
		PreparedStatement pstmt = null;
		int memberJoinCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectMemberJoinCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberJoinCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return memberJoinCount;
	}

	public int selectNuriterCount(Connection con) {
		PreparedStatement pstmt = null;
		int nuriterCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectNuriterCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				nuriterCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return nuriterCount;
	}
	
}
