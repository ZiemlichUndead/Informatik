//Ueb 03b
package de.thws.AlgoDat2.a3;


import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GameOfLifePanel extends JPanel implements Runnable {

    private Random rand = new Random();
    
    int[][] matrix = new int[100][100]; 
    
    public GameOfLifePanel() {

	/**
	 * Bitte fügen Sie Ihren Code zum Starten des Automaten hier ein.
	 */

    }
    
	@Override
	public void run() {

	    int[][] matrix_tmp = new int[100][100];
	    for(int i = 0; i < matrix.length; i++) {
	    	for(int j = 0; j < matrix.length; j++) {
	    		matrix_tmp[i][j] = matrix[i][j];
	    	}
	    }
	    
		while(true) {
	        
	        try { Thread.sleep(250); 
	        } catch (InterruptedException e) { e.printStackTrace(); }
			
		/**
		 * Bitte fügen Sie Ihren Code zum Implementieren der Automatenregeln hier ein
		 */
	        
	    	matrix = matrix_tmp;
	        repaint();
		}
	}

    @Override
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        int ypos = 10;
        
        for(int a = 0; a < matrix.length; a++) {
        	
            int xpos = 20;
        	
            for(int b = 0; b < matrix[a].length; b++) {
            	
            	if(matrix[a][b] == 0) {
            	
                    g.setColor(Color.gray);
            		g.drawRect(xpos, ypos, 10, 10);
            		
            	} else {
            		
            		g.setColor(Color.black);
            		g.fillRect(xpos, ypos, 10, 10);
            	}
            	
            	xpos += 10;
            }
            ypos += 10;
        }
    }
}
