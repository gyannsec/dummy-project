package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.UserDAO;

public class DeleteUserAction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	String email="";
	String deletemsg="";
	
	
	
	@Override
	public String execute() 
	{
		UserDAO sdaoobj = new UserDAO();
        boolean reply = sdaoobj.deleteRecord(email);
        
        if(reply)
        {
        	deletemsg = "DELETE SUCCESSFULL";
        }
        else
        {
        	deletemsg = "NOT DELETED";
        }	
        
        return "DELETEUSER";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeletemsg() {
		return deletemsg;
	}

	public void setDeletemsg(String deletemsg) {
		this.deletemsg = deletemsg;
	}
}