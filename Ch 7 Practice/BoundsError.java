
public class BoundsError
{
    public static void main(String[] args)
    {
        int[] scores = new int[10];
        
        for( int i = 0; i < scores.length; i++ )
        {
            // puts numbers in backwards
            scores[scores.length-i-1] = i+1;
        }
    }

}