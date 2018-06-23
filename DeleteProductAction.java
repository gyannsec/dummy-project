package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.ProductDAO;

public class DeleteProductAction extends ActionSupport

{

	
	private static final long serialVersionUID = 1L;
	
	String productid="";
	String deletemsg="";
	
	
	
	@Override
	public String execute() 
	{
		ProductDAO sdaoobj = new ProductDAO();
        boolean reply = sdaoobj.deleteProduct(productid);
        
        if(reply)
        {
        	deletemsg = "DELETE SUCCESSFULL";
        }
        else
        {
        	deletemsg = "NOT DELETED";
        }	
        
        return "DELETEPRODUCT";
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDeletemsg() {
		return deletemsg;
	}

	public void setDeletemsg(String deletemsg) {
		this.deletemsg = deletemsg;
	}


}
