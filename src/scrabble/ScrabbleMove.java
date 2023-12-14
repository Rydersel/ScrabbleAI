package scrabble;

/** A move played by a scrabble.ScrabbleAI. Used mainly as the return type of scrabble.ScrabbleAI.chooseMove(). */
public interface ScrabbleMove {

    /**
     * Plays this move on board for the indicated player. Returns the location and direction of the move if relevant,
     * null otherwise.
     */
    public Location[] play(Board board, int playerNumber) throws IllegalMoveException;

}
