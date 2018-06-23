package com.projname.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projname.model.UserDetails;

/*

create table userdetails
( email varchar(50) primary key,
  password varchar(25) not null,
  name varchar(50) not null,
  mobileno varchar(15),
  dob varchar(25),
  gender varchar(25),
  hobby varchar(75),
  country varchar(50),
  address varchar(150) 
);

*/

public class UserDAO 
{
	public boolean  addRecord(UserDetails userobj) 
	{
		//System.out.println("INSIDE ADD RECORD METHOD IN DAO");
		//System.out.println(userobj.getEmail() + "  "+ userobj.getCountry());
		
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?)");
		     
		     pst.setString(1, userobj.getEmail());
		     pst.setString(2, userobj.getPassword());
		     pst.setString(3, userobj.getName());
		     pst.setString(4, userobj.getMobileno());
		     pst.setString(5, userobj.getDob());
		     pst.setString(6, userobj.getGender());
		     pst.setString(7, userobj.getHobbyString());
		     pst.setString(8, userobj.getCountry());
		     pst.setString(9, userobj.getAddress());
		     		     
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
	
	public List<UserDetails> displayAllRecord() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<UserDetails> studentlist= new ArrayList<UserDetails>();
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		        	 	         
	         pst = connectionobject.prepareStatement("select * from userdetails");
	        		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 UserDetails sobj = new UserDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	sobj.setEmail(rs.getString(1));
		 		sobj.setPassword(rs.getString(2));
		 		sobj.setName(rs.getString(3));
		 		sobj.setMobileno(rs.getString(4));
		 		sobj.setDob(rs.getString(5));
		 		sobj.setGender(rs.getString(6));
		 		sobj.setHobbyString(rs.getString(7));
		 		sobj.setCountry(rs.getString(8));
		 		sobj.setAddress(rs.getString(9));
		 						
				//ADDED TO THE ARRAYLIST
		 		studentlist.add(sobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
			DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			DBConnectClose.closeMySQLResulsetConnection(rs);
			DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		
	    return studentlist;
	}
	

	public boolean deleteRecord(String email) 
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
	}

		
	public boolean updateRecord(UserDetails sobj) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = DBConnectClose.getMySQLConnection();
		     
	         pst = connectionobject.prepareStatement("update userdetails set name=?, mobileno=?,dob=?,address =? where email= ?");
		     
	         pst.setString(1, sobj.getName());
	         pst.setString(2, sobj.getMobileno());
	         pst.setString(3, sobj.getDob());
	         pst.setString(4, sobj.getAddress());
		     pst.setString(5, sobj.getEmail());
		    		    	     
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
	
	
	
	public List<UserDetails> searchRecord(String emailid) 
	{
		//System.out.println("DAO "+emailid);
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<UserDetails> studentlist= new ArrayList<UserDetails>();
		try
		{
	        connectionobject = DBConnectClose.getMySQLConnection();
		         
	        pst = connectionobject.prepareStatement("select * from userdetails where email= ?");
		    pst.setString(1, emailid);
		    		    	     
		    rs = pst.executeQuery();
		     
		    while(rs.next())
		     {
		    	 //CREATE STUDENT DETAIL OBJECT
		    	 UserDetails sobj = new UserDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	 sobj.setEmail(rs.getString(1));
			 	 sobj.setPassword(rs.getString(2));
			 	 sobj.setName(rs.getString(3));
			 	 sobj.setMobileno(rs.getString(4));
			 	 sobj.setDob(rs.getString(5));
			 	 sobj.setGender(rs.getString(6));
			 	 sobj.setHobbyString(rs.getString(7));
			 	 sobj.setCountry(rs.getString(8));
			 	 sobj.setAddress(rs.getString(9));
		 						
				//ADDED TO THE ARRAYLIST
		 		studentlist.add(sobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		 finally 
	     {
			 DBConnectClose.closeMySQLPreaparedStatementConnection(pst);
			 DBConnectClose.closeMySQLResulsetConnection(rs);
			 DBConnectClose.closeMySQLConnection(connectionobject);
		 }
		//System.out.println("LIST SIZE DAO " + studentlist.size());
	    return studentlist;
	}
 
}