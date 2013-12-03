/*Driver Class*/

import javax.swing.*;

public class WarDriver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
      // OR
      frame.setSize(900,300);
      frame.validate();
      frame.setVisible(true);


   
   
   }


}