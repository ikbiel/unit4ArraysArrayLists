import java.util.Scanner;

/**
 * Write a description of class Review here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Review
{
   public static void main(String[] args)
   {
       // do while loop
       
       Scanner s = new Scanner(System.in);
       int value;
       
       do
       {
           System.out.print("Enter a positive number or -1 to quit: ");
           value = s.nextInt();
       }
       while(value != -1);
       
       // enhanced for loops
       
       int[] array = { 3, 5, 7, 9 };
       
       for (int value1 : array)
       {
           System.out.println(value1);
           ///!!! cannot change values stored in intArray
       }
       
       // switch statements
       
       int switchValue = 7;
       
       switch( switchValue )
       {
           case 1:
           {
               System.out.println( "value is 1" );
               break;
           }
           
           case 3:
           {
               System.out.println( "value is 3" );
               break;
           }
           
           default:
           {
               System.out.println( "value is something else" );
               break;
           }
       }
       
       // remove element from growable array
       
       int[] growableArray = {1, 3, 5, 7, 9};
       int growableArraySize = 5;
       
       // remove element at index 2
       for( int index = 2; index < growableArraySize - 1; index++ )
       {
           growableArray[index] = growableArray[index+1];
       }
       
       growableArraySize--;
       
       // remove element at index 2 and copy into new smaller array
       int indexToRemove = 2;
       int[] smallerArray = new int[growableArray.length-1];
       for( int index = 0; index < indexToRemove; index++ )
       {
           smallerArray[index] = growableArray[index];
        }
        
       for( int index = indexToRemove + 1; index < growableArray.length; index++ )
       {
           smallerArray[index-1] = growableArray[index];
        }
        
       // promotion
       
       int x = 7;
       double y = 5.5;
       
       //this is an example of automatic type promotion (automatic casting to a more precise type)
       
       // x is a promotion to a double and then added to y
       y = y + x;
       
       // won't compile since y will not be automatically demoted to an int
       // x = x + y;
       
       // we have to explicitly cast
       x = x + (int)y;
       
       
       // escape sequences
       
       System.out.println( " tab: \t; return: \n; double quote: \"; backslash: \\" );
       
       
       // short circuiting
       // when the condition must be true or false and there is no point continuing to evaluate it
       
   }

}
