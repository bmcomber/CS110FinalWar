/**War class contains necessary constructors and methods for GUI game of War
*/

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class War
{
   ArrayList<Card> deck2;
   ArrayList<Card> deck1;
   ArrayList<Card> fullDeck;
   
   
   /**Constructor creates deck object, shuffles deck and splits it into two arrayLists for gameplay*/
   public War()
   {
      //Create new Deck object
      Deck deck = new Deck();
   
      //Create local ArrayList of Card Objects using freshDeck method
      fullDeck = deck.freshDeck();

      //shuffle deck
      Collections.shuffle(fullDeck);
      //for(int g = 0; g<52; g++)
        // System.out.println(fulldeck(g))
         
     
      //Declare new ArrayList for player1's card deck 
      deck1 = new ArrayList<Card>(26);
      
      //Fill 26 shuffled cards into player1's deck
      for(int i = 0; i<26; i++)
      {
         deck1.add(fullDeck.get(i));
      }
      
      //Declare new ArrayList for player2's card deck 
      deck2 = new ArrayList<Card>(26);
      
      //Fill 26 shuffled cards into player2's deck
      for(int h = 26; h<52; h++)
      {
         deck2.add(fullDeck.get(h));
      }
   }
   
      
   /**flip method takes the two arrayLists of Card objects, gets the first element's rank and compares them  
      @return: int 0: the ranks are equal
                   1: First rank > second rank
                   2: Second rank > first rank
   */  
      public int flip(int index)
      {
         int f;
         if(deck1.get(index).getRank() == deck2.get(index).getRank())
             f = 0;
         else if(deck1.get(index).getRank() > deck2.get(index).getRank())
             f = 1;
         else 
            f=2;
         return f;
       
      }   
  
      /**addDeck1 method takes the two ArrayList decks and adds the first card of both to the first deck
      @param: two arrayList card decks
      */
      public void addDeck1()
      {
        deck1.add(deck1.get(0));
        deck1.add(deck2.get(0));
        deck1.remove(0);
        deck2.remove(0);
      }
      
      /**addDeck2 method takes the two ArrayList decks and adds the first card of both to the second deck
      @param: two arrayList card decks
      */
      public void addDeck2()
      {
         deck2.add(deck2.get(0));
         deck2.add(deck1.get(0));
         deck2.remove(0);
         deck1.remove(0);
      }

      /**getImage methods make it returns the necessary for the ImageIcon objects from card class
         @param: the index of the required card image
         @return: the String for the card image
      */
      public ImageIcon getImage1(int f)
      {
         return deck1.get(f).getIcon();
      }

      public ImageIcon getImage2(int k)
      {
         return deck2.get(k).getIcon();
      }
      
      /**isEmpty method returns a boolean based on whether either of the two decks are empty
      @return: boolean- true one of the decks is empty
                        false neither of the decks is empty
      */
      public boolean isEmpty()
      {
         boolean empty = false;
         if(deck1.isEmpty() == true || deck2.isEmpty() == true)
            empty = true;
         return empty;
      }
      
      /**size returns the size of the corresponding deck
         @return: int size of the deck
       */
      public int size1()
      {
         return deck1.size();
      }
      
      public int size2()
      {
         return deck2.size();
      }
}

      
    
      

  