package mines.mipatter;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GUI extends JFrame {
	public static final int SIZE_X = 500;
	public static final int SIZE_Y = 600;
	public static final int CONTROL_HEIGHT = 95;
	
	private GameBoard board;
	
	public GUI(GameBoard board) {
		this.board = board;
		this.add(new Interactive(board), BorderLayout.CENTER);
		this.add(new Control(board), BorderLayout.SOUTH);
		this.setSize(SIZE_X, SIZE_Y);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
