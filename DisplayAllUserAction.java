package com.projname.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.UserDAO;
import com.projname.model.UserDetails;

public class DisplayAllUserAction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	List<UserDetails> userlist = null;
	private boolean noData = false;
	
	public boolean isNoData() 
	{
		return noData;
	}

	public void setNoData(boolean noData) 
	{
		this.noData = noData;
	}

	public List<UserDetails> getUserlist() 
	{
		return userlist;
	}

	public void setUserlist(List<UserDetails> userlist) 
	{
		this.userlist = userlist;
	}

	@Override
	public String execute() 
	{
		UserDAO userdaoobj = new UserDAO();
		userlist = userdaoobj.displayAllRecord();
		
		if(userlist.size()>0)
		{
			noData = true;
		}
		else
		{
			noData = false;
		}
		
		return "DISPLAYALLUSER";
	}
}