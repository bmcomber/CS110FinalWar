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
      
      //add panel1 as facedown with a counter for cards
      panel1 = new JPanel();
      deck1 = new JLabel(game.strSize1());
      deck1.setIcon(back);
      panel1.add(deck1);
      add(panel1);
      
      //add panel2 facedown     
      panel2 = new JPanel();
      drawn1 = new JLabel();
      drawn1.setIcon(back);
      panel2.add(drawn1);
      add(panel2);
     
      //panel3 facedown
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
      
      //warbutton in middle
      panel5 = new JPanel();
      warButton = new Button("Go to War");
      warButton.addActionListener(new WarButton());
      panel5.add(warButton);
      warButton.setEnabled(false);
      add(panel5);
      
      //panel 6 facedown
      panel6 = new JPanel();
      war2 = new JLabel();
      war2.setIcon(back);
      panel6.add(war2);
      add(panel6);
      
      //add panel7 facedown with counter for cards
      panel7 = new JPanel();
      drawn2 = new JLabel(game.strSize2());
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
 


   /**FlipButton acts when the users draw and the cards are not equal
   */
   private class FlipButton implements ActionListener
   {
      
      public void actionPerformed(ActionEvent e)
      {  
           //do not do anything on press if either deck is empty
           if(game.isEmpty()==false)
           {

            //save result from flip
            int result = game.flip(0);
            
            //show the flip
            drawn2.setIcon(game.getImage2(0));
            war1.setIcon(back);
            war2.setIcon(back);
            drawn1.setIcon(game.getImage1(0));
            
            
            //if they are equal,go to war
            if (result == 0)
            {
               warButton.setEnabled(true);
               flipButton.setEnabled(false);
               deck1.setText(game.strSize1());
               drawn2.setText(game.strSize2());
            }  
            
            //otherwise add flipped cards to the winning deck
            if(result == 1)
            {
               game.addDeck1();
               
            }
            else if(result == 2)
            {
               game.addDeck2();

            }
           //display number of cards
           deck1.setText(game.strSize1());
           drawn2.setText(game.strSize2());
           }
           //print the winner if someone has no cards left
           else if(game.size1() == 0)
           {
               JOptionPane.showMessageDialog(null, "Player 2 has won the Game!");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Player 1 has won the Game");
           }

        } 
      } 
       
    /**WarButton class acts when the users have drawn the same card
    */   
   private class WarButton implements ActionListener
   {   
       public void actionPerformed(ActionEvent f)
       {
       //if either player has less than the three cards required for war, do not let them draw
       if(game.size1()>=3 || game.size2()>=3)
       {
       drawn1.setIcon(back);
       drawn2.setIcon(back);
       war1.setIcon(game.getImage1(2));
       war2.setIcon(game.getImage2(2));
       
         //go to war: set the index to 2 so the flipped command can be used to check the 3rd cards in the arraylist
         int index = 2;
    
         //get new flipped results
         int result2 = game.flip(index);
         
         //if the results are not equal add all cards to the winning deck
         if(result2 == 1)
         {
         
            for (int n = 0; n<= index; n++)
            {
               game.addDeck1();
            }
           warButton.setEnabled(false);
           flipButton.setEnabled(true);
         }
         else if(result2 == 2)
         {
            for (int m = 0; m<= index; m++)
            {
               game.addDeck2();
            }
           warButton.setEnabled(false);
           flipButton.setEnabled(true);
      
         }  
         else     //the players need to go to war again
         {
            warButton.setEnabled(true);
            //increment the index by 2 for the next war iteration
            index+=2;
         }
         //display the remaining cards
         deck1.setText(game.strSize1());
         drawn2.setText(game.strSize2());
        }
        //if either player will run out of cards during war, the other player won
        else if(game.size1()<=2)
        {
            JOptionPane.showMessageDialog(null,"Player 1 has run out of Cards during the game. Player 2 wins!");
        }
        else if(game.size2()<=2)
        {
            JOptionPane.showMessageDialog(null,"Player 2 has run out of Cards during the game. Player 1 wins!");
        }
      }
   }
 
}
      
     
      
   