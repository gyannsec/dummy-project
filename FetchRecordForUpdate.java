package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.UserDAO;
import com.projname.model.UserDetails;

public class FetchRecordForUpdate extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String email="";
	
	List<UserDetails> userlist = null;
	
	@Override
	public String execute()
	{
		UserDAO sdaoobj = new UserDAO();
		userlist = sdaoobj.searchRecord(email);
		return "FOUND";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserDetails> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserDetails> userlist) {
		this.userlist = userlist;
	}
}