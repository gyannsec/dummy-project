package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.BidDAO;


public class SelectAction extends ActionSupport 

{

	
	private static final long serialVersionUID = 1L;
   
	
	private String email;
	private String productid;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String execute()
	{
		BidDAO biddaoobj = new BidDAO();
        boolean reply = biddaoobj.updateRecord(email,productid);
		return "SELECTUSER";
	}
}
