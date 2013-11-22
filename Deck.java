/**Deck class creates 52 different card objects complete with rank, suit and image
   and puts them into an ArrayList of Card objects
*/

import java.util.ArrayList;

public class Deck
{
   //initialize arraylist to contain 52 Card objects
   ArrayList<Card> deck = new ArrayList<Card>(52);
   
   /**Deck constructor creates a new array of 52 unshuffled cards
   */
   public Deck()
   {
      freshDeck();
   }
   
   
   /**freshDeck Method creates 52 individual card objects, assigning a rank, 
      suit and image file to each objects
      @return: an arraylist with all 52 card objects in it
   */
   public ArrayList<Card> freshDeck()
   {
      //Create all 14 club Card objects and add them to the deck ArrayList
      Card c2 = new Card(2, "clubs", "2c.jpg");
      deck.add(c2);
      Card c3 = new Card(3, "clubs", "3c.jpg");
      deck.add(c3);
      Card c4 = new Card(4, "clubs", "4c.jpg");
      deck.add(c4);
      Card c5 = new Card(5, "clubs", "5c.jpg");
      deck.add(c5);
      Card c6 = new Card(6, "clubs", "6c.jpg");
      deck.add(c6);
      Card c7 = new Card(7, "clubs", "7c.jpg");
      deck.add(c7);
      Card c8 = new Card(8, "clubs", "8c.jpg");
      deck.add(c8);
      Card c9 = new Card(9, "clubs", "9c.jpg");
      deck.add(c9);
      Card c10 = new Card(10, "clubs", "10c.jpg");
      deck.add(c10);
      Card c11 = new Card(11, "clubs", "jackc.jpg");
      deck.add(c11);
      Card c12 = new Card(12, "clubs", "queenc.jpg");
      deck.add(c12);
      Card c13 = new Card(13, "clubs", "kingc.jpg");
      deck.add(c13);
      Card c14 = new Card(14, "clubs", "acec.jpg");
      deck.add(c14);
  
      //Create all 14 heart Card Objects and add them to the deck ArrayList   
      Card h2 = new Card(2, "hearts", "2h.jpg");
      deck.add(h2);
      Card h3 = new Card(3, "hearts", "3h.jpg");
      deck.add(h3);
      Card h4 = new Card(4, "hearts", "4h.jpg");
      deck.add(h4);
      Card h5 = new Card(5, "hearts", "5h.jpg");
      deck.add(h5);
      Card h6 = new Card(6, "hearts", "6h.jpg");
      deck.add(h6);
      Card h7 = new Card(7, "hearts", "7h.jpg");
      deck.add(h7);
      Card h8 = new Card(8, "hearts", "8h.jpg");
      deck.add(h8);
      Card h9 = new Card(9, "hearts", "9h.jpg");
      deck.add(h9);
      Card h10 = new Card(10, "hearts", "10h.jpg");
      deck.add(h10);
      Card h11 = new Card(11, "hearts", "jackh.jpg");
      deck.add(h11);
      Card h12 = new Card(12, "hearts", "queenh.jpg");
      deck.add(h12);
      Card h13 = new Card(13, "hearts", "kingh.jpg");
      deck.add(h13);
      Card h14 = new Card(14, "hearts", "aceh.jpg");
      deck.add(h14);
      
      //Create all 14 diamond Card objects and add them to the deck ArrayList
      Card d2 = new Card(2, "diamonds", "2d.jpg");
      deck.add(d2);
      Card d3 = new Card(3, "diamonds", "3d.jpg");
      deck.add(d3);
      Card d4 = new Card(4, "diamonds", "4d.jpg");
      deck.add(d4);
      Card d5 = new Card(5, "diamonds", "5d.jpg");
      deck.add(d5);
      Card d6 = new Card(6, "diamonds", "6d.jpg");
      deck.add(d6);
      Card d7 = new Card(7, "diamonds", "7d.jpg");
      deck.add(d7);
      Card d8 = new Card(8, "diamonds", "8d.jpg");
      deck.add(d8);
      Card d9 = new Card(9, "diamonds", "9d.jpg");
      deck.add(d9);
      Card d10 = new Card(10, "diamonds", "10d.jpg");
      deck.add(d10);
      Card d11 = new Card(11, "diamonds", "jackd.jpg");
      deck.add(d11);
      Card d12 = new Card(12, "diamonds", "queend.jpg");
      deck.add(d12);
      Card d13 = new Card(13, "diamonds", "kingd.jpg");
      deck.add(d13);
      Card d14 = new Card(14, "diamonds", "aced.jpg");
      deck.add(d14);
      
      //Create all 14 spade Card objects and add them to the deck ArrayList   
      Card s2 = new Card(2, "spades", "2s.jpg");
      deck.add(s2);
      Card s3 = new Card(3, "spades", "3s.jpg");
      deck.add(s3);
      Card s4 = new Card(4, "spades", "4s.jpg");
      deck.add(s4);
      Card s5 = new Card(5, "spades", "5s.jpg");
      deck.add(s5);
      Card s6 = new Card(6, "spades", "6s.jpg");
      deck.add(s6);
      Card s7 = new Card(7, "spades", "7s.jpg");
      deck.add(s7);
      Card s8 = new Card(8, "spades", "8s.jpg");
      deck.add(s8);
      Card s9 = new Card(9, "spades", "9s.jpg");
      deck.add(s9);
      Card s10 = new Card(10, "spades", "10s.jpg");
      deck.add(s10);
      Card s11 = new Card(11, "spades", "jacks.jpg");
      deck.add(s11);
      Card s12 = new Card(12, "spades", "queens.jpg");
      deck.add(s12);
      Card s13 = new Card(13, "spades", "kings.jpg");
      deck.add(s13);
      Card s14 = new Card(14, "spades", "aces.jpg");
      deck.add(s14);
      
      //return the completely filled deck ArrayList
      return deck;
   }
   
}
   