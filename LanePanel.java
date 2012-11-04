import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;



public class LanePanel extends JPanel implements ActionListener{
	
	int timerCounter;
    Rectangle2D.Double backgroundBox;
	Feeder feeder;
	

	public LanePanel() {
		
		backgroundBox = new Rectangle2D.Double(0,0, 700,500);
		setSize(700,500);
		
		feeder = new Feeder( 600, 100);
		timerCounter = 0;
		new Timer(40, this).start();

	}
	
	 public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.white);
			g2.fill(backgroundBox);
			
	    	feeder.paintFeeder(g, this);
	
	    }
	    
	
	public void actionPerformed(ActionEvent ae){
    	timerCounter++;

    	if ("SWITCH".equals(ae.getActionCommand())){
        		feeder.switchLanes();
        	
    	}else if ("On".equals(ae.getActionCommand())){
    		feeder.set_isOn(true);
    		System.out.println("System Started");
    		
    	}
    	else if ("Off".equals(ae.getActionCommand())){
    		feeder.set_isOn(false);
    		System.out.println("System Stopped");

    	}
    	
    	
    	if(feeder.isOn){
        	if(timerCounter%50 == 0){
        		feeder.sendPartToLane();
        		
        	}
        	
        	feeder.leftLane.moveDownLane();
        	feeder.rightLane.moveDownLane();
        	
    	}

    	repaint();
	}

}
