package com.projname.model;

import java.io.Serializable;


public class ProductDetails implements Serializable

{
	
	
	private static final long serialVersionUID = 1L;
	
	private String productid;
	private String producttype;
	private String productname;
	private String productdesc;
	private int enddate;
	private int minprice;
	
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public int getEnddate() {
		return enddate;
	}
	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}

}
