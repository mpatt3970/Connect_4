package mines.mipatter;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class JScore extends JPanel {
	
	JTextField scoreTitle, turnTitle, score, turn;
	
	
	public JScore(GameBoard board) {
		
		this.setLayout(new GridLayout(0, 2));
		this.setBorder(new TitledBorder("Current Game"));
		scoreTitle = new JTextField("Score (G -- R)");
		scoreTitle.setEditable(false);
		turnTitle = new JTextField("Turn");
		turnTitle.setEditable(false);
		score = new JTextField();
		score.setEditable(false);
		turn = new JTextField();
		turn.setEditable(false);
		updateScore(board);
		updateTurn(board);
		this.add(scoreTitle);
		this.add(score);
		this.add(turnTitle);
		this.add(turn);
	}
	
	public void updateScore(GameBoard current) {
		String result = current.getScore(1) + " -- " + current.getScore(2);
		score.setText(result);
	}
	
	public void updateTurn(GameBoard current) {
		String result = "";
		// player 1 will be green
		if (current.getCurrentTurn() == 1) {
			result = "Green's Turn";
		} else {
			result = "Red's Turn";
		}
		turn.setText(result);
	}
}
