//Ueb 03a
package de.thws.AlgoDat2.a3;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class CellAutomat {

	public CellAutomat() {
		
		JFrame frame  = new JFrame("Zellulaerer Automat");
		frame.setBounds(40, 40, 1050, 1065);
		
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		CellAutomatPanel panel = new CellAutomatPanel();
		frame.add(panel);
		frame.setVisible(true);
		
		Thread th = new Thread(panel);
		panel.run();
	}
	
	public static void main(String[] args) {
		
		CellAutomat c = new CellAutomat();
	}
}
