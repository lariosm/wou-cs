

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TransporterRoomTest.
 *
 * @author  Manuel Larios
 * @version CS162 Lab #3, 10/17/2016
 */
public class TransporterRoomTest
{
    private TransporterRoom transpor1;

    /**
     * Default constructor for test class TransporterRoomTest
     */
    public TransporterRoomTest()
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
        transpor1 = new TransporterRoom("Some strange place");
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

    /**
     * Makes sure that we don't teleport to an "empty" room.
     */
    @Test
    public void testGetExit()
    {
        assertNotNull(transpor1.getExit(null));
    }
}


