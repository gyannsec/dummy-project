package com.projname.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projname.model.BidDetails;

public class BidDAO

{
	
	public boolean  addRecord(BidDetails bidobj) 
	{
		//System.out.println("INSIDE ADD RECORD METHOD IN DAO");
		//System.out.println(userobj.getEmail() + "  "+ userobj.getCountry());
		
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("insert into biddetails values(?,?,?,?,?)");
		     
		     pst.setString(1, bidobj.getEmail());
		     pst.setString(2, bidobj.getProductid());
		     pst.setInt(3, bidobj.getBidprice());
		     pst.setString(4, bidobj.getProducttype());
		     pst.setString(5, "Not Selected");
		     
		     		     
		     int i = pst.executeUpdate();
		     
		     System.out.println(i);
		     
		     if(i > 0 )
		    	 f = true;
           
	    }catch(SQLException e){e.printStackTrace();}
	     finally 
	     {
	    	 DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
	    	 DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	
	public List<BidDetails> displayAllRecord() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<BidDetails> bidlist= new ArrayList<BidDetails>();
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		        	 	         
	         pst = connectionobject.prepareStatement("select * from biddetails");
	        		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 BidDetails sobj = new BidDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	sobj.setEmail(rs.getString(1));
		 		sobj.setProductid(rs.getString(2));
		 		sobj.setBidprice(rs.getInt(3));
		 		sobj.setProducttype(rs.getString(4));
		 		sobj.setStatus(rs.getString(5));
		 		
		 						
				//ADDED TO THE ARRAYLIST
		 		bidlist.add(sobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
			DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			DBConnectClose.closeMySQLResulsetConnection(rs);
			DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return bidlist;
	}
	

	/*public boolean deleteRecord(String email) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("delete from userdetails where email= ?");
		     pst.setString(1, email);
		    		    	     
		     int noofrecorddeleted = pst.executeUpdate();
		     
		     if(noofrecorddeleted > 0)
		     {
		    	 f = true;
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
			DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	
	
	public boolean userLoginCheck(String email,String password) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean found = false;
		
		try
		{
	        connectionobject = DBConnectClose.getMySQLConnection();
		         
	        pst = connectionobject.prepareStatement("select * from userdetails where email= ? and password = ?");
		    pst.setString(1, email);
		    pst.setString(2, password);
		    		    	     
		    rs = pst.executeQuery();
		     
		   if(rs.next())
		   {
			   found = true;
				
		   }
	    }catch(SQLException e){System.out.print(e.toString());}
		 finally 
	     {
			 DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			 DBConnectClose.closeMySQLResulsetConnection(rs);
			 DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return found;
	}*/

		
	public boolean updateRecord(String email,String productid) 
	{
	System.out.println("Email"+email+"ProductId"+productid);
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("update biddetails set status=? where email= ? and productid=?");
		     
	         pst.setString(1, "SELECTED");
	         pst.setString(2, email);
	         pst.setString(3, productid);
	        
		    		    	     
		     int noofrecorddeleted = pst.executeUpdate();
		     
		     if(noofrecorddeleted > 0)
		     {
		    	 f = true;
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
			DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
		
	
	
	public List<BidDetails> searchRecord(String productid) 
	{
		//System.out.println("DAO "+emailid);
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<BidDetails> bidlist= new ArrayList<BidDetails>();
		try
		{
	        connectionobject = DBConnectClose.getMySQLConnection();
		         
	        pst = connectionobject.prepareStatement("select * from biddetails where productid= ?");
		    pst.setString(1, productid);
		    		    	     
		    rs = pst.executeQuery();
		     
		    while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 BidDetails bobj = new BidDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	 bobj.setEmail(rs.getString(1));
			 	 bobj.setProductid(rs.getString(2));
			 	 bobj.setBidprice(rs.getInt(3));
			 	 bobj.setProducttype(rs.getString(4));
			 	 bobj.setStatus(rs.getString(5));
		 						
				//ADDED TO THE ARRAYLIST
		 		bidlist.add(bobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		 finally 
	     {
			 DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			 DBConnectClose.closeMySQLResulsetConnection(rs);
			 DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		//System.out.println("LIST SIZE DAO " + studentlist.size());
	    return bidlist;
	
	
	}
}
