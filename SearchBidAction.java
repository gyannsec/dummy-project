package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.BidDAO;
import com.projname.model.BidDetails;

public class SearchBidAction extends ActionSupport


{

	
	private static final long serialVersionUID = 1L;
	
	private String productid="";
	   
	   private String searcherrmsg = "";
	   private List<BidDetails> bidlist1 = null;
	   
	    public String searchBidDisplay()
		{
			return "SEARCHBIDVIEW";
		}
		
	    public String searchBid()
		{
	    	BidDAO biddaoobj = new BidDAO();
	    	bidlist1 = biddaoobj.searchRecord(productid.trim());
		    if(bidlist1.size()>0)
		    {
		    	return "BIDFOUND";
		    }
		    else
		    {
		    	searcherrmsg = "PLEASE ENTER CORRECT PRODUCT ID";
		    	return "BIDNOTFOUND";
		    }
		}
	    
	    public String getProductid() {
			return productid;
		}

		public void setProductid(String productid) {
			this.productid = productid;
		}

		public String getSearcherrmsg() {
			return searcherrmsg;
		}

		public void setSearcherrmsg(String searcherrmsg) {
			this.searcherrmsg = searcherrmsg;
		}

		public List<BidDetails> getBidlist1() {
			return bidlist1;
		}

		public void setBidlist1(List<BidDetails> bidlist1) {
			this.bidlist1 = bidlist1;
		}


}
