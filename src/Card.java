/**
 * Card provides an implementation of a class to represent a
 * playing card.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/18/08
 */

import java.util.Random;
import javax.swing.*;

public class Card
{
  protected String face;
  protected ImageIcon cardPic;
  protected int value; 
  protected String suit;
  
  /**
   * Constructs a card.
   */
  public Card()
  {
    cardPic = null;
    value = 0;
    suit = null;
    face = null;
  }
  
  /**
   * Draws the shape of this card.
   *
   * @param x    the image icon for this card
   * @param val  the integer face value of this card
   * @param s    the string value for the face value of this card
   * @param f    the string value for the suit value of this card
   */
  public Card(ImageIcon x, int val, String s, String f)
  {
    cardPic = x;
    value = val;
    face = f;
    suit = s;
  }
  
  /**
   * Returns the image of this card.
   *
   * @return  the image icon for this card
   */
  public ImageIcon getImage()
  {
    return cardPic;
  }
  
  /**
   * Returns the value of this card.
   *
   * @return  the integer value for this card
   */
  public int getValue()
  {
    return value;
  }
  
  /**
   * Allows the user to set the value of this card.
   *
   * @param v  the integer value to be assigned to this card
   */
  public void setValue(int v)
  {
    value = v;
  }

  /**
   * Returns the suit of this card.
   *
   * @return  the string value for the suit of this card
   */
  public String getSuit()
  {
    return suit;
  }

  /**
   * Returns the face of this card.
   *
   * @return  the string value for the face value of this card
   */
  public String getFace()
  {
    return face;
  }
  
  /**
   * Returns a string representation this card.
   *
   * @return  the string representation for this card including the face, suit,
   *          and the value
   */
  public String toString()
  {
    return "Face: "+ face + " Suit"+ suit +" Value: "+ value;
  }
}
