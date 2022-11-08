package com.kh.nuriter.payment.model.service;

import com.kh.nuriter.member.model.dao.MemberDao;
import com.kh.nuriter.payment.model.dao.PaymentDao;
import com.kh.nuriter.payment.model.vo.Payment;
import com.kh.nuriter.payment.model.vo.PaymentDetail;

import static com.kh.nuriter.common.JDBCTemplate.*;

import java.sql.Connection;


public class PaymentService {

	public int InsertPayment(Payment p) {
		int result = 0;
		Connection con = getConnection();

		result = new PaymentDao().InsertPayment(p,con);

		if(result >0){
			commit(con);

		}else{
			rollback(con);


		}
		close(con);




		return result;
	}

	public int InsertApplication(Payment p1) {
		int result2 =0;
		Connection con =getConnection();

		result2 = new PaymentDao().InsertApplication(con,p1);

		if(result2 >0){
			commit(con);

		}else{
			rollback(con);


		}
		close(con);




		return result2;
	}

	public int InsertPaymentDetail(PaymentDetail pd) {
		int result3 =0;

		Connection con = getConnection();

		result3= new PaymentDao().InsertPaymentDetail(pd,con);

		if(result3 >0){
			commit(con);
		}else{
			rollback(con);
		}


		return result3;
	}

	public int doRefundNuri(String nuriNum, String userNum) {
		Connection con = getConnection();

		int result = new PaymentDao().doRefundNuri(con, nuriNum, userNum);

		if(result >0){
			commit(con);
		}else{
			rollback(con);
		}

		close(con);

		return result;
	}

	public int getTotalPayNum(String nuriNum) {
		Connection con = getConnection();

		int result = new PaymentDao().getTotalPayNum(con, nuriNum);

		close(con);

		return result;
	}

	public int getTotalPayNum2(String nuriNum) {
		Connection con = getConnection();

		int result = new PaymentDao().getTotalPayNum2(con, nuriNum);

		close(con);

		return result;
	}

	public int updateAttention(String userNum, String nuriNum) {
		Connection con = getConnection();
		
		int result = new PaymentDao().updateAttention(con, userNum, nuriNum);
		
		if(result >0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int checkPayment(String userNum, String nuriNum) {
		Connection con = getConnection();
		
		int result = new PaymentDao().checkPayment(con, userNum, nuriNum);
		
		if(result >0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


}
