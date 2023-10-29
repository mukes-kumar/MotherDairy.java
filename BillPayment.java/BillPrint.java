
import java.util.*;

public class BillPrint {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the items details to get Bill ");
		System.out.println("==============================================");
		System.out.println("Enter the items Name");
		String name = sc.nextLine();
		System.out.println("Enter the item code");
		int code = sc.nextInt();

		System.out.println("Enter Unite price of the item");
		int price = sc.nextInt();

		System.out.println("Enter the Quantity of the items");
		int quntity = sc.nextInt();

		double total_amount = quntity * price;
		int Dis = 20;
		// int per=100-20;
		double discount = ((total_amount * 20) / 100);
		double disc = (total_amount - discount);

		// double oneunitpercentage=total_amount/per;
		// double totaleDis=Dis*oneunitpercentage;
		// double Discount=total_amount-totaleDis;

		System.out.println("           payment Details               ");
		System.out.println("===========================================");
		System.out.println("Item Code          ::::" + code);
		System.out.println("Item Name          ::::" + name);

		System.out.println("===========================================");
		System.out.println("Unit Price in RS.  ::::" + price);
		System.out.println("Quantity Taken     ::::" + quntity);
		System.out.println("===========================================");
		System.out.println("Total Amount in    ::::" + total_amount);
		System.out.println("Discount Amount    ::::" + Dis + "%");
		System.out.println("===========================================");
		System.out.println("After Discount Amount is ::::" + discount);
		System.out.println("===========================================");
		System.out.println("Net Payble Amount is :::: " + disc);
		sc.close();

	}
}
