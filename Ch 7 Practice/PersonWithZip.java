import java.util.Scanner;
/**
 * Write a description of class PersonWithZip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonWithZip
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private int zipCode;

    /**
     * Constructor for objects of class PersonWithZip
     */
    public PersonWithZip(String first, String last, int zip)
    {
       firstName = first;
       lastName = last;
       zipCode = zip;
    }

    public int getZip()
    {
        return zipCode;
    }
    
    public String toString()
    {
        String str = "";
        str += "Name: " + firstName + " " + lastName;
        str += "\n Zip Code: " + zipCode;
        
        return str;
    }
    
    public static void main(String[] args)
    {
        PersonWithZip[] arrayZips = new PersonWithZip[3];
        Scanner s = new Scanner(System.in);
        String first;
        String last;
        int zip;
       
        for( int i = 0; i < arrayZips.length; i++ )
        {
            System.out.println("Enter first name, last name, and zip code for person number " + (i+1) + " with fields separated by a space");
            first = s.next();
            last = s.next();
            zip = s.nextInt();
            PersonWithZip person = new PersonWithZip(first, last, zip);
            person = arrayZips[i];
        }
        System.out.println(arrayZips);
        
        for( PersonWithZip p : arrayZips )
        {
            System.out.println(arrayZips[p].toString());
        }
        
        System.out.print("The following person has the least numbered zip code: ");
        int minZip = arrayZips[0].getZip();
        int indexOfMin = 0;

        for( int i = 1; i < arrayZips.length; i++ )
        {

            if(arrayZips[i].getZip() > minZip)
            {
                minZip = arrayZips[i].getZip();
                indexOfMin = i;
            }
        }
        
        System.out.println(arrayZips[indexOfMin]);
    }
}
