

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerClientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerClientTest
{
    /**
     * Default constructor for test class CustomerClientTest
     */
    public CustomerClientTest()
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
    public void depositAmtTest()
    {
        CustomerClient customer1 = new CustomerClient();
        customer1.customerDeposit(50);
        
    }

    @Test
    public void withrawAmtTest()
    {
        CustomerClient customer1 = new CustomerClient();
        customer1.customerWithdrawal(50);
    }
}


