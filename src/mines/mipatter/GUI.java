package mines.mipatter;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GUI extends JFrame {
	public static final int SIZE_X = 500;
	public static final int SIZE_Y = 550;
	public static final int CONTROL_HEIGHT = 95;
	
	private GameBoard board;
	private Control control;
	
	public GUI(GameBoard board) {
		this.board = board;
		this.add(new Interactive(board, this), BorderLayout.CENTER);
		control = new Control(board);
		this.add(control, BorderLayout.SOUTH);
		this.setSize(SIZE_X, SIZE_Y);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public Control getControl() {
		return control;
	}
	
}
