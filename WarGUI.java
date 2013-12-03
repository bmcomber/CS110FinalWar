/**War GUI operated independent of the War class which contains the guts of the game*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
   private JLabel deck1, drawn1, war1, war2, drawn2, deck2;
   private ImageIcon back;
   private Button flipButton, warButton;
   
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
     
      panel3 = new JPanel();
      war1 = new JLabel();
      war1.setIcon(back);
      panel3.add(war1);
      add(panel3);
      
      //add the flip button in middle 
      panel4 = new JPanel();
      flipButton = new Button("Flip Card");
      flipButton.addActionListener(new FlipButton());
      panel4.add(flipButton);
      add(panel4);
      
      panel5 = new JPanel();
      warButton = new Button("Go to War");
      warButton.addActionListener(new WarButton());
      panel5.add(warButton);
      warButton.setEnabled(false);
      add(panel5);
      
      panel6 = new JPanel();
      war2 = new JLabel();
      war2.setIcon(back);
      panel6.add(war2);
      add(panel6);
      
      //add panel7 facedown
      panel7 = new JPanel();
      drawn2 = new JLabel();
      drawn2.setIcon(back);
      panel7.add(drawn2);
      add(panel7);

      //add panel8 facedown
      panel8 = new JPanel();
      deck2 = new JLabel();
      deck2.setIcon(back);
      panel8.add(deck2);
      add(panel8);
  }
 


   // handle button events
   private class FlipButton implements ActionListener
   {
      
      public void actionPerformed(ActionEvent e)
      {  
      
//           if(game.isEmpty() == false)
//           {
            //save result from flip
            int result = game.flip(0);
            
            //show the flip
            ImageIcon I = game.getImage1(0);
            drawn2.setIcon(game.getImage1(0));
            //panel4.add(drawn2);
            
            drawn1.setIcon(game.getImage2(0));
            //panel2.add(drawn1);
            
            
            //if they are equal, set equal to true so the players go to war
            if (result == 0)
            {
               warButton.setEnabled(true);
            }  
            
            //otherwise add flipped cards to the winning deck
            if(result == 1)
            {
               game.addDeck1();
               //Show the back of card
               //drawn1.setIcon(back);
               //panel4.add(drawn1);
               
               //drawn2.setIcon(back);
               //panel2.add(drawn2);
            }
            else if(result == 2)
            {
               game.addDeck2();
               //show the back of card
               //drawn1.setIcon(back);
               //panel4.add(drawn1);
               
               //drawn2.setIcon(back);
               //panel2.add(drawn2);
               }
        } 
      } 
       
       
   private class WarButton implements ActionListener
   {   
       public void actionPerformed(ActionEvent f)
       {
       //JOptionPane if war
       //go to war if they are equal
         boolean equal = true;
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
         //quit the war loop if a player has run out of cards and declare a winner
         if(game.isEmpty()== true)
            equal = false;
         
         //Declare a winner with JOptionPane if someone has run out of cards
            
//          /**make sure that if a player will run out of cards during the next war,
//             the rest of their cards go into the other's deck and they will lose the game   
//          */
//          while(equal != false)
//          {
//             if(index >= game.size1())
//             {
//               //add remaining cards to player 1's deck
//               for (int b = 0; b<=index; b++)
//                {
//                   game.addDeck2();
//                }
//                //quit the war loop and declare the other player the winner
//                equal = false;
//             }
//             if(index >= game.size2())
//             {
//                for (int c = 0; c<=index; c++)
//                {
//                   game.addDeck2();
//                }
//                //quit the war loop and declare the other player the winner
//                equal = false;
//             }
            //increment the index by 2 for the next war iteration
            index+=2;
         }
        }
        //if either player has no cards, declare a winner
 //        else
//         {
//             System.out.println("Somebody has no cards");
//         } 
       }
      
     
      
   