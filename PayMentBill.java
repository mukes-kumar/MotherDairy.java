import java.text.SimpleDateFormat;
import java.util.*;

public class PayMentBill {
	private ArrayList<products> arryAdd = new ArrayList<>();

	// List<products1> arry1Add=new ArrayList<>();

	public void addProduct(products addPro) {
		arryAdd.add(addPro);
	}

	public void printProduct() {

		System.out.println("*************************I have product*****************");
		System.out.println("+=======+======================+=======+======|");
		System.out.println("| Id    |   Name               |price  |Quantity|  ");
		System.out.println("+=======+======================+=======+=====|");

		for (products product : arryAdd) {
			System.out.println("" + product);
		}

		System.out.println("+-----------+--------------+----------------+------------");

	}

	public void newAdd(products pro1) {
		arryAdd.add(pro1);
	}

	public void saleProduct() {
		Scanner sc=new Scanner(System.in);

//		List<products1> arry1Add=new ArrayList<>();
		int choice,id;
		double totalPrice,price,quantity;
		
		double discount=0.0;
		double subtotal=0.0;
		double sgst=0.0;
		double cgst=0.0;
		double overAllPrice=0.0;
		
		 do   
         {  
             // read input values  
             System.out.println("Enter the product details: ");  
             System.out.print("Product ID: ");  
              id = sc.nextInt();  
             System.out.print("Product Name: ");  
              String productName = sc.nextLine(); 
              
              boolean found=false;
              for()
             System.out.print("Quantity: ");  
              quantity = sc.nextInt();  
             System.out.print("Price (per unit): ");  
              price = sc.nextDouble();  
             //calculate total price for a particular product  
             totalPrice = price * quantity;  
             //calculates overall price  
              overAllPrice = overAllPrice + totalPrice;  
              
             //creates Product class object and add it to the List  
                products pro1=new products(id,productName, price,quantity);
              arryAdd.add( new products(id, productName, price, quantity) );  

              // ask for continue shopping?  
             newAdd(pro1);
             System.out.print("Want to add more items? (y or n): ");  
             //reads a character Y or N  
              choice = sc.next().charAt(0);  
             //read remaining characters, don't store (no use)  
             sc.nextLine();  
         }   
     while (choice == 'y' || choice == 'Y');  
     //display all product with its properties  
			System.out.println("*************************I have product*****************");
			System.out.println("+=======+======================+=======+======|");
			System.out.println("| Id    |   Name               |price  |Quantity|");
			System.out.println("+=======+======================+=======+=====|");
			
			for(products data:arryAdd) {
				System.out.println(""+data);
			}
			
			System.out.println("+-----------+--------------+----------------+------------");
			
			
		  //price calculation  
         System.out.println("\n\n\n\n\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);  
         //calculating discount  
         discount = overAllPrice*2/100;  
         System.out.println("\n\n\t\t\t\t\t\t\t\t    Discount (Rs.) " +discount);  
         //total amount after discount  
         subtotal = overAllPrice-discount;   
         System.out.println("\n\n\t\t\t\t\t\t\t\t          Subtotal "+subtotal);  
         //calculating tax  
         sgst=overAllPrice*12/100;  
         System.out.println("\n\n\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
         cgst=overAllPrice*12/100;  
         System.out.println("\n\n\t\t\t\t\t\t\t\t          CGST (%) "+cgst);  
         //calculating amount to be paid by buyer  
         System.out.println("\n\n\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal+cgst+sgst));  
         System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");  
         System.out.println("\t\t\t\t                     Visit Again");  
         // close Scanner  
         sc.close();  

	}

	public void searchProduct() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the product id to search");

		int serchProductId = sc.nextInt();

		System.out.println("Enter the product name");
		String serachProductName = sc.next();
		for (products product : arryAdd) {
			if (product.getProductId() == serchProductId && product.getProductName().equals(serachProductName)) {
				System.out.println("*************************I have product*****************");
				System.out.println("+=======+======================+=======+======|");
				System.out.println("| Id    |   Name               |price  |Quantity|  ");
				System.out.println("+=======+======================+=======+=====|");
				System.out.println(product);
				break;
			} else {
				System.out.println("Product is not available!!!");
			}

		}
		sc.close();
	}

	public static void main(String args[]) {

		// variables
		Scanner sc = new Scanner(System.in);

		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "Metro Mart MotherDairy Shop");
		System.out.println("\t\t\t\t\t3/98 Accurate Greater Noida");
		System.out.println("\t\t\t\t\t" + "    " + "Just frount of NIT  Walk");
		System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 7480082596");
		// format of date and time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// prints current date and time
		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t (+91) 6278180661");
		// sc.nextLine();
		System.out.print("Enter Customer Name: ");
		String customername = sc.nextLine();

		PayMentBill sms = new PayMentBill();

		while (true) {
			System.out.println("\nWelcome to MotherDairy\n");
			System.out.println("Press 1. For add the prduct");
			System.out.println("Press 2. For search the product ");
			System.out.println("Press 3. For sale the product");
			System.out.println("Press 4. For Show the product");
			System.out.println("Press 0. For Exit");
			System.out.print("\nEnter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					Scanner sc1 = new Scanner(System.in);

					System.out.print("Product ID's: ");
					int id = sc1.nextInt();

					sc1.nextLine();
					System.out.print("Product Name: ");
					String productName = sc1.nextLine();

					System.out.print("Unit Price(): ");
					double price = sc1.nextInt();

					System.out.print("Product Quantity: ");
					double quantity = sc1.nextInt();

					products addPro = new products(id, productName, price, quantity);
					sms.addProduct(addPro);

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

				case 0:
					System.out.println("Exiting the program");

					System.exit(0);
				default:
					System.out.println("Worng choice please Enter the choice!");
					break;

			}

		}
		// sc.close();

	}
}
