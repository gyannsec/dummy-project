package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.ProductDAO;
import com.projname.model.ProductDetails;

public class DisplayAllProductAction extends ActionSupport 

{
	private static final long serialVersionUID = 1L;
	List<ProductDetails> prolist = null;
	private boolean noData = false;
	
	public boolean isNoData() 
	{
		return noData;
	}

	public void setNoData(boolean noData) 
	{
		this.noData = noData;
	}

	public List<ProductDetails> getProlist() 
	{
		return prolist;
	}

	public void setProlist(List<ProductDetails> prolist) 
	{
		this.prolist = prolist;
	}

	@Override
	public String execute() 
	{
		ProductDAO prodaoobj = new ProductDAO();
		prolist = prodaoobj.displayAllProduct();
		
		if(prolist.size()>0)
		{
			noData = true;
		}
		else
		{
			noData = false;
		}
		
		return "DISPLAYALLPRODUCT";
	}

}
