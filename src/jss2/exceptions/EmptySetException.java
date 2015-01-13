/**
 * EmptySetException represents the situation in which a set is empty.
 *
 * @author Dr. Chase
 * @author Dr. Lewis
 * @version 1.0, 8/18/08
 */

package jss2.exceptions;

public class EmptySetException extends RuntimeException
{
  /**
   * Creates the exception.
   */
  public EmptySetException()
  {
    super ("The set is empty.");
  }
  
  /**
   * Creates the exception with the specified message.
   *
   * @param message  a string representation of a message for the exception
   */
  public EmptySetException (String message)
  {
    super (message);
  }
}
