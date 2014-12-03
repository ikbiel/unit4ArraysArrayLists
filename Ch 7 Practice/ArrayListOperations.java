import java.util.ArrayList;

public class ArrayListOperations
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<String>();
        System.out.println(names);
        System.out.println("\n");
        
        // adds names to ArrayList and prints
        names.add("Alice");
        names.add("Bob");
        names.add("Connie");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        System.out.println(names);
        System.out.println("\n");
        
        // retrieving first and last names
        System.out.println(names.get(0)); 
        System.out.println(names.get(names.size()-1));
        System.out.println("\n");
        
        // print size of arraylist
        System.out.println(names.size());
        System.out.println("\n");
        
        // set Alice to Alice B
        names.set(0, "Alice B");
        System.out.println(names);
        System.out.println("\n");
        
        // alternate form of add() to insert Doug after David
        names.add(4, "Doug");
        System.out.println(names);
        System.out.println("\n");
        
        // enhanced for loop to print out names
        for( String name: names )
        {
            System.out.println(name+" ");
        }
        System.out.println("\n");
        
        // create second arraylist - accepts arraylist as argument. pass names to constructor to build names2. print
        ArrayList<String> names2 = new ArrayList<String>(names);
        System.out.println(names2);
        System.out.println("\n");
        
        // remove index0 from names... should be removed from names, not names2
        names.remove(0);
        System.out.println(names);
        System.out.println(names2);
        System.out.println("\n");
        
        
        
        
    }
}
