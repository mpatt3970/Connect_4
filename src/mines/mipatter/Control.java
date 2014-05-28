package mines.mipatter;

import javax.swing.JPanel;

public class Control extends JPanel {
	
	private JScore scoreBoard;
	
	public Control(GameBoard board) {
		scoreBoard = new JScore(board);
		this.add(scoreBoard);
	}
	
	public JScore getScoreBoard() {
		return scoreBoard;
	}
	
}
