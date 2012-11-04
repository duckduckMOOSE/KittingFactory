import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.*;


import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Feeder {
	boolean isOn;
	char direction;
	LinkedList<Part> feederParts;
	Lane leftLane, rightLane;
	
	ImageIcon feederSprite;
	ImageIcon diverterSprite;
	
	Rectangle2D.Double feederBox;
	Ellipse2D.Double leftLight;
	Ellipse2D.Double rightLight;

	int x;
	int y;
	
	public Feeder(int xPos, int yPos){
		x = xPos;
		y = yPos;
		
		feederBox = new Rectangle2D.Double( x, y, 25, 50 );
		
		leftLight = new Ellipse2D.Double(x+5, y+35, 10, 10);
		rightLight = new Ellipse2D.Double(x+5, y+5, 10, 10);
		
		isOn = false;
		direction = 'L';
		feederParts = new LinkedList<Part>();
		leftLane = new Lane(x, y+30);
		rightLane = new Lane(x, y);
		
		feederSprite = new ImageIcon("images/feeder.png");
		
		stockFeeder();
		
		
	}
	

	public void set_isOn(boolean a ){
		isOn = a;
	}
	
	public void stockFeeder(){
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			feederParts.add(new Part());
			
	}
	
	public void switchLanes(){
		if (direction == 'L')
			direction = 'R';
		else
			direction = 'L';
	}
	
	
	public void sendPartToLane(){
		if(feederParts.size()!=0 && isOn==true){
			if(direction =='L')
			{
				//Currently set to peek, needs to be set to pop when we dont want unlimited.
				System.out.println("ADDING PART TO LEFT");
				feederParts.peek().setPosition(x, y+32);
				leftLane.laneParts.add(feederParts.peek());
				feederParts.remove();
			}
			else
			{
				System.out.println("ADDING PART TO RIGHT");
				feederParts.peek().setPosition(x, y+2);
				rightLane.laneParts.add(feederParts.peek());
				feederParts.remove();
			}
		}		
	}


	public void paintFeeder(Graphics g, JPanel j){
		Graphics2D g2 = (Graphics2D)g;

		leftLane.paintLane(g, j);
		rightLane.paintLane(g, j);
		
		g2.setColor(Color.BLACK);
		g2.fill(feederBox);
		
		g2.setColor(Color.GREEN);
		if(direction == 'L'){
			g2.fill(leftLight);
			g2.setColor(Color.RED);
			g2.fill(rightLight);
		}
		else if(direction =='R')
		{
			g2.fill(rightLight);
			g2.setColor(Color.RED);
			g2.fill(leftLight);
		}	
	}
}
