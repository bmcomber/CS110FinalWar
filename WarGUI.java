/**War GUI operated independent of the War class which contains the guts of the game*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private JPanel panel1, panel2, panel3, panel4, panel5;
   private JLabel deck1, drawn1, drawn2, deck2;
   private ImageIcon back;
   private Button flipButton;
   
   /**Constructor sets the initial GUI for the card Game war
         Outside two panels are face down cards that represent player decks
         Two panels inside decks are initially blank to hold place for flipped cards
         Button in middle takes flip input
   */
   public WarGUI()
   {
      //Name the frame
      setTitle("The Game of War");
      
      //set flowlayout
      setLayout(new FlowLayout());
      
      //new War object
      game = new War();
      
      //Image icon for the back of the cards
      back = new ImageIcon("back.jpg");
      //add panel1 as facedown
      panel1 = new JPanel();
      deck1 = new JLabel();
      deck1.setIcon(back);
      panel1.add(deck1);
      add(panel1);
      
      //add panel2 facedown     
      panel2 = new JPanel();
      drawn1 = new JLabel();
      drawn1.setIcon(back);
      panel2.add(drawn1);
      add(panel2);
     
      //add the flip button in middle 
      panel3 = new JPanel();
      flipButton = new Button("Flip Card");
      flipButton.addActionListener(new ButtonListener());
      panel3.add(flipButton);
      add(panel3);
      
      //add panel4 facedown
      panel4 = new JPanel();
      drawn2 = new JLabel();
      drawn2.setIcon(back);
      panel4.add(drawn2);
      add(panel4);

      //add panel5 facedown
      panel5 = new JPanel();
      deck2 = new JLabel();
      deck2.setIcon(back);
      panel5.add(deck2);
      add(panel5);
  }


   // handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
      
      /**while the decks are not empty, allow users to play the game*/        
         while(game.isEmpty() == false)
         {
        
            //save result from flip (flip compares the first card for both players and returns a 0 if equal, 1 if 2>1, 2 if 2>1
            int result = game.flip(0);
            
            //show the flip
            drawn1.setIcon(game.getImage1(0));
            panel4.add(drawn1);
            
            drawn2.setIcon(game.getImage2(0));
            panel2.add(drawn2);
            
            boolean equal = false;
            
            //panel4.setIcon(
            //if they are equal, set equal to true so the players go to war
            if (result == 0)
            {
            //make the button go to war on the next press
            equal = true;
            }  
            
            //otherwise add flipped cards to the winning deck
            if(result == 1)
            {
            game.addDeck1();
            //back of card
            drawn1.setIcon(back);
            panel4.add(drawn1);
            
            drawn2.setIcon(back);
            panel2.add(drawn2);
            }
            else if(result == 2)
            {
            game.addDeck2();
            //back of card
            drawn1.setIcon(back);
            panel4.add(drawn1);
            
            drawn2.setIcon(back);
            panel2.add(drawn2);
            }
         
      
         //go to war if they are equal
       while(equal == true)
       {
         //go to war: set the index to 2 so the flipped command can be used to check the 3rd cards in the arraylist
         int index = 2;
    
         //get new flipped results
         int result2 = game.flip(index);
         
         //if the results are not equal add all cards to the winning deck and quit the war loop
         if(result2 == 1)
         {
         
            for (int n = 0; n<= index; n++)
            {
               game.addDeck1();
            }
            equal = false;
         }
         else if(result2 == 2)
         {
            for (int m = 0; m<= index; m++)
            {
               game.addDeck2();
            }
            equal = false;
         }
         if(game.isEmpty()== true)
            equal = false;
            
         //if a player will run out of cards during the war, add remaining cards to the other player's deck
         while(equal != false)
         {
            if(index >= game.size1())
            {
              for (int b = 0; b<=index; b++)
               {
                  game.addDeck2();
               }
               //quit the war loop and declare the other player the winner
               equal = false;
            }
            if(index >= game.size2())
            {
                         
               //add remaining cards to player 1's deck
               for (int c = 0; c<=index; c++)
               {
                  game.addDeck2();
               }
               //quit the war loop and declare the other player the winner
               equal = false;
            }
            //increment the index by 2
            index+=2;
         }
       }
      }
     }
   }   
      
 }     
      
   