

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RadarTest
{
    /**
     * Default constructor for test class RadarTest
     */
    public RadarTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testRadar()
    {
        
        MyRadarLab2 testMonster1 = new MyRadarLab2(100, 100, 1, 4, 3, 5);
        for(int i = 0; i < 51; i++)
        {
            testMonster1.scan();
        }
        int[] values1 = testMonster1.getMonsterVelocity();
        assertEquals(values1[0], 1);
        assertEquals(values1[1], 4);
        
        
        MyRadarLab2 testMonster2 = new MyRadarLab2(100, 100, -2, -4, 90, 95);
        for(int i = 0; i < 51; i++)
        {
            testMonster2.scan();
        }
        int[] values2 = testMonster2.getMonsterVelocity();
        assertEquals(values2[0], -2);
        assertEquals(values2[1], -4);

        
    }
    
   
    
    
        
    
    
}
