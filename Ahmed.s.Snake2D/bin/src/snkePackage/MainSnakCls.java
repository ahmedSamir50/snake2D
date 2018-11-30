package snkePackage;
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class MainSnakCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JFrame obj = new JFrame();
       // creating New Inect. of Game Play
       GamePlay gamePlay = new GamePlay();
       
       
       obj.setBounds(10, 10, 905, 700);
       Random R = new Random();
       Color c = new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
       obj.setBackground(c);
      // obj.getFocusTraversalKeysEnabled();
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	obj.add(gamePlay);
	}

}
