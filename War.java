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
      for(int i = 0; i<49; i++)
      {
         deck1.add(fullDeck.get(i));
      }
      
      //Declare new ArrayList for player2's card deck 
      ArrayList<Card> deck2 = new ArrayList<Card>(26);
      
      //Fill 26 shuffled cards into player2's deck
      for(int h = 49; h<52; h++)
      {
         deck2.add(fullDeck.get(h));
      }
    deck2.get(0).setRank(10);
    deck1.get(0).setRank(10);
    
    
      
    //*while the decks are not empty, allow users to play the game*/        
    while(deck1.isEmpty() == false && deck2.isEmpty() == false)
    {

      //Start Game (Scanner input)
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Flip Card? (Press enter)");
      keyboard.nextLine();
      
      //print the first card from deck1
      System.out.println("Player 1 has drawn: " + deck1.get(0));
      
      //print the first card from deck2
      System.out.println("Player 2 has drawn: " + deck2.get(0));
      
      //save result from flip (flip compares the first card for both players and returns a 0 if equal, 1 if 2>1, 2 if 2>1
      int result = flip(deck1, deck2, 0);
      boolean equal = false;
  
      //if they are equal, set equal to true so the players go to war
      if (result == 0)
      {
         equal = true;
      }
      
      //otherwise add flipped cards to the winning deck
      if(result != 0)
      {
         if(result == 1)
            addDeck1(deck1, deck2);
         else if(result == 2)
            addDeck2(deck1, deck2);
            
      }

      //go to war: set the index to 2 so the flipped command can be used to check the 3rd cards in the arraylist
      int index = 2;
      while( equal == true)
      {
         
         System.out.println("Go to war? (Press enter)");
         keyboard.nextLine();
         //print deck1
         System.out.println("Player 1 has drawn: " + deck1.get(index));
      
         //print deck2
         System.out.println("Player 2 has drawn: " +deck2.get(index));
         
         //get new flipped results
         int result2 = flip(deck1, deck2, index);
         
        //if the results are not equal add all cards to the winning deck and quit the war loop
         if(result2 == 1)
         {
         
            for (int n = 0; n<= index; n++)
            {
               addDeck1(deck1, deck2);
            }
            equal = false;
         }
         else if(result2 == 2)
         {
            for (int m = 0; m<= index; m++)
            {
               addDeck2(deck1, deck2);
            }
            equal = false;
         }
         if(deck1.isEmpty() == true || deck1.isEmpty() == true)
            equal = false;
            
         //if a player will run out of cards during the war, add remaining cards to the other player's deck
         while(equal != false)
         {
            if(index >= deck1.size())
            {
               System.out.println("Player 1 does not have enough remaining cards to go to war");
            
               //add remaining cards to player 2's deck
               for (int b = 0; b<=index; b++)
               {
                  addDeck2(deck2, deck1);
               }
               //quit the war loop and declare the other player the winner
               equal = false;
            }
            if(index >= deck2.size())
            {
               System.out.println("Player 1 does not have enough remaining cards to go to war");
          
               //add remaining cards to player 1's deck
               for (int c = 0; c<=index; c++)
               {
                  addDeck2(deck2, deck1);
               }
               //quit the war loop and declare the other player the winner
               equal = false;
            }
            //increment the index by 2
            index+=2;
           }
      
//         if(result2 ==0) //continue the war (print statements for scanner game)
//         {
//          System.out.println("Player 1 has: "+ deck1.size() + " cards");
//          System.out.println("Player 2 has: " + deck2.size()+ " cards");
//         }
      }
        System.out.println("Player 1 has: "+ deck1.size() + " cards");
        System.out.println("Player 2 has: " + deck2.size()+ " cards");
     } 
     
    //Print the results for the scanner game
    if(deck1.isEmpty() == true)
      System.out.println("Player 1 has run out of cards. Player 2 has won!");
    if(deck2.isEmpty() == true)
      System.out.println("Player 2 has run out of cards. Player 1 has won!");
    
      
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
      
      public static void addDeck1(ArrayList<Card> d1, ArrayList<Card> d2)
      {
         d1.add(d1.get(0));
         d1.add(d2.get(0));
         d1.remove(0);
         d2.remove(0);
      }
      
      public static void addDeck2(ArrayList<Card> d1, ArrayList<Card> d2)
      {
         d2.add(d2.get(0));
         d2.add(d1.get(0));
         d2.remove(0);
         d1.remove(0);
      }
      
}
