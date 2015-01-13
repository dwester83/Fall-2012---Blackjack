/**
 * Daniel Wester, Brian Hanson,  Chris Sadler
 * 
 * Added a method to reset the hand instead of making a new hand. 
 */

/**
 * Hand provides an implementation of a hand of cards using a 
 * set to represent the cards.
 *
 * @author Dr. Chase
 * @author Dr. Lewis
 * @version 1.0, 8/16/08
 */

import jss2.*;
import jss2.exceptions.*;
import java.util.*;

public class Hand implements Iterable
{
  protected ArraySet<Card> inHand;
  protected int handValue,count;
  
  /**
   * Constructs a hand of Cards.
   */
  public Hand()
  {
    reset();
  }
	
	
  /**
   * Resets the hand of cards.
   */
  public void reset(){
	inHand = new ArraySet<Card>(12);
	handValue=0;
	count =0;
  }
  
  /**
   * Reduces hand value when newCard makes player go over 
   * 21 and there is an ace in the hand.
   *
   * @param newCard  a new card to be added to this hand
   */
  private void reduceHand(Card newCard)
  {
    if((handValue) > 21)
    {
      if(aceInHand())
        handValue -= 10;
    }
  }
  
  /**
   * Checks to see if there is an ace in this hand.
   *
   * @return  true if this hand contains an ace
   */
  private boolean aceInHand()
  {
    boolean result = false;
    Card cardChk = null;
    Iterator<Card> scan = inHand.iterator();

    while (scan.hasNext() && !result)
    {
      cardChk = scan.next();
      if(cardChk.getValue() == 11)
      {
        cardChk.setValue(1);
        result = true;
      }
    }
    
    return result;
  }
  
  /**
   * Adds a new card from the specified deck to this hand.
   *
   * @param currentDeck  the deck to which a new card is to be added
   * @return             the card which is to be added to the deck
   */
  public Card newCard(Deck currentDeck)
  {
    Card result;
    
    result = currentDeck.getCard();
    inHand.add(result);
    handValue+=result.getValue();
    reduceHand(result);
    count++;
    
    return result;
  }
  
  /**
   * Returns the value of this hand.
   *
   * @return  the integer value of this hand
   */
  public int getHandValue()
  {
    return handValue;
  }

  /**
   * Returns an iterator over this hand.
   *    
   * @return  an iterator over this hand
   */
  public Iterator<Card> iterator()
  {
    return inHand.iterator();
  }

  /**
   * Removes a card from this hand.
   *
   * @param crd                        the card to be removed from this hand
   * @return                           the card that was removed from this hand
   * @throws ElementNotFoundException  if an element not found exception occurs
   */
  public Card remove(Card crd) throws ElementNotFoundException
  {
    return(inHand.remove(crd));
  }

  /**
   * Returns a string representation of this hand.
   *
   * @return  a string representation of this hand
   */
  public String toString()
  {
    String result="";
    Card cardStr = null;
    int i=0;
    Iterator<Card> scan = inHand.iterator();
    
    while (scan.hasNext())
    {
      cardStr= scan.next();
      result += "card"+ i +": "+cardStr.getValue()+"\n";
      i++;
    }
    
    return result;
  }
}
