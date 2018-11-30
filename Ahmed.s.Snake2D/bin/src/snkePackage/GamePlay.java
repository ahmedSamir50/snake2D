package snkePackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class GamePlay extends JPanel implements KeyListener,ActionListener{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon titleImage;
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	private boolean left = false ;
	private boolean right = false ;
	private boolean up = false ;
	private boolean down = false ;
	private ImageIcon rightMouth=new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//rightmouth.png"));
	private ImageIcon leftMouth=new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//leftmouth.png"));
	private ImageIcon upMouth=new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//upmouth.png"));
	private ImageIcon downMouth=new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//downmouth.png"));
	private int moves =0 ;
	
	private int lengthOfSnake = 3;

	// FoodS 
	private int[] fodXPos = {100,50,75,100,125,150,175,200,225,250,275,300,325,350,
			                 375,400,425,450,475,500,525,550,600,625,650,675,700,
			                  725,750,775,800,825,850};
	private int[] fodYPos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,
			                  450,475,500,525,550,575,600,625};
	private ImageIcon foodImage ;
	private Random random = new Random();
	
	private int foodXPos = random.nextInt(34);
	private int foodYPos = random.nextInt(23);
	
	//Foos End 
	private Random R ;
	// = new Random();
   private  Color c ;
   // = new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
	
	private Timer timer ;
	private int delay = 100;
	
	private int score =0;
	private ImageIcon snakeImage ;
	
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();
		
	}
	@Override
	public void paint(Graphics g) {
		try {
		//now started
		if (moves==0) {
			snakeXlength[0]=100;
			snakeXlength[1]=75;
			snakeXlength[2]=50;
			
			snakeYlength[0]=100;
			snakeYlength[1]=100;
			snakeYlength[2]=100;
					
		}
		// drawing the game title 
		g.setColor(c);
		g.draw3DRect(24,10,851, 55, true);
		
		//drawing image title
		titleImage = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//snaketitle.jpg") );
		titleImage.paintIcon(this, g, 25, 10);
		
		//drowing border For game 
		R= new Random();
		c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
		g.setColor(Color.WHITE);
		g.fillRect(24, 74,851,575);
		rightMouth = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//rightmouth.png") );
		rightMouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
		//Writing Score And 
		g.setColor(c);
		g.setFont(new Font("arial",Font.BOLD,16));
		g.drawString("Score : "+score, 780, 30);
		//drawing the rock
		ImageIcon rockImage = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//rock.png"));
		rockImage.paintIcon(this, g, 200, 200);
		//Writing Snake Length And 
				g.setColor(c);
				g.setFont(new Font("arial",Font.BOLD,16));
				g.drawString("Length : "+lengthOfSnake, 780, 50);
				R= new Random();
				c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
			g.setColor(c);
		
		for (int i = 0 ; i < lengthOfSnake;i++) {
			
			if (i==0 && right) {
				rightMouth = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//rightmouth.png"));
				rightMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && left) {
				leftMouth = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//leftmouth.png"));
				leftMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && up) {
				upMouth = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//upmouth.png"));
				upMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && down) {
				downMouth = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//downmouth.png"));
				downMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			
			if (i !=0) { snakeImage = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//snakeimage.png"));
			snakeImage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			snakeImage.paintIcon(this, g, snakeXlength[i+1], snakeYlength[i+1]);}
		}
		//Food 
	foodImage = new ImageIcon(getClass().getClassLoader().getResource("ImagesFile//enemy.png"));
	if (fodXPos[foodXPos]== snakeXlength[0] && fodYPos[foodYPos]==snakeYlength[0])
	{
		score++;
		lengthOfSnake++; 
		foodXPos=random.nextInt(34);
		foodYPos=random.nextInt(23);
	}
	
	foodImage.paintIcon(this, g, fodXPos[foodXPos], fodYPos[foodYPos]);
		
	for (int x = 1 ; x < lengthOfSnake;x++) 
	{
		
		 if (snakeXlength[x]==snakeXlength[0] && snakeYlength[x]==snakeYlength[0]) 
		{
			right=false;
			left=false;
			up=false;
			down=false;
			R= new Random();
			c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
			g.setColor(c);
			g.setFont(new Font ("arial",Font.BOLD,52));
			g.drawString(" Game Over -): ", 300, 300);
			lengthOfSnake=3;
			R= new Random();
			c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
			g.setColor(c);
			g.setFont(new Font ("arial",Font.BOLD,16));
			g.drawString(" Press Space To Re-start ", 557, 340);
			
		}
		 else 	 if ( (snakeXlength[x]==200 && snakeYlength[x]==200 ) || (snakeXlength[x]==225 && snakeYlength[x]==225 ) || (snakeXlength[x]==250 && snakeYlength[x]==250 ) ) 
			{
				right=false;
				left=false;
				up=false;
				down=false;
				R= new Random();
				c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
				g.setColor(c);
				g.setFont(new Font ("arial",Font.BOLD,52));
				g.drawString(" Game Over -): ", 300, 300);
				lengthOfSnake=3;
				score=0;
				R= new Random();
				c= new Color(R.nextFloat(),R.nextFloat(),R.nextFloat());
				g.setColor(c);
				g.setFont(new Font ("arial",Font.BOLD,16));
				g.drawString(" Press Space To Re-start ", 557, 340);
				
			}
	}
		}
		catch (Exception exp ) {new GamePlay(); }
		
	g.dispose();	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if (right) {
			for (int i = lengthOfSnake-1;i>=0;i--) {
				snakeYlength[i+1]=snakeYlength[i];
			}
			for (int i = lengthOfSnake ; i>=0 ; i-- ) {
				if (i==0) {snakeXlength[i]=snakeXlength[i]+25;}
				else {snakeXlength[i]= snakeXlength[i-1];}
				if (snakeXlength[i]>850) {snakeXlength[i]=25;}
				repaint();	 
			}
			
		}
		else if (left) {
        	for (int i = lengthOfSnake-1;i>=0;i--) {
				snakeYlength[i+1]=snakeYlength[i];
			}
			for (int i = lengthOfSnake ; i>=0 ; i-- ) {
				if (i==0) {snakeXlength[i]=snakeXlength[i]-25;}
				else {snakeXlength[i]= snakeXlength[i-1];}
				if (snakeXlength[i]<25) {snakeXlength[i]=850;}
				repaint();
			}
			
		}
		else if (up) {
        	for (int i = lengthOfSnake-1;i>=0;i--) {
				snakeXlength[i+1]=snakeXlength[i];
			}
			for (int i = lengthOfSnake ; i>=0 ; i-- ) {
				if (i==0) {snakeYlength[i]=snakeYlength[i]-25;}
				else {snakeYlength[i]= snakeYlength[i-1];}
				if (snakeYlength[i]<75) {snakeYlength[i]=625;}
				repaint();	 
			}
			
         }
		else if (down) {
        	for (int i = lengthOfSnake-1;i>=0;i--) {
				snakeXlength[i+1]=snakeXlength[i];
			}
			for (int i = lengthOfSnake ; i>=0 ; i-- ) {
				if (i==0) {snakeYlength[i]=snakeYlength[i]+25;}
				else {snakeYlength[i]= snakeYlength[i-1];}
				if (snakeYlength[i]>625) {snakeYlength[i]=75;}
				 repaint();
			}
			repaint();
	
         }
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_SPACE) 
		{
		
			 moves=0;
			 score=0;
			 lengthOfSnake=3;
			 repaint();
		}
		if ( arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			moves+=1;
			right=true;
			if (left==false) {
				right=true;
			}
			else { right=false ; left = true ;}
			up=false ;
			down=false;
		}
		if ( arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			moves+=1;
			left=true;
			if (! right) {
				left=true;
			}
			else { left=false ; right = true ;}
			up=false ;
			down=false;
		}
		if ( arg0.getKeyCode()==KeyEvent.VK_UP) {
			moves+=1;
			up=true;
			if (! down) {
				up=true;
			}
			else { down=true ; up = false ;}
			left=false ;
			right=false;
		}
		if ( arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			moves+=1;
			down=true;
			if (! up) {
				down=true;
			}
			else { up=true ; down = false ;}
			left=false ;
			right=false;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
