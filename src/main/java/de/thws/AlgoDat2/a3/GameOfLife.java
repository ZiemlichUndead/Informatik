//Ueb 03b
package de.thws.AlgoDat2.a3;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameOfLife {

	public GameOfLife() {
		
		JFrame frame  = new JFrame("Game of Life");
		frame.setBounds(40, 40, 1050, 1065);
		
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		GameOfLifePanel panel = new GameOfLifePanel();
		frame.add(panel);
		frame.setVisible(true);
		
		Thread th = new Thread(panel);
		panel.run();
	}
	
	public static void main(String[] args) {
		
		GameOfLife c = new GameOfLife();


	}
}
