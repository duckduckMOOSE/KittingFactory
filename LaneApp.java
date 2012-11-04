import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;


public class LaneApp extends JFrame implements ActionListener{

	LanePanel panel;
	JPanel buttonPanel;
	JButton laneSwitcher;
    JButton onButton, offButton;
	
	
	public LaneApp(){
		setLayout(new BorderLayout());

		panel = new LanePanel();
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,0));

		laneSwitcher = new JButton("Switch Lanes");
		laneSwitcher.setActionCommand("SWITCH");
		laneSwitcher.addActionListener(panel);
		
		onButton = new JButton("On");
		onButton.setActionCommand("On");
		onButton.addActionListener(panel);
		onButton.addActionListener(this);
		
		offButton = new JButton("Off");
		offButton.setActionCommand("Off");
		offButton.addActionListener(panel);
		offButton.setEnabled(false);
		offButton.addActionListener(this);
		
		buttonPanel.add(onButton);
		buttonPanel.add(offButton);
		buttonPanel.add(laneSwitcher);
		buttonPanel.setBackground(Color.red);
		
		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);
	}
	
	public static void main(String[] args) {
		LaneApp l = new LaneApp();
		l.setSize(800,500);
		l.setVisible(true);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setResizable(false);
		
	}

	public void actionPerformed(ActionEvent ae) {
	if ("On".equals(ae.getActionCommand())){
		offButton.setEnabled(true);
		onButton.setEnabled(false);
		
	}
	else if ("Off".equals(ae.getActionCommand())){
		offButton.setEnabled(false);
		onButton.setEnabled(true);
	}
		
	}
	

	
   
    

}
