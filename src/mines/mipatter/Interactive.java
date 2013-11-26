package mines.mipatter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Interactive extends JComponent {

	private GameBoard current;
	private int blockHeight, blockWidth, radius;


	public Interactive(GameBoard board) {
		this.current = board;
		blockWidth  = GUI.SIZE_X/maxconnect4.COLS;
		blockHeight = (GUI.SIZE_Y - GUI.CONTROL_HEIGHT)/maxconnect4.ROWS;
		if (blockWidth > blockHeight) {
			radius = blockHeight;
		} else {
			radius = blockWidth;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// get the current 2d array
		int[][] status = current.getGameBoard();
		g.setColor(Color.blue);
		g.fillRect(0, 0, GUI.SIZE_X, GUI.SIZE_Y);
		for (int row = 0; row < maxconnect4.ROWS; row++) {
			for (int col = 0; col < maxconnect4.COLS; col++) {
				g.setColor(Color.yellow);
				g.drawRect(col*blockWidth, row*blockHeight, blockWidth, blockHeight);
				System.out.println("status " + status[row][col]);
				switch(status[row][col]) {
				case 0:
					break;
				case 1:
					g.setColor(Color.green);
					g.fillOval(col*blockWidth, row*blockHeight, blockWidth, blockHeight);
					break;
				case 2:
					g.setColor(Color.red);
					g.fillOval(col*blockWidth, row*blockHeight, blockWidth, blockHeight);
					break;
				default:
					System.out.println("Not a entry at row: " + row + ", column: " + col);
					break;
				}
			}
		}
		
	}

}
