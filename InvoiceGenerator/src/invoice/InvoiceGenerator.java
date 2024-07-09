package invoice;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceGenerator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("INVOICE FOR YOUR PRODUCT!");

    // TAKING THE USER INPUT 
    System.out.print("Enter invoice number: ");
    int invoiceno = scanner.nextInt();
    System.out.print("Enter the date : ");
    String Date=scanner.next();
    System.out.println("ENTER THE NAME :");
    String BName=scanner.next();
    System.out.println("ENTER THE ADDRESS :");
    String BAddress=scanner.next();
    System.out.println("ENTER THE COUNTRY :");
    String SName=scanner.next();
    System.out.println("ENTER THE ADDRESS TO SHIP : ");
    String SAddress=scanner.next();
    

    // ARRAY  ITEMS 
    ArrayList<Item> items = new ArrayList<>();
    while (true) {
      System.out.print("Enter the description about the item(optional) :");
      String itemDescription = scanner.next();
      if (itemDescription.equalsIgnoreCase("NOTHING")) {
        break;
      }
//      else if(itemDescription.equalsIgnoreCase(" ")) {
//    	  break;
//      }
      System.out.println("ENTER THE QUANTITY : ");
      int quant=scanner.nextInt();
      System.out.println("ENTER ANY SECONDARY ADDRESS TO DELIVER THE ITEM (OPTIONAL)");
      String secadd=scanner.next();
      System.out.println("ENTER UNIT PRICE" );
      double unitprice=scanner.nextDouble();
      
      
      items.add(new Item(itemDescription,quant,secadd,unitprice));
      }

    // INVOICE GENERATOR
    Invoice invoice = new Invoice(invoiceno, Date, BName, BAddress, SName, SAddress, items);
    System.out.println("Invoice Generated:");
    System.out.println(invoice.toString());
  }
}

class Item {
	private String description;
	private int quantity;
	private String secadd;
	private double unitprice;

  public Item(String description, int quantity, String secadd,double unitprice) {
    this.description = description;
    this.quantity = quantity;
    this.secadd = secadd;
    this.unitprice=unitprice;
  }

  public double getTotal() {
    return quantity * unitprice;
  }

  public String toString() {
    return description + " x " + quantity + " = " + getTotal();
  }
  
}

class Invoice {
  private int invoiceno;
  private String Date;
  private String BName;
  private String BAddress;
  private String SName;
  private String SAddress;
  private ArrayList<Item> items;

  public Invoice(int invoiceno, String Date, String BName , String BAddress, String SName, String SAddress, ArrayList<Item> items) {
    this.invoiceno = invoiceno;
    this.Date = Date;
    this.BName = BName;
    this.BAddress = BAddress;
    this.SName = SName;
    this.SAddress = SAddress;
    this.items = items;
   
  }

  public double getTotal() {
    double total = 0;
    for (Item item : items) {
      total += item.getTotal();
    }
    return total;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Invoice #").append(invoiceno).append("\n");
    sb.append("Date: ").append(Date).append("\n");
   
	sb.append("NAME ON BILL: ").append(BName).append("\n");
    sb.append("ADDRESS ON BILL: ").append(BAddress).append("\n");
    sb.append("SHIP TO: ").append(SName).append("\n");
    sb.append("Address: ").append(SAddress).append("\n");
    sb.append("ITEMS WITH DESCRIPTION:\n");
//    sb.append("SECONDARY ADDRES").append(secadd)
    for (Item item : items) {
      sb.append("  ").append(item.toString()).append("\n");
    }
    sb.append("Total: ").append(getTotal()).append("\n");
    System.out.println("THANKS FOR SHOPPING ");
    return sb.toString();
   
  }
  
}
