/**
 * ElementNotFoundException represents the situation in which a target element 
 * is not present in a collection
 *
 * @author Dr. Chase
 * @author Dr. Lewis
 * @version 1.0, 8/18/08
 */

package jss2.exceptions;

public class ElementNotFoundException extends RuntimeException
{
  /**
   * Sets up this exception with an appropriate message.
   *
   * @param collection  a string representation of a message for the exception
   */
  public ElementNotFoundException (String collection)
  {
    super ("The target element is not in this " + collection);
  }
}
