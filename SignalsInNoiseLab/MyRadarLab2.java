import java.util.Scanner;

/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class MyRadarLab2
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;
    
    // change in velocity
    private int dx;
    private int dy;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     * @param   dx      the change in x for velocity of the monster
     * @param   dy      the change in y for velocity of the monster
     * @param monsterRow the beginning row of the monster on the grid
     * @param monsterCol the beginning column of the monster on the grid
     */
    public MyRadarLab2(int rows, int cols, int dxVal, int dyVal, int monsterRow, int monsterCol )
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        accumulator = new int[11][11]; // elements will be set to 0
        
        // sets monster current location based on user input
        monsterLocationRow = monsterRow;
        monsterLocationCol = monsterCol;
        
        // sets dx and dy values based on user input
        dx = dxVal;
        dy = dyVal;
        
        noiseFraction = 0.05;
        numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     * 
     */
    public void scan()
    {
        // copy currentScan into prevScan
        boolean[][] prevScan = new boolean[currentScan.length][currentScan[0].length];
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                prevScan[row][col] = currentScan[row][col];
            }
        }
        
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        // update monster current location based on dx and dy values
        monsterLocationRow += dy;
        monsterLocationCol += dx;
        if( monsterLocationRow < currentScan[0].length &&
            monsterLocationCol < currentScan.length &&
            monsterLocationRow >= 0 &&
            monsterLocationCol >= 0 )
            {
                currentScan[monsterLocationRow][monsterLocationCol] = true;
            }
        
        
        // inject noise into the grid
        injectNoise();
        
        // udpate the accumulator
        // check for monster in prevScan
        for(int row = 0; row < prevScan.length; row++)
        {
            for(int col = 0; col < prevScan[0].length; col++)
            {
                if(prevScan[row][col] == true)
                {
                    // check monster in currScan
                   for(int currRow = 0; currRow < currentScan.length; currRow++)
                   {
                       for(int currCol = 0; currCol < currentScan[0].length; currCol++)
                       {
                               if(currentScan[currRow][currCol] == true)
                              {
                                  // calculate dx and dy candidates
                                  int dyCand = currRow - row;
                                  int dxCand = currCol - col;
                                  
                                  if(dxCand <= 5 && dxCand >= -5
                                      && dyCand <= 5 && dyCand >= -5)
                                  {
                                       accumulator[dyCand+5][dxCand+5]++;
                                  }
                              }
                       }
                   }
                }
            }
        }

        // keep track of the total number of scans
        numScans++;

    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
    /**
     * Finds monster velocity based on highest accumulated value of dx and dy candidates
     * 
     * @return the velocity of the monster based on dx and dy values
     */
    public int[] getMonsterVelocity()
    {
        int maxAccum = 0;
        int xMax = 0;
        int yMax = 0;
        
        // iterate through accumulator to find max accumulation, aka the velocity
        for(int row = 0; row < accumulator.length; row++)
        {
            for(int col = 0; col < accumulator[0].length; col++)
            {
                if(accumulator[row][col] > maxAccum)
                {
                    maxAccum = accumulator[row][col];
                    // subtract 5 from max values
                    //    since value is no longer part of array, value needs to be changed back
                    //    to normal (without indexing)
                    xMax = col-5;
                    yMax = row-5;
                    
                }
            }
        }
        int[] velocity = {xMax, yMax};
        return velocity;
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        // user input determine's monster's current location and dx/dy
        System.out.print("Enter the monster's current row and column (separated by spaces): ");
        int row = s.nextInt();
        int col = s.nextInt();
        System.out.print("Enter the monster's dx and dy (separated by spaces): ");
        int dx = s.nextInt();
        int dy = s.nextInt();
        
        // create radar object; call scan and getMonsterVelocity methods
        MyRadarLab2 monster1 = new MyRadarLab2(100, 100, dx, dy, row, col);
        for( int i = 0; i < 51; i++ )
        {
            monster1.scan();
        }
        
        int[] answer = monster1.getMonsterVelocity();
        System.out.println("The monster's velocity is: DX = " + answer[0] + " DY = " + answer[1]);
        
        
    }
    
}
