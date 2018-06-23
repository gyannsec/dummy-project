package com.projname.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.projname.dao.BidDAO;
import com.projname.model.BidDetails;

public class DisplayAllBidAction extends ActionSupport

{

	
	private static final long serialVersionUID = 1L;
	
	List<BidDetails> bidlist = null;
	private boolean noData = false;
	
	public boolean isNoData() 
	{
		return noData;
	}

	public void setNoData(boolean noData) 
	{
		this.noData = noData;
	}

	public List<BidDetails> getBidlist() 
	{
		return bidlist;
	}

	public void setBidlist(List<BidDetails> bidlist) 
	{
		this.bidlist = bidlist;
	}

	@Override
	public String execute() 
	{
		BidDAO biddaoobj = new BidDAO();
		bidlist = biddaoobj.displayAllRecord();
		
		if(bidlist.size()>0)
		{
			noData = true;
		}
		else
		{
			noData = false;
		}
		
		return "DISPLAYALLBID";
	}


}
