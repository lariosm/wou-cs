
/**
 *CustomerClient takes user input and sends all requests to AccountServer.
 * 
 *@author Susan Rosiles and Manuel Larios 
 *@version CS162 Lab #8, 11/11/2016
 */
public class CustomerClient
{
    // field for the account server.
    private AccountServer server;

    /**
     * Default constructor
     */
    public CustomerClient()
    {
        server = new AccountServer();
    }
    
    /**
     * Constructor for objects of class CustomerClient
     * @param The amount we want to deposit
     * @param the amount we want to withdraw
     */
    public CustomerClient(int deposit, int withdraw)
    {
        server = new AccountServer();//initialize account server.
        //initialize deposit and withdraw parameters for constructor.
        customerDeposit(deposit); 
        customerWithdrawal(withdraw);
    }

    /**
     * Customer deposit method.
     * @param int amount to deposit.
     */
    public void customerDeposit(int amtToDeposit)
    {
        server.depositAttempt(amtToDeposit);
    }
    
    /**
     * Customer Withdrawal method.
     * @param int amount to withdraw.
     */
    public void customerWithdrawal(int amtToWithdraw)
    {
        try {
            server.withdrawAttempt(amtToWithdraw);
        }
        catch(InvalidWithdrawalException e){
            System.out.println("InvalidWithdrawalException caught");
        }
    }
}
