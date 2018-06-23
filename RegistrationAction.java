package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projname.dao.UserDAO;
import com.projname.model.UserDetails;

public class RegistrationAction extends ActionSupport implements ModelDriven<UserDetails>
{
	private static final long serialVersionUID = 1L;
	
	private UserDetails userobj = new UserDetails();
	
	@Override
	public UserDetails getModel() 
	{
		return userobj;
	}

	private String jsppagemsg = "";
	
	public String getJsppagemsg() 
	{
		return jsppagemsg;
	}

	public void setJsppagemsg(String jsppagemsg) 
	{
		this.jsppagemsg = jsppagemsg;
	}
	
	public String regPageDisplay()
	{
		return "REGISTRATIONPAGEVIEW";
	}
		
	public String addUserRecord()
	{
		System.out.println("INSIDE ADD USER RECORD");
		
		UserDAO userdaoobj = new UserDAO();
        boolean reply = userdaoobj.addRecord(userobj);
        
        if(reply)
        {
        	jsppagemsg = "REGISTRATION SUCCESSFULL";
        	
        }
        else
        {
        	jsppagemsg = "ERROR OCCURRED";
        	
        }	
        
        return "REGREPLY";
	}

	public void validate()
	{
		if("".equals(userobj.getEmail()))
		{
			addFieldError("email", "EMAIL CAN'T BE BLANK");
		}
		
		if("".equals(userobj.getPassword()))
		{
			addFieldError("password", "PASSWORD CAN'T BE BLANK");
		}
		
		if(userobj.getPassword() != null)
		{
		   if((userobj.getPassword().length() > 0) && (userobj.getPassword().length() < 6))
		   {
			  addFieldError("password", "PASSWORD SHOULD BE MIN 6 CHAR");
		   }
		}
		
		if("".equals(userobj.getMobileno()))
		{
			addFieldError("mobileno", "MOBILE NO CAN'T BE BLANK");
		}
		
		if(userobj.getMobileno() != null)
		{
		   if((userobj.getMobileno().length() > 0) && (userobj.getMobileno().length() != 10))
		   {
		  	  addFieldError("mobileno", "MOBILE NO SHOULD BE 10 DIGIT");
		   }
		}
	}
}