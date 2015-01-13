/**
 * ArraySet represents an array implementation of a set. 
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/18/08
 */

package jss2;
import jss2.exceptions.*;
import java.util.*;

public class ArraySet<T> implements SetADT<T>, Iterable<T>
{
  private static Random rand = new Random();
  private final int DEFAULT_CAPACITY = 100;
  private final int NOT_FOUND = -1;
  private int count;  // the current number of elements in the set
  private T[] contents; 
  
  /**
   * Creates an empty set using the default capacity.
   */
  public ArraySet()
  {
    count = 0;
    contents = (T[])(new Object[DEFAULT_CAPACITY]);
  }
  
  /**
   * Creates an empty set using the specified capacity.
   * 
   * @param initialCapacity  the integer value for the initial size of this set
   */
  public ArraySet (int initialCapacity)
  {
    count = 0;
    contents = (T[])(new Object[initialCapacity]);
  }
  
  /**
   * Adds the specified element to this set if it is not already
   * present. Expands the capacity of the set array if necessary.
   *
   * @param element  the element to be added to this set
   */
  public void add (T element)
  {
    if (!(contains(element)))
    {
      if (size() == contents.length)
        expandCapacity();
      
      contents[count] = element;
      count++;
    }
  }
  
  /**
   * Adds the contents of the parameter to this set.
   *
   * @param set  the set that will have it's element added to the current set
   */
  public void addAll (SetADT<T> set)
  {
    Iterator<T> scan = set.iterator();
    
    while (scan.hasNext())
      add (scan.next());
  }
  
  /**
   * Removes and returns a random element from this set. Throws
   * an EmptySetException if the set is contains no elements.
   *
   * @return                    a random element from this set
   * @throws EmptySetException  if an empty set exception occurs
   */
  public T removeRandom() throws EmptySetException
  {
    if (isEmpty())
      throw new EmptySetException();
    
    int choice = rand.nextInt(count);
    
    T result = contents[choice];
    
    contents[choice] = contents[count-1];  // fill the gap
    contents[count-1] = null;
    count--;
    
    return result;
  }
  
  /**
   * Removes and returns the specified element from this set.
   * Throws an EmptySetException if the set is empty and a
   * NoSuchElementException if the target is not in the set.
   *
   * @param target                   the element to be removed from this list
   * @return                         the element removed from this set
   * @throws EmptySetException       if an empty set exception occurs
   * @throws NoSuchElementException  if a no such element exception occurs
   */
  public T remove (T target) throws EmptySetException,
                                      NoSuchElementException
  {
    int search = NOT_FOUND;
    
    if (isEmpty())
      throw new EmptySetException();
    
    for (int index=0; index < count && search == NOT_FOUND; index++)
      if (contents[index].equals(target))
        search = index;
    
    if (search == NOT_FOUND)
      throw new NoSuchElementException();
    
    T result = contents[search];
    
    contents[search] = contents[count-1];
    contents[count-1] = null;
    count--;
    
    return result;
  }
  
  /**
   * Returns a new set that is the union of this set and the
   * parameter.
   *
   * @param set  the set that is to be unioned with this set
   * @return     the union of the parameter set and this set
   */
  public SetADT<T> union (SetADT<T> set)
  {
    ArraySet<T> both = new ArraySet<T>();
    
    for (int index = 0; index < count; index++)
      both.add (contents[index]);
    
    Iterator<T> scan = set.iterator();
    while (scan.hasNext())
      both.add (scan.next());
    
    return both;
  }
  
  /**
   * Returns true if this set contains the specified target
   * element.
   *
   * @param target  the element that is sought in this set
   * @return        true if the element is contained in this set
   */
  public boolean contains (T target)
  {
    int search = NOT_FOUND;
    
    for (int index=0; index < count && search == NOT_FOUND; index++)
      if (contents[index].equals(target))
        search = index;
    
    return (search != NOT_FOUND);
  }
  
  /**
   * Returns true if this set contains exactly the same elements
   * as the parameter.
   * 
   * @param set  the set that is to be examined
   * @return     true if this set and the parameter set contains exactly the
   *             same elements
   */
  public boolean equals (SetADT<T> set)
  {
    boolean result = false;
    ArraySet<T> temp1 = new ArraySet<T>();
    ArraySet<T> temp2 = new ArraySet<T>();
    T obj;
    
    if (size() == set.size())
    {
      temp1.addAll(this);
      temp2.addAll(set);
      
      Iterator<T> scan = set.iterator();
      
      while (scan.hasNext())
      {
        obj = scan.next();   
        if (temp1.contains(obj))
        {
          temp1.remove(obj);
          temp2.remove(obj);
        }
      }
      
      result = (temp1.isEmpty() && temp2.isEmpty());
    }
    
    return result;
  }
  
  /**
   * Returns true if this set is empty and false otherwise.
   *
   * @return  true if this set is empty
   */
  public boolean isEmpty()
  {
    return (count == 0);
  }
  
  /**
   * Returns the number of elements currently in this set.
   *
   * @return  the integer representation of the size of this set
   */
  public int size()
  {
    return count;
  }
  
  /**
   * Returns an iterator for the elements currently in this set.
   *
   * @return  a new iterator over the elements in this set
   */
  public Iterator<T> iterator()
  {
    return new ArrayIterator<T> (contents, count);
  }
  
  /**
   * Returns a string representation of this set.
   *
   * @return  a string representation of this set
   */
  public String toString()
  {
    String result = "";
    
    for (int index=0; index < count; index++) 
      result = result + contents[index].toString() + "\n";
    
    return result;
  }
  
  /**
   * Creates a new array to store the contents of the set with
   * twice the capacity of the old one.
   */
  private void expandCapacity()
  {
    T[] larger = (T[])(new Object[contents.length*2]);
    
    for (int index=0; index < contents.length; index++)
      larger[index] = contents[index];
    
    contents = larger;
  }
}
