import java.util.ArrayList;
import java.util.Scanner;


public class Store
{
    private ArrayList<String> customers;
    private ArrayList<Double> prices;
    public Scanner s;
    
    
    public Store()
    {
       customers = new ArrayList<String>();
       prices = new ArrayList<Double>(); 
       s = new Scanner(System.in);
       
       
    }

    public void addSale(String customerName, double amount)
    {
       
           customers.add(customerName);
       
           prices.add(amount);

       
    }
    
    public String nameOfBestCustomer()
    {
        int max = 0;
        String bestCustomer = "";
        for( int i = 0; i < customers.size(); i++ )
        {
            if( prices.get(i) > max )
            {
                bestCustomer = customers.get(i);
            }
        }
        
        return bestCustomer;
        
    }
    
    public static void main(String[] args)
    {
        Store myStore = new Store();
        
        System.out.println("Enter the customer's name (enter 'q' if no more customers): ");
        customerName = s.next();
        while( s.hasNext() )
        {
           if( customerName == "q" )
           {
               break;
           }
       
           System.out.println("Enter the customer's price : ");
           amount = s.nextDouble();
        }
        
        
        
         System.out.print(myStore.addSale());
         System.out.println(myStore.nameOfBestCustomer());
        }
    } 


        
