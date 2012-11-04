import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Lane {
	
	
	LinkedList<Part> laneParts;
	int laneSpeed;
	int laneLength;
	int x, y;
	Rectangle2D.Double laneRectangle;
	
	public Lane(int xPos, int yPos){
		
		laneLength = 300;
		x = xPos;
		y = yPos;

		laneParts = new LinkedList<Part>();	
		laneSpeed = 3;
		
	    
	    laneRectangle = new Rectangle2D.Double(x-laneLength, y, laneLength, 20);
	}
	

	public void moveDownLane(){
		
		if(laneParts.size()!=0){
			for(int i = 0; i < laneParts.size(); i++){
				laneParts.get(i).incrementX(-laneSpeed);
				// if part reaches a certain x position, it gets deleted.
				if (laneParts.get(i).x < x-laneLength){
					laneParts.remove(i);
					System.out.println("Part reached destination");
				}
			}
		}
		
		
	}
	
	
	
	public void paintLane(Graphics g, JPanel j){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.gray);
		g2.fill(laneRectangle);
		
		for(int i = 0; i < laneParts.size(); i++){
		laneParts.get(i).paintCard(g, j);
		}
	}
	
	
}
