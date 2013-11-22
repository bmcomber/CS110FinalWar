/**Card Class Creates a new individual card object with a rank, suit and Image*/

public class Card
{
   //Card Object fields
   private int rank;
   private String suit;
   private String image;
   
   /**Card Consructor takes creates a new card object with a rank, suut and image
     @param: int rank (1 to 14, ace high), String suit, String image file
   */
   public Card(int rank, String suit, String image)
   {
      this.rank = rank;
      this.suit = suit;
      this.image = image;
   }
   
   /**Get methods allow the client to view and use the card's attributes
   @return: getRank returns int rank, getSuit returns String suit, getImage returns String image file
   */
   
   public int getRank()
   {
      return rank;
   }
   
   public String getSuit()
   {
      return suit;
   }
   
   public String getImage()
   {
      return image;
   }
   
   public void setRank(int rank)
   {
      this.rank = rank;
   }
   
   /**toString method returns a string representation of the object's fields
   @return: rank, suit, image file
   */
   public String toString()
   {
      String s = rank + ", " + suit + ", " + image;
      return s;
   } 
   
}