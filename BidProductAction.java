package com.projname.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projname.dao.BidDAO;
import com.projname.model.BidDetails;


public class BidProductAction extends ActionSupport implements ModelDriven<BidDetails>


{

	
	private static final long serialVersionUID = 1L;
	
	private BidDetails bidobj = new BidDetails();
	

	@Override
	public BidDetails getModel() {
		
		return bidobj;
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
		return "BIDPAGEVIEW";
	}
		
	public String addBidRecord()
	{
		System.out.println("INSIDE ADD BID RECORD");
		
		BidDAO biddaoobj = new BidDAO();
        boolean reply = biddaoobj.addRecord(bidobj);
        
        if(reply)
        {
        	jsppagemsg = "BID SUCCESSFULL";
        	
        }
        else
        {
        	jsppagemsg = "ERROR OCCURRED";
        	
        }	
        
        return "REGREPLY";
	}

	public void validate()
	{
		if("".equals(bidobj.getEmail()))
		{
			addFieldError("email", "EMAIL CAN'T BE BLANK");
		}
		
		if("".equals(bidobj.getProductid()))
		{
			addFieldError("productid", "PRODUCT ID CAN'T BE BLANK");
		}
		
		if("".equals(bidobj.getBidprice()))
		{
			addFieldError("bidprice", "BID PRICE CAN'T BE BLANK");
		}
		
		if("".equals(bidobj.getProducttype()))
		{
			addFieldError("producttype", "PRODUCT TYPE CAN'T BE BLANK");
		}
			}

}
