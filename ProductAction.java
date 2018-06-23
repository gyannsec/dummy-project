package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projname.dao.ProductDAO;

import com.projname.model.ProductDetails;


public class ProductAction extends ActionSupport implements ModelDriven<ProductDetails>

{
	
private static final long serialVersionUID = 1L;
	
	private ProductDetails proobj = new ProductDetails();

	@Override
	public ProductDetails getModel() {
		
		return proobj;
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
	
	public String productPageDisplay()
	{
		return "PRODUCTPAGEVIEW";
	}
		
	public String addProductRecord()
	{
		System.out.println("INSIDE ADD PRODUCT RECORD");
		
		ProductDAO productdaoobj = new ProductDAO();
        boolean reply = productdaoobj.addProduct(proobj);
        
        if(reply)
        {
        	jsppagemsg = "PRODUCT ADDED";
        	
        }
        else
        {
        	jsppagemsg = "ERROR OCCURRED";
        	
        }	
        
        return "REGREPLY";
	}

	
	public void validate()
	{
		if("".equals(proobj.getProductid()))
		{
			addFieldError("productid", "PRODUCT ID CAN'T BE BLANK");
		}
		
		
	}

}
