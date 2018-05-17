package com.ts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InsuranceDAO {

	public  UserBean isUser(String uid,String pwd)
	{
		UserBean deatails=new UserBean();
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/insurance","root","root");  
			//here sonoo is database name, root is username and password  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select role,Uname from underwriter where User_id='"+uid+"' and Password='nuser'");  
			
			while(rs.next())  
			{
		deatails.setRole(rs.getString(1));
		deatails.setUsername(rs.getString(2));
			}
			rs.close();
			con.close(); 
		}
			catch(Exception e){ System.out.println(e);} 
		finally {
			return deatails;
		}
		
			}
	
	
	public ArrayList<String> autoModelList()
	{
		ArrayList<String> models=new ArrayList<String>();
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/insurance","root","root");  
			//here sonoo is database name, root is username and password  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select vehicle_model_name from auto_rates");  
			
			while(rs.next())  
			{
		models.add(rs.getString(1));
			}
			rs.close();
			con.close(); 
		}
			catch(Exception e){ System.out.println(e);} 
		finally {
			return models;
		}
		
	}
	
	public int basePremium(String model)
	{
		int base=0;
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/insurance","root","root");  
			//here sonoo is database name, root is username and password  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select Auto_base_Premium  from auto_rates where vehicle_model_name='"+model+"'");  
			
			while(rs.next())  
			{
		base=(rs.getInt(1));
			}
			rs.close();
			con.close(); 
		}
			catch(Exception e){ System.out.println(e);} 
		finally {
			return base;
		}
		
	}
	
	}
	
	
	
	

