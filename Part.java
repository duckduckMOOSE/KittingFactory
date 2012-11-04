import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Part{
	int x;
	int y;
	int type;
	ImageIcon sprite;

	public Part(){
		sprite = new ImageIcon("images/inky.png");
		
		
	}
	
	public void setPosition(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	
	public void incrementX(int xVel){
		x += xVel;
	}
	
	public void incrementY(int yVel){
		y += yVel;
	}
	
	public void paintCard(Graphics g, JPanel j){
		sprite.paintIcon(j, g, x, y);
	}
	
	
}
