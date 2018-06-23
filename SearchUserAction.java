package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.UserDAO;
import com.projname.model.UserDetails;

public class SearchUserAction extends ActionSupport
{
   private static final long serialVersionUID = 1L;
   private String email="";
   
   private String searcherrmsg = "";
   private List<UserDetails> userlist1 = null;
   
    public String searchPageDisplay()
	{
		return "SEARCHPAGEVIEW";
	}
	
    public String searchUser()
	{
    	UserDAO userdaoobj = new UserDAO();
    	userlist1 = userdaoobj.searchRecord(email.trim());
	    if(userlist1.size()>0)
	    {
	    	return "USERFOUND";
	    }
	    else
	    {
	    	searcherrmsg = "PLEASE ENTER CORRECT EMAIL ID";
	    	return "USERNOTFOUND";
	    }
	}
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSearcherrmsg() {
		return searcherrmsg;
	}

	public void setSearcherrmsg(String searcherrmsg) {
		this.searcherrmsg = searcherrmsg;
	}

	public List<UserDetails> getUserlist1() {
		return userlist1;
	}

	public void setUserlist1(List<UserDetails> userlist1) {
		this.userlist1 = userlist1;
	}
}