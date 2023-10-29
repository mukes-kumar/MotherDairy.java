
import java.util.*;

public class MarksheetPrint {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("********Enter the Student details to get marksheet********");
        System.out.println("\n");
        System.out.println("Enter the Registration number");
        int reg = sc.nextInt();

        System.out.println("Enter the obtained marks in PHY::");
        int phy = sc.nextInt();

        System.out.println("Enter the obtained marks in CHE::");
        int che = sc.nextInt();

        System.out.println("Enter the obtained marks in MATHS::");
        int math = sc.nextInt();

        int totale = phy + che + math;

        double percentage = totale / 3;

        System.out.println("=======================================================================");
        System.out.println("                <=Registration No.=>" + reg + "                           ");
        System.out.println("=======================================================================");

        System.out.println("Marks Obtained in PHY  :::" + phy);
        System.out.println("Marks Obtained in CHE  :::" + che);
        System.out.println("Marks Obtained in MATH :::" + math);
        System.out.println("========================================================================");
        System.out.println("Total Marks Obtained   :::" + totale);
        System.out.println("========================================================================");
        System.out.println("Aggregate              :::" + percentage + "%");
        System.out.println("=========================================================================");

    }
}
