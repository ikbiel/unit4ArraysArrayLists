import java.util.ArrayList;
import java.util.Scanner;


public class Store
{
    public Store()
    {
       ArrayList<String> customers = new ArrayList<String>();
       ArrayList<Double> prices = new ArrayList<Double>(); 
       Scanner s = new Scanner(System.in);
    }

    public void addSale(String cutomerName, double amount)
    {
       System.out.println("Enter the customer's name: ");
       customerName = s.next();
       customers.add(customerName);
       
       
    }
    
    public String nameOfBestCustomer()
    {
        
    }
    
    public static void main(String[] args)
    {
        
    }

}
