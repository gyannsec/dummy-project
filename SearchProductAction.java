package com.projname.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.ProductDAO;

public class SearchProductAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	private String producttype;
	private String productname;
	private String jsppagemsg = "";
	private Map<String, Object> sessionMap;
	
	public String getProductType() 
	{
		return producttype;
	}

	public void set(String producttype) 
	{
		this.producttype = producttype;
	}

	public String getProductName() 
	{
		return productname;
	}

	public void setProductName(String productname) 
	{
		this.productname = productname;
	}

	public String getJsppagemsg() 
	{
		return jsppagemsg;
	}

	public void setJsppagemsg(String jsppagemsg) 
	{
		this.jsppagemsg = jsppagemsg;
	}

	public String loginProductPageDisplay()
	{
		return "LOGINPRODUCTPAGEVIEW";
	}
	
	// FOR SESSION CREATION
	@Override
	public void setSession(Map<String, Object> sessionMap) 
	{
		this.sessionMap = sessionMap;
	}
	
	public String productLoginCheck()
	{
	    ProductDAO productdaoobj = new ProductDAO();
        boolean reply =productdaoobj.productLoginCheck(producttype);
        
	    if(reply)
	    {
	    	sessionMap.put("uname", producttype);
	                 	        
		    return "SUCCESS";
	    }
	    else
	    {
	    	//jsppagemsg = "INVALID PRODUCTTYPE";
		    return "INVALID";
	    }
	}
	
	public String logout() 
    {
        // remove userName from the session
        if (sessionMap.containsKey("uname")) 
        {
            sessionMap.remove("uname");
        }
        return "HOME";
    }
	
	
	public void validate()
	{
		if("".equals(producttype))
		{
			addFieldError("producttype", "PRODUCTTYPE CAN'T BE BLANK");
		}
		

	}

	

}
