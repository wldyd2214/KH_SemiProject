package com.kh.nuriter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper {

	public LoginWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key){
		String value="null";
		
		if(key != null && key.equals("password")){
			value = getSha512(super.getParameter("password"));
		}else if(key != null && key.equals("newPassword")){
			value = getSha512(super.getParameter("newPassword"));
		}else{
			value=super.getParameter(key);
		}
		
		return value;
	}
	
	public static String getSha512(String pwd){
		String encPwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("utf-8"));
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest());
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		
		return encPwd;
	}
	
	
}
