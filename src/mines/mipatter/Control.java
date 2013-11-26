package mines.mipatter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Control extends JPanel {
	
	public Control(GameBoard board) {
		this.add(new JButton("Restart Game"));
		this.add(new JScore(board));
	}
	
}
