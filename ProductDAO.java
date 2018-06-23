package com.projname.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projname.model.ProductDetails;

public class ProductDAO

{
	/*

	create table productdetails
	( productid varchar(50) primary key,
	  producttype varchar(25) not null,
	  productname varchar(50) not null,
	  productdesc varchar(150),
	  enddate int,
	  minprice int
	  	);

	*/

	
	public boolean  addProduct(ProductDetails proobj) 
	{
		//System.out.println("INSIDE ADD RECORD METHOD IN DAO");
		//System.out.println(userobj.getEmail() + "  "+ userobj.getCountry());
		
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("insert into productdetails values(?,?,?,?,?,?)");
		     
		     pst.setString(1, proobj.getProductid());
		     pst.setString(2, proobj.getProducttype());
		     pst.setString(3, proobj.getProductname());
		     pst.setString(4, proobj.getProductdesc());
		     pst.setInt(5, proobj.getEnddate());
		     pst.setInt(6, proobj.getMinprice());
		   
		     		     
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
	
	public List<ProductDetails> displayAllProduct() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<ProductDetails> prolist= new ArrayList<ProductDetails>();
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		        	 	         
	         pst = connectionobject.prepareStatement("select * from productdetails");
	        		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 ProductDetails pobj = new ProductDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	pobj.setProductid(rs.getString(1));
		 		pobj.setProducttype(rs.getString(2));
		 		pobj.setProductname(rs.getString(3));
		 		pobj.setProductdesc(rs.getString(4));
		 		pobj.setEnddate(rs.getInt(5));
		 		pobj.setMinprice(rs.getInt(6));
		 		
		 						
				//ADDED TO THE ARRAYLIST
		 		prolist.add(pobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
			DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			DBConnectClose.closeMySQLResulsetConnection(rs);
			DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return prolist;
	}
	

	public boolean deleteProduct(String productid) 
	{
		
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("delete from productdetails where productid= ?");
		     pst.setString(1, productid);
		    		    	     
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
	
	
	public boolean productLoginCheck(String productid) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean found = false;
		
		try
		{
	        connectionobject = DBConnectClose.getMySQLConnection();
		         
	        pst = connectionobject.prepareStatement("select * from productdetails where productid= ?");
		    pst.setString(1, productid);
		    
		    		    	     
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
	}

		
	public boolean updateProduct(ProductDetails pobj) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("update productdetails set producttype=?,productname=?, productdesc=?, minprice =? where productid= ?");
		     
	         pst.setString(1, pobj.getProducttype());
	         pst.setString(2, pobj.getProductname());
	         pst.setString(3, pobj.getProductdesc());
	         pst.setInt(4, pobj.getMinprice());
	         pst.setString(5, pobj.getProductid());
		     
		    		    	     
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
	
	
	
	public List<ProductDetails> searchProduct(String producttype) 
	{
		//System.out.println("DAO "+productno);
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<ProductDetails> prolist= new ArrayList<ProductDetails>();
		try
		{
	        connectionobject = DBConnectClose.getMySQLConnection();
		         
	        pst = connectionobject.prepareStatement("select * from productdetails where producttype= ?");
		    pst.setString(1, producttype);
		    		    	     
		    rs = pst.executeQuery();
		     
		    while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 ProductDetails pobj = new ProductDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	 pobj.setProductid(rs.getString(1));
			 		pobj.setProducttype(rs.getString(2));
			 		pobj.setProductname(rs.getString(3));
			 		pobj.setProductdesc(rs.getString(4));
			 		pobj.setEnddate(rs.getInt(5));
			 		pobj.setMinprice(rs.getInt(6));
			 						
				//ADDED TO THE ARRAYLIST
		 		prolist.add(pobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		 finally 
	     {
			 DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			 DBConnectClose.closeMySQLResulsetConnection(rs);
			 DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		//System.out.println("LIST SIZE DAO " + studentlist.size());
	    return prolist;
	}
 
	
	
}
