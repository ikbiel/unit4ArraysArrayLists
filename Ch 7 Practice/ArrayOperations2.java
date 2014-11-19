
public class ArrayOperations2
{
    private int[] values;
    
    public ArrayOperations2(int[] initialValues)
    {
        this.values = initialValues;
    }

    public void swafFirstAndLast(int index1, int index2)
    {
        int tempValue = this.values[index1];
        this.values[index1] = this.values[index2];
        this.values[index2] = tempValue;
    }
    
    public void shiftRight()
    {
        this.values[0] = this.values[values.length - 1];
        for( int i = 1; i <= values.length-1; i++ ) 
        {
            this.values[i] = this.values[i+1];
        }
    }
    
    public void replaceEvensWithZero()
    {
        for( int i = 0; i <= values.length-1; i+=2 )
        {
            this.values[i] = 0;
        }
    }
    
    public void replaceWithLargerNeighbor()
    {
        for (int i = 1; i < values.length-1; i++)
        {
            int leftN = this.values[i-1];
            int rightN = this.values[i+1];
            if( leftN > rightN )
            {
                this.values[i] = this.values[i-1];
            }
            else
            {
                this.values[i] = this.values[i+1];
            }
        }
    }
    
    public void removeMiddle()
    {
       boolean isOdd = false;
       int[] newValues = new int[values.length];
       
       if( values.length%2 != 0 )
       {
           isOdd = true;
       }
       
       if( isOdd == false )
       {
          int mid1 = values.length/2;
          int mid2 = mid1+1;
          
          for( int i = 0; i < this.values.length; i++ )
          {
              if( i != mid1 && i!= mid2)
              {
                  newValues[i] = this.values[i];
                }
          }
       }
       else
       {
           int middle = (values.length-1)/2;
           for( int i = 0; i < this.values.length; i++ )
          {
              if( i != middle)
              {
                  newValues[i] = this.values[i];
                }
          }
           
       }
    }
    
    public void evenInFront()
    {
        
    }

}
