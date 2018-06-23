package com.projname.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginLogoutAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	private String userid;
	private String password;
	private String jsppagemsg = "";
	private Map<String, Object> sessionMap;
	
	public String getUserid() 
	{
		return userid;
	}

	public void setUserid(String userid) 
	{
		this.userid = userid;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getJsppagemsg() 
	{
		return jsppagemsg;
	}

	public void setJsppagemsg(String jsppagemsg) 
	{
		this.jsppagemsg = jsppagemsg;
	}

	public String adminLoginPageDisplay()
	{
		return "ADMINLOGINPAGEVIEW";
	}
	
	// FOR SESSION CREATION
	@Override
	public void setSession(Map<String, Object> sessionMap) 
	{
		this.sessionMap = sessionMap;
	}
	
	public String adminLoginCheck()
	{
	    if(userid.equals("admin") &&  password.equals("admin"))
	    {
	    	sessionMap.put("uid", "ADMIN");
	                 	        
		    return "SUCCESS";
	    }
	    else
	    {
	    	jsppagemsg = "INVALID USERID OR PASSWORD";
		    return "INVALID";
	    }
	}
	
	public String adminLogout() 
    {
        // remove userName from the session
        if (sessionMap.containsKey("uid")) 
        {
            sessionMap.remove("uid");
        }
        return "ADMINLOGIN";
    }
	
	
	public void validate()
	{
		if("".equals(userid))
		{
			addFieldError("userid", "USERID CAN'T BE BLANK");
		}
		
		if("".equals(password))
		{
			addFieldError("password", "PASSWORD CAN'T BE BLANK");
		}
	}

}
