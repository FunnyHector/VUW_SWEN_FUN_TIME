package stratego.util;

import stratego.Game;
import stratego.Game.Direction;

/**
 * Represents an (x,y) position on the game board.
 * 
 * @author David J. Pearce
 * 
 */
public final class Position {
	private final int x;
	private final int y;
	
	/**
	 * Construct a position on the board
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculate a relative position after moving a number of steps in a given
	 * direction from a starting point.
	 * 
	 * @param position
	 *            --- Starting position
	 * @param direction
	 *            --- Direction to move in
	 * @param steps
	 *            --- Number of steps to take
	 * @return
	 */
	public Position(Position origin, Direction direction, int steps) {
		int x = origin.getX();
		int y = origin.getY(); 
		switch (direction) {
		case NORTH:
			y += steps;
			break;
		case SOUTH:
			y -= steps;
			break;
		case EAST:
			x += steps;
			break;
		case WEST:
			x -= steps;
			break;
		}
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isValidPosition(Game game){
	    if (x < 0 || x >= game.getWidth() || y < 0 || y >= game.getHeight()) {
	        return false;
	    }
	    return true;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
