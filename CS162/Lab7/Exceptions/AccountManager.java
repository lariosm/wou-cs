
/**
 *AccountManager class will create five instances to check if the program works right.
 *
 *@author Susan Rosiles and Manuel Larios
 *@version CS162 Lab #8, 11/11/2016
 */
public class AccountManager
{
    /**
     * Calling the main method.
     */
    public static void main(String[] args)
    {
        CustomerClient c1 = new CustomerClient(50, 75);
        CustomerClient c2 = new CustomerClient(25, 20);
        CustomerClient c3 = new CustomerClient(-10, 15);
        CustomerClient c4 = new CustomerClient(50, -75);
    }
}
