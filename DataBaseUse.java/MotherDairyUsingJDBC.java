package com;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class MotherDairyUsingJDBC {
//     private ArrayList<products> arryAdd=new ArrayList<>();
	Scanner sc=new Scanner(System.in);

	//	private String productName;
	public void printProduct() {
	try {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","mukesh@123");

//		read data from java program;;
		Statement stmt1=con.createStatement();
		ResultSet rs=stmt1.executeQuery("select *from product");
		System.out.println("************ I have all Product ***********");
		System.out.println("+-----+-------+------+------+");

		System.out.println("Id\tName\tPrice\tQuantity");
		System.out.println("+-----+-------+------+------+");

		while(rs.next()) {
			System.out.println("|  "+rs.getInt(1)+"|\t  "+rs.getString(2)+"|\t   "+rs.getInt(3)+"|\t  "+rs.getInt(4)+"|\t");
		}
		System.out.println("+-----+-------+------+------+");

	}catch(Exception e) {
		System.out.println(e);
	}
		
	}
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","mukesh@123");

		 // variables  
		PreparedStatement stmt=null;
		int id,choice;
//		String name, course,sql;
		
		
		Scanner sc=new Scanner(System.in); 
		  System.out.println("\t\t\t\t--------------------Invoice-----------------");  
          System.out.println("\t\t\t\t\t "+"  "+"Metro Mart MotherDairy Shop");  
          System.out.println("\t\t\t\t\t3/98 Accurate Greater Noida");  
          System.out.println("\t\t\t\t\t"  +"    " +"Just front of NIT college Walk");  
          System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (+91) 7480082596");  
          //format of date and time  
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
          Date date = new Date();    
          Calendar calendar = Calendar.getInstance();  
          String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
          //prints current date and time  
          System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+91) 6278180661");  
          System.out.print("Enter Customer Name: ");  
          String customername=sc.nextLine();
         
        String name ;  
        int quantity ;  
        int price ;  
       
        MotherDairyUsingJDBC sms=new MotherDairyUsingJDBC();
		
		 while (true) {
	            System.out.println("\nWelcome to MotherDairy\n");
	            System.out.println("Press 1. For add the prduct");
	            System.out.println("Press 2. For search the product ");
	            System.out.println("Press 3. For sale the product");
	            System.out.println("Press 4. For Show the product");
	            System.out.println("press 5. Do you want Delete product");
	            System.out.println("Press 0. For Exit");
	            System.out.print("\nEnter your choice: ");

	           
	             choice =sc.nextInt();
	            sc.nextLine();
	            
	            switch(choice) {
	            case 1:
					 stmt=con.prepareStatement("insert into product values(?,?,?,?)");

	            	 System.out.print("Product ID's: ");
                      id = sc.nextInt();
                     
                     sc.nextLine();
                    System.out.print("Product Name: ");
                     name = sc.nextLine();
                    
                    System.out.print("Unit Price: ");
                     price = sc.nextInt();
                    
                    System.out.print("Product Quantity: ");
                    
                     quantity = sc.nextInt();
                     
                     stmt.setInt(1,id);
					   
					   stmt.setString(2, name);
					   stmt.setInt(3,price);
					   stmt.setInt(4, quantity);
					   
					   int i=stmt.executeUpdate();
//					   this method used to excute quary;
					   
					   if(i>0) {
						   System.out.println("Data Save successfully");
					   }
					   else {
						   System.out.println("Quary problem");
					   }
//	                products addPro=new products( id, productName , price, quantity);
//	                
//                    sms.addProduct(addPro);
                    System.out.println("Thank you for Update");
                    break;
                   
	            case 2:
	            	sms.searchProduct();
	            	break;
	            case 3:
	            	sms.saleProduct();
	            	break;
	            
	            case 4:
	            	sms.printProduct();
	            	break;
	            	
	            case 5:
	            	sms.deleteProduct();
	            case 0:
	            	System.out.println("Exiting the program");
	            	sc.close();
	            	System.exit(0);
	           default :
	        	   System.out.println("Worng choice please Enter the choice!");
	        	   break;
                    
	            		
	          	}
	         
	       }
