
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
        int last = values.length - 1;
        int temp = values[last];
        
        for( int i = last; i > 0; i--)
        {
            values[i] = values[i-1];
        }
        
        values[0] = temp;
        
            //        
            //         this.values[0] = this.values[values.length - 1];
            //         for( int i = 1; i <= values.length-1; i++ ) 
            //         {
            //             this.values[i] = this.values[i+1];
            //         }
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
            //        int[] tempArray = new int[values.length];
            //        tempArray[0] = values[0];
            //        tempArray[tempArray.length-1] = values[values.length-1];
            //        
            //        // start loop at one, and stop before end
            //        for( int i = 1; i < values.length - 1; i++)
            //        {
            //            if (values[i-1] > values[i+1])
            //            {
            //                tempArray[i] = values[i-1];
            //             }
            //             else
            //             {
            //                 tempArray[i] = values[i+1];
            //             }
            //         }
       
        
        
        
        
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
       int[] newValues = new int[values.length];
       int newI = 0;
       int minimum = this.values[0];
       int indexOfMin = 0;
       
       for( int x = 0; x < this.values.length; x++ )
       {
           if( values[x] < minimum)
           {
               minimum = values[x];
               indexOfMin = x;
           }
       }
        
       for( int i = 0; i < this.values.length; i++ )
       {
           if( (values[i] % 2) == 0 && values[i] < values[indexOfMin] )
           {
               newValues[newI] = this.values[i];
               i = indexOfMin;
           }
           newI++;
       }
    }
    
    public int secondLargest()
    {
        int max = this.values[0];
        int indexMax = 0;
        int secMax = max;
        
        for( int i = 0; i < this.values.length; i++ )
        {
            if( values[i] > max )
            {
                max = values[i];
                indexMax = i;
            }
        }
        
        for( int x = 0; x < this.values.length; x++ )
        {
            if (max < x)
            {
                secMax = max;
                max = x;
            }
        }
        
        return secMax;
    }
    
    public boolean isInOrder()
    {
        boolean inOrder = true;
        for( int i = 0; i < this.values.length; i++ )
        {
            if (values[i] > values[i+1])
            {
                inOrder = false;
            }
        }
        
        return inOrder;
    }
    
    public boolean adjacentDuplicates()
    {
        boolean adjacent_dubs = false;
        int prevValue = 0;
        for( int i = 1; i < this.values.length; i++ )
        {
           if (this.values[i] == values[prevValue])
           {
               adjacent_dubs = true;
            }
            prevValue++;
        }
        
        return adjacent_dubs;
    }
    
    public boolean duplicates()
    {
        boolean hasDubs = false;
        for( int i = 0; i < this.values.length; i++ )
        {
            for( int x = 1; x < this.values.length; x++)
            {
                if (this.values[x] == this.values[i])
                {
                    hasDubs = true;
                }
            }
        }
        
        return hasDubs;
    }
}
