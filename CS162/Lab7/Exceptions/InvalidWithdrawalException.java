
/**
 *This is an InvalidWithrawalException class.
 * 
 * @author (Susan Rosiles and Manuel Larios) 
 * @version (CS162 Lab #8, 11/11/2016)
 */
public class InvalidWithdrawalException extends Exception
{
    /**
     * Constructor for objects of class InvalidWithrawlException
     * @param Attempted withdraw amount that caused the error
     */
    public InvalidWithdrawalException(int attemptedAmt)
    {
        super("Attempted withdraw amount (" + attemptedAmt +
        ") is larger than the current balance."); //message to InvalidWithrawalException.
    }
}
