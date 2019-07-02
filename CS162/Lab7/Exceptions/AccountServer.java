
/**
 *AccountServer processes all requests that come from CustomerClient.
 *
 *@author Susan Rosiles and Manuel Larios
 *@version CS162 Lab #8, 11/11/2016
 */
public class AccountServer
{
    //field for balance.
    private int balance;

    /**
     * Constructor for objects of class AccountServer
     */
    public AccountServer()
    {
        //initialize the balance.
        balance = 0;
    }

    /**
     * Deposit attempt method.
     * @param int deposit amount
     * @throws a negative deposit amount.
     */
    public void depositAttempt(int depositAmt) throws IllegalArgumentException
    {
        if(depositAmt < 0) {
            throw new IllegalArgumentException("Attempted to deposit a negative " +
                "amount of " + depositAmt);
        }
        else {
            balance = balance + depositAmt;
        }
    }

    /**
     * Withraw amount method.
     * @param int withraw amount.
     * @throws a negative withdrawn amount.
     */
    public void withdrawAttempt(int withdrawAmt) throws InvalidWithdrawalException
    {
        if(withdrawAmt < 0) {
            throw new IllegalArgumentException("Attempted to withdraw a negative " +
                "amount of " + withdrawAmt);
        }
        else if(withdrawAmt > balance) {
            throw new InvalidWithdrawalException(withdrawAmt);
        }
        else {
            balance = balance - withdrawAmt;
        }
    }
}