//         sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void searchProduct() {

		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","mukesh@123");

			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the product name");
			String name=sc.nextLine();
			System.out.println("Enter id");
			int id=sc.nextInt();
			Statement stmt1=con.createStatement();
			ResultSet rs=stmt1.executeQuery("select *from product");
			while(rs.next()) {
				if(rs.getInt(1)==id || rs.getString(2)==name) {
                    System.out.println("***********Searching product is:: ***********");
            		System.out.println("+-------+--------+-------+--------+");

            		System.out.println("|Id\t|Name\t|Price\t|Quantity|");
            		System.out.println("+-------+--------+-------+--------+");

        			System.out.println("|"+rs.getInt(1)+"\t|"+rs.getString(2)+"\t|"+rs.getInt(3)+"\t|"+rs.getInt(4)+"\t |");
            		System.out.println("+-------+--------+------+--------+");

        			break;
				}
				
				
			}
			

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void saleProduct() {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","mukesh@123");

			Statement stmt1=con.createStatement();
			ResultSet rs=stmt1.executeQuery("select *from product");

			
			 System.out.println("Enter the product details: ");  
             System.out.print("Product ID: ");  
             int id = sc.nextInt();  
              sc.nextLine();
              sc.nextLine();
             System.out.print("Product Name: ");  
              String name = sc.nextLine();  
              double ta = 0,gsta = 0,fa = 0,d = 0, q;
              int sq = 0;
              boolean found=false;
              while(rs.next()) {
            	  if(rs.getInt(1)==id || rs.getString(2)==name) {
            		  System.out.println("*********** To sale product is:: ***********");
                		System.out.println("+=======+========+=======+");

              		System.out.println("|Id\t|Name\t|Price\t|");
              		System.out.println("+=======+========+=======+");

          			System.out.println("|"+rs.getInt(1)+"\t|"+rs.getString(2)+"\t|"+rs.getInt(3)+"\t |");
              		System.out.println("+=======+========+=======+");

              		System.out.println("Enter the quantity");
              		double qu=sc.nextDouble();
              		if(qu<=rs.getInt(4)) {
              			d=rs.getInt(3);
              			ta=qu*d;
              			 gsta=ta*0.18;
              		   fa=ta+gsta;
              		   q=rs.getInt(4);
              		   q-=qu;
//              		  p.quantity -=sq;
              		   
           		   System.out.println("******************I have product***********");
            			System.out.println("+=======+=========+=======+======  |");
            			System.out.println("| Id    |   Name  |price  |Quantity|");
            			System.out.println("+=======+=========+=======+========|");
            			
          			System.out.println("|"+id+"\t|"+name+"\t\t|"+d+"\t|"+sq+"\t|");
        			System.out.println("+=======+=========+=======+========|");

                      System.out.println("\n\n\t\t\t\t\t\tTotal Amount (Rs.) " +ta);
                      
                      System.out.println("\n\n\t\t\t\t\t\tTotal GST (Rs.) " +gsta);
                      System.out.println("\n\n\t\t\t\t\t\tTotal PeyaBale  " +fa);
          			System.out.println("");
          		 System.out.println("\t\t\t\t---------------Thank You for Shopping!!-----------------");  
                System.out.println("\t\t\t\t                     Visit Again");  

                break;
              		} 
              		else
              		  {
              		  System.out.println("Insufficent quantity");
              		  break;
              	       }
            		  
            	  }
              }
              
              if(!found) {
               	  System.out.println("Not Found");
                 }
		}catch(Exception e) {
			System.out.println(e);
		}
		 
         
	}
	public void deleteProduct() {
		
		
		
	}
}
