/**War class contains all necessary methods to play the GUI game of War
*/

import java.util.ArrayList;
import java.util.Collections;

public class War
{
   public static void main(String [] args)
   {
      Deck deck = new Deck();
      ArrayList<Card> fullDeck;
      fullDeck = deck.freshDeck();
      
      
      //print unshuffled deck
      for( int i= 0; i< fullDeck.size(); i++)
      {
         System.out.println(fullDeck.get(i));
      }

      //shuffle deck
      Collections.shuffle(fullDeck);
      
      //print shuffled deck
      System.out.println("\n");
      for( int j= 0; j< fullDeck.size(); j++)
      {
         
         System.out.println(fullDeck.get(j));
      }
      
   }
}