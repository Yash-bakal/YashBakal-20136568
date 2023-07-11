package com;
import java.util.*;
import java.sql.*;

class Book{
	
	static void addbook() {
		int id;
		String bname;
		String aname;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt1","root","Sqlreset123@#");
			PreparedStatement pstmt = con.prepareStatement("Insert into test2 value(?,?,?)");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter ISBN No");
            id=sc.nextInt();
            System.out.println("Enter Book Name");
            bname=sc.next();
            System.out.println("Enter Author Name");
            aname=sc.next();
            
            pstmt.setInt(1,id);
            pstmt.setString(2,bname);
            pstmt.setString(3,aname);
            
            pstmt.execute();
            pstmt.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static void displaybook() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt1","root","Sqlreset123@#");
	        Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * From test2");
		
			while(rs.next()) {
				
			System.out.println(rs.getInt(1)+" :"+rs.getString(2)+" "+ rs.getString(3));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void searchbook() {
		
	}
	
	static void countbook() {
		
	}
}


public class Library {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int ch=0;
		do {
			
			System.out.println("1. Add Book");
			System.out.println("2. Display All book details");
			System.out.println("3. Search Book by author");
			System.out.println("4. COunt number of books - by book name");
			System.out.println("5. EXIT");
			System.out.println("Enter choice : ");
			ch=sc.nextInt();
			if(ch==1){
				    Book.addbook();
			   }
			else if(ch==2){
				Book.displaybook();
		   }
			else if(ch==3){
				Book.searchbook();
		   }
			else if(ch==4){
				Book.countbook();
		       }		
	    }
		while(ch!=5);

	}

}
