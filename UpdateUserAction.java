package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projname.dao.UserDAO;
import com.projname.model.UserDetails;

public class UpdateUserAction extends ActionSupport implements ModelDriven<UserDetails>
{
	private static final long serialVersionUID = 1L;
		
    private UserDetails usrobj = new UserDetails();
	
	@Override
	public UserDetails getModel() 
	{
		return usrobj;
	}

	private String updatemsg = "";
		
	@Override
	public String execute()
	{
		UserDAO userdaoobj = new UserDAO();
        boolean reply = userdaoobj.updateRecord(usrobj);
        
        if(reply)
        {
        	updatemsg = "UPDATE SUCCESSFULL";
        }
        else
        {
        	updatemsg = "ERROR OCCURRED";
        }	
        
		return "UPDATEUSER";
	}

	public String getUpdatemsg() {
		return updatemsg;
	}

	public void setUpdatemsg(String updatemsg) {
		this.updatemsg = updatemsg;
	}

}