package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute()  
	{
		System.out.println("INDEX");
		
		return "INDEX";
    }

}
