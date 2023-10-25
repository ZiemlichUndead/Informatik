//Ueb 03a
package de.thws.AlgoDat2.a3;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CellAutomatPanel extends JPanel implements Runnable {

	private int speed = 2;
	private Random rand = new Random();

	int[][] matrix = new int[100][100];

	public CellAutomatPanel() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(i == 0 || i == matrix.length-1 || j == 0 || j == matrix.length-1){
					matrix[i][j] = 1;
				}else{
					if(rand.nextInt(100) < 10){
						matrix[i][j] = 1;
					}
				}
			}
		}


	}

	@Override
	public void run() {

		int[][] matrix_tmp = new int[100][100];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix_tmp[i][j] = matrix[i][j];
			}
		}

		while(true){

			try {				Thread.sleep(100);			} catch (InterruptedException e) { e.printStackTrace(); }

			for (int x = 1; x < matrix.length-1; x++) {
				for (int y = 1; y < matrix[x].length-1; y++) {
					int adjacent = getAdjacentBlacks(x, y);

					if(adjacent == 3){
						matrix_tmp[x][y] = 1;
					}
					if(adjacent < 2 || adjacent > 3){
						matrix_tmp[x][y] = 0;
					}

//					if (adjacent == -1) {
//						continue;
//					}
//					if (adjacent > 4) {
//						matrix_tmp[x][y] = 1;
//					}
//					if (adjacent < 4) {
//						matrix_tmp[x][y] = 0;
//					}
				}
			}
			matrix = matrix_tmp;
			repaint();
		}
	}

	public int getAdjacentBlacks(int x, int y){
		int adjacents = 0;
//		if(x == 0 || y == 0 || x == matrix.length-1 || y == matrix.length-1){
//			return -1;
//		}
		if(matrix[x+1][y] == 1){ //right
			adjacents++;
		}
		if(matrix[x-1][y] == 1){ //left
			adjacents++;
		}
		if(matrix[x][y+1] == 1){ //down
			adjacents++;
		}
		if(matrix[x][y-1] == 1){ //up
			adjacents++;
		}
		if(matrix[x+1][y+1] == 1){ //right-down
			adjacents++;
		}
		if(matrix[x-1][y+1] == 1){ //left-down
			adjacents++;
		}
		if(matrix[x-1][y-1] == 1){ //left-up
			adjacents++;
		}
		if(matrix[x+1][y-1] == 1){ //right-up
			adjacents++;
		}
		return adjacents;
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
