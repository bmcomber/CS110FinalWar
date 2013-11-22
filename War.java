/**War class contains all necessary methods to play the GUI game of War
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class War
{
   public static void main(String [] args)
   {
      //Create new Deck object
      Deck deck = new Deck();
      
      //Create local ArrayList of Card Objects using freshDeck method
      ArrayList<Card> fullDeck = deck.freshDeck();
      

      //shuffle deck
      Collections.shuffle(fullDeck);

      //Declare new ArrayList for player1's card deck 
      ArrayList<Card> deck1 = new ArrayList<Card>(26);
      
      //Fill 26 shuffled cards into player1's deck
      for(int i = 0; i<=25; i++)
      {
         deck1.add(fullDeck.get(i));
      }
      
      //Declare new ArrayList for player2's card deck 
      ArrayList<Card> deck2 = new ArrayList<Card>(26);
      
      //Fill 26 shuffled cards into player2's deck
      for(int h = 26; h<52; h++)
      {
         deck2.add(fullDeck.get(h));
      }
      
      
      
      
      
      
    deck1.get(0).setRank(3);
    deck2.get(0).setRank(3);
    deck1.get(3).setRank(10);
    deck2.get(3).setRank(10);
    deck1.get(6).setRank(5);
    deck2.get(6).setRank(5);
      
    while(deck1.isEmpty() == false && deck2.isEmpty() == false)
    {

      //Start Game
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Start Game? (Press anything to flip the first card");
      keyboard.nextLine();
      //print deck1
      System.out.println(deck1.get(0));
      
      //print deck2
      System.out.println("\n");
      System.out.println(deck2.get(0));
      
      int result = flip(deck1, deck2, 0);
      boolean equal = false;
  
      if (result == 0)
      {
         equal = true;
      }
      if(result != 0)
      {
         if(result == 1)
            addDeck1(deck1, deck2, 0);
         else if(result == 2)
            addDeck2(deck1, deck2, 0);
      }

      int index = 3;
      while( equal == true)
      {
         //print deck1
         System.out.println(deck1.get(index));
      
         //print deck2
         System.out.println("\n");
         System.out.println(deck2.get(index));
         
         int result2 = flip(deck1, deck2, index);
         
        //add for three
         if(result2 == 1)
         {
         
            for (int n = 0; n<= index; n++)
            {
               addDeck1(deck1, deck2, n);
            }
            equal = false;
         }
         else if(result2 == 2)
         {
            for (int m = 0; m<= index; m++)
            {
               addDeck2(deck1, deck2, m);
            }
            equal = false;
         }
         index+=3;  
        System.out.println(deck1.size() + ", " + deck2.size());
      }
        System.out.println(deck1.size() + ", " + deck2.size());
   }
      
    
      
   }
      
      /**static flip method takes in the two arrayLists of Card objects, gets the first element's rank and compares them
      @param: two arrayLists of Card objects    
      @return: int 0: the ranks are equal
                   1: First rank > second rank
                   2: Second rank > first rank
      */  
      public static int flip(ArrayList<Card> d1, ArrayList<Card> d2, int index)
      {
          int f;
         if(d1.get(index).getRank() == d2.get(index).getRank())
             f = 0;
         else if(d1.get(index).getRank() > d2.get(index).getRank())
             f = 1;
         else 
            f=2;
         return f;
      } 
      
      public static void addDeck1(ArrayList<Card> d1, ArrayList<Card> d2, int index)
      {
         d1.add(d1.get(index));
         d1.add(d2.get(index));
         d1.remove(index);
         d2.remove(index);
      }
      
      public static void addDeck2(ArrayList<Card> d1, ArrayList<Card> d2, int index)
      {
         d2.add(d2.get(index));
         d2.add(d1.get(index));
         d2.remove(index);
         d1.remove(index);
      }
      
}
