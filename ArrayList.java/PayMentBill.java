
import java.text.SimpleDateFormat;
import java.util.*;

class products {

	private int id;
	private String productName;
	double price;
	double quantity;

	public products(int id, String productName, double price, double quantity) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public double getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("| %-4d  | %-20s | %-4d | %-4d |", id, productName, price, quantity);
	}

}

public class PayMentBill {
	private ArrayList<products> arryAdd = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	// private String productName;

	public void addProduct(products addPro) {
		arryAdd.add(addPro);
	}

	public void printProduct() {
		System.out.println("*************I have product***********");
		System.out.println("+=======+========+=======+======|");
		System.out.println("| Id    |   Name |price |Quantity|");
		System.out.println("+=======+========+=======+======|");

		for (products data : arryAdd) {
			System.out.println(data.getProductId() + "\t|" + data.getProductName() + "\t|" + data.getPrice() + "\t|"
					+ data.getQuantity() + "\t|");
		}

		System.out.println("+------+------+-------+-------");

	}

	public void saleProduct() {

		System.out.println("Enter the product details: ");
		System.out.print("Product ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		System.out.print("Product Name: ");
		String productName = sc.nextLine();
		double ta = 0, gsta = 0, fa = 0, d = 0;
		int sq = 0;
		boolean found = false;

		for (products p : arryAdd) {
			found = true;
			if (p.getProductId() == id || p.getProductName() == productName) {

				System.out.println("Welcome to motherDairy");

				System.out.println("******************I have product***********");
				System.out.println("+=======+=========+=======+");
				System.out.println("| Id    |   Name  |price  |");
				System.out.println("+=======+=========+=======+");

				System.out.println("|" + p.getProductId() + "\t|" + p.getProductName() + "\t|" + p.getPrice() + "|");
				System.out.println("+=======+=========+=======+");

				System.out.println("Enter the quantity");
				sq = sc.nextInt();
				if (sq <= p.getQuantity()) {
					d = p.getPrice();
					ta = d * sq;
					gsta = ta * 0.18;
					fa = ta + gsta;
					p.quantity -= sq;
					System.out.println("******************I have product***********");
					System.out.println("+=======+=========+=======+======  |");
					System.out.println("| Id    |   Name  |price  |Quantity|");
					System.out.println("+=======+=========+=======+========|");

					System.out.println("|" + id + "\t|" + productName + "\t\t|" + d + "\t|" + sq + "\t|");
					System.out.println("+=======+=========+=======+========|");

					System.out.println("\n\n\t\t\t\t\t\tTotal Amount (Rs.) " + ta);

					System.out.println("\n\n\t\t\t\t\t\tTotal GST (Rs.) " + gsta);
					System.out.println("\n\n\t\t\t\t\t\tTotal PeyaBale  " + fa);
					System.out.println("");
					System.out.println("\t\t\t\t---------------Thank You for Shopping!!-----------------");
					System.out.println("\t\t\t\t                     Visit Again");
					break;
				} else {
					System.out.println("Insufficent quantity");
					break;
				}
			}
		}
		if (!found) {
			System.out.println("Not Found");
		}

	}

	public void searchProduct() {

		System.out.println("Enter the product id to search");

		int serchProductId = sc.nextInt();

		System.out.println("Enter the product name");
		String serachProductName = sc.next();
		for (products product : arryAdd) {
			if (product.getProductId() == serchProductId && product.getProductName().equals(serachProductName)) {
				System.out.println("*************************I have product*****************");
				System.out.println("+=======+=======+=======+======|");
				System.out.println("| Id    |Name   |price  |Quantity|  ");
				System.out.println("+=======+=======+=======+=====|");
				System.out.println("|" + product.getProductId() + "\t|" + product.getProductName() + "\t|"
						+ product.getPrice() + "\t|" + product.getQuantity() + "\t|");
				System.out.println("+=======+=======+=======+=======+");
			} else if (product.getProductId() != serchProductId && product.getProductName().equals(serachProductName)) {

				System.out.println("Product is not availiable!!!");
			}

		}
	}

	public static void main(String args[]) {

		// variables
		Scanner sc = new Scanner(System.in);

		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "Metro Mart MotherDairy Shop");
		System.out.println("\t\t\t\t\t3/98 Accurate Greater Noida");
		System.out.println("\t\t\t\t\t" + "    " + "Just front of NIT college Walk");
		System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 7480082596");
		// format of date and time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// prints current date and time
		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t (+91) 6278180661");
		System.out.print("Enter Customer Name: ");
		String customername = sc.nextLine();
		int id;
		String productName;
		int quantity;
		int price;

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

					System.out.print("Product ID's: ");
					id = sc.nextInt();

					sc.nextLine();
					System.out.print("Product Name: ");
					productName = sc.nextLine();

					System.out.print("Unit Price(): ");
					price = sc.nextInt();

					System.out.print("Product Quantity: ");

					quantity = sc.nextInt();

					products addPro = new products(id, productName, price, quantity);
					//
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
					sc.close();
					System.exit(0);
				default:
					System.out.println("Worng choice please Enter the choice!");
					break;

			}

		}
		// sc.close();

	}
}
