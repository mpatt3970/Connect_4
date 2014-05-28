package mines.mipatter;
import java.util.Random;

/**
 * This is the AiPlayer class.  It simulates a minimax player for the max
 * connect four game.
 * The constructor essentially does nothing. 
 * 
 * @author james spargo
 *
 */

public class AiPlayer 
{
	private int depth;

	/**
	 * Creates a player with a depth level
	 *
	 */
	public AiPlayer() 
	{
		this.depth = 5;
	}

	public AiPlayer(int depth) {
		this.depth = depth;
	}

	/**
	 * This method plays a piece randomly on the board
	 * @param currentGame The GameBoard object that is currently being used to
	 * play the game.
	 * @return an integer indicating which column the AiPlayer would like
	 * to play in.
	 */
	public int findBestPlay( GameBoard currentGame ) 
	{
		int playChoice = 0;
		if (currentGame.getCurrentTurn() == 1) {
			int v = 1000000000;
			for (int i = 0; i < maxconnect4.COLS; i ++) {
				if (currentGame.isValidPlay(i)) {
					GameBoard nextGame = new GameBoard(currentGame.getGameBoard());
					nextGame.playPiece(i);
					int value = Max(nextGame, depth, -1000000000, 1000000000);
					if (v > value) {
						playChoice = i;
						v = value;
					}
				}
			}
		} else {
			int v = -1000000000;
			for (int i = 0; i < maxconnect4.COLS; i++) {
				if (currentGame.isValidPlay(i)) {
					GameBoard nextGame = new GameBoard(currentGame.getGameBoard());
					nextGame.playPiece(i);
					int value = Min(nextGame, depth, -1000000000, 1000000000);
					if (v < value) {
						playChoice = i;
						v = value;
					}
				}
			}
		}
		return playChoice;
	}
	
	public int Max(GameBoard currentGame, int depthLevel, int alpha, int beta) {
		// assume this is player 2.
		// terminal utility is player2_score - player1_scor
		if (currentGame.getPieceCount() < 42 && depthLevel > 0) {
			int v = -1000000000;
			for (int i = 0; i < maxconnect4.COLS; i ++) {
				if (currentGame.isValidPlay(i)) {
					GameBoard nextGame = new GameBoard(currentGame.getGameBoard());
					nextGame.playPiece(i);
					int value = Min(nextGame, depthLevel - 1, alpha, beta);
					if (v < value) {
						v = value;
					}
					if (v >= beta) {
						System.out.println("Pruned: v = " + v + ", beta = " + beta);
						return v;
					}
					if (alpha < v) {
						alpha = v;
					}
				}
			}
			return v;
		} else {
			// this is a terminal state
			return currentGame.getScore(2) - currentGame.getScore(1);
		}
	}

	public int Min(GameBoard currentGame, int depthLevel, int alpha, int beta) {
		// assume this is player 1
		// terminal utility is player2_score - player1_score
		if (currentGame.getPieceCount() < 42 && depthLevel > 0) {
			int v = 1000000000;
			for (int i = 0; i < maxconnect4.COLS; i ++) {
				if (currentGame.isValidPlay(i)) {
					GameBoard nextGame = new GameBoard(currentGame.getGameBoard());
					nextGame.playPiece(i);
					int value = Max(nextGame, depthLevel - 1, alpha, beta);
					if (v > value) {
						v = value;  			
					}
					if (v <= alpha) {
						System.out.println("Pruned: v = " + v + ", alpha = " + alpha);
						return v;
					}
					if (beta > v) {
						beta = v;
					}
				}
			}
			return v;
		} else {
			// this is a terminal state
			return currentGame.getScore(2) + - currentGame.getScore(1);
		}
	}
}
