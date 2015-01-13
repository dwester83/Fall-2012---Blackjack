/**
 * ArrayIterator represents an iterator over the elements of an array.
 *
 * @author Dr. Chase
 * @author Dr. Lewis
 * @version 1.0, 8/18/08
 */

package jss2;
import java.util.*;

public class ArrayIterator<T> implements Iterator<T>
{
  private int count;    // the number of elements in the collection
  private int current;  // the current position in the iteration
  private T[] items;
  
  /**
   * Sets up this iterator using the specified items.
   *
   * @param collection  the collection the iterator is for
   * @param size        the number of items in the collection
   */
  public ArrayIterator (T[] collection, int size)
  {
    items = collection;
    count = size;
    current = 0;
  }
  
  /**
   * Returns true if this iterator has at least one more element
   * to deliver in the iteration.
   *
   * @return  true if this iterator has at least one more element
   */
  public boolean hasNext()
  {
    return (current < count);
  }
  
  /**
   * Returns the next element in the iteration. If there are no
   * more elements in this iteration, a NoSuchElementException is
   * thrown.
   *
   * @return  the next element in the iteration
   * @throws NoSuchElementException  if a no such element exception occurs
   */
  public T next() throws NoSuchElementException
  {
    if (! hasNext())
      throw new NoSuchElementException();
    
    current++;
    
    return items[current - 1];
  }
  
  /**
   * The remove operation is not supported in this collection.
   *
   * @throws UnsupportedOperationException  if an unsupported operation
   *                                        exception occurs
   */
  public void remove() throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }
}
