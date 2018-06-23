package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.ProductDAO;
import com.projname.model.ProductDetails;

public class SearchProductInputAction extends ActionSupport
{
   private static final long serialVersionUID = 1L;
   private String producttype="";
   
   private String searcherrmsg = "";
   private List<ProductDetails> productlist1 = null;
   
    public String searchPageDisplay()
	{
		return "SEARCHPAGEVIEW";
	}
	
    public String searchProduct()
	{
    	System.out.println(producttype);
    	ProductDAO prodaoobj = new ProductDAO();
    	productlist1 = prodaoobj.searchProduct(producttype);
	    if(productlist1.size()>0)
	    {
	    	return "PRODUCTFOUND";
	    }
	    else
	    {
	    	searcherrmsg = "PRODUCT TYPE CANNOT BE BLANK";
	    	return "PRODUCTNOTFOUND";
	    }
	}
    
    
	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getSearcherrmsg() {
		return searcherrmsg;
	}

	public void setSearcherrmsg(String searcherrmsg) {
		this.searcherrmsg = searcherrmsg;
	}

	public List<ProductDetails> getProductlist1() {
		return productlist1;
	}

	public void setProductlist1(List<ProductDetails> productlist1) {
		this.productlist1 = productlist1;
	}
}