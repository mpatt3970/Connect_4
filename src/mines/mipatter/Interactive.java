package mines.mipatter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Interactive extends JComponent implements MouseListener {

	private GUI gui;
	private GameBoard current;
	private int blockHeight, blockWidth;
	private CursorTools cursors;

	public Interactive(GameBoard board, GUI gui) {
		this.gui = gui;
		this.current = board;
		blockWidth  = GUI.SIZE_X/maxconnect4.COLS;
		blockHeight = (GUI.SIZE_Y - GUI.CONTROL_HEIGHT)/maxconnect4.ROWS;
		this.addMouseListener(this);
		cursors = new CursorTools();
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		cursors.startWaitCursor(this);
		int x = arg0.getX();
		for (int i = 1; i <= maxconnect4.COLS; i ++) {
			if (x < i*blockWidth) {
				if (current.isValidPlay(i - 1)) {
					current.playPiece(i - 1);
					if (current.getPieceCount() < 42) {
						AiPlayer calculon = new AiPlayer();
						int col = calculon.findBestPlay(current);
						current.playPiece(col);
						gui.getControl().getScoreBoard().updateScore(current);
						gui.getControl().getScoreBoard().updateTurn(current);
						repaint();
					}
				} else {
					System.out.println("Make a valid play");
				}
				break;
			}
		}
		cursors.stopWaitCursor(this);
	}

	// not needed
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
