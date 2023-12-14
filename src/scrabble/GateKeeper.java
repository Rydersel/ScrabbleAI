package scrabble;

import java.util.ArrayList;

/**
 * Intermediary between a scrabble.ScrabbleAI and a scrabble.Board, allowing the former to get information it needs without allowing
 * full access.
 */
public class GateKeeper {

    /** The associated board. */
    private Board board;

    /** The scrabble.ScrabbleAI's player number (0 or 1). */
    private int player;

    /**
     * @param board The associated scrabble.Board.
     * @param player The scrabble.ScrabbleAI's player number (0 or 1).
     */
    public GateKeeper(Board board, int player) {
        this.board = board;
        this.player = player;
    }

    /**
     * Returns the square at location.
     *
     * @see Board
     */
    public char getSquare(Location location) {
        return board.getSquare(location);
    }

    /**
     * Throws an scrabble.IllegalMoveException if it is not legal to play word at location in direction given the scrabble.ScrabbleAI's
     * current hand. Has no effect otherwise. It is the scrabble.ScrabbleAI's responsibility to call this before calling
     * score or returning a move.
     */
    public void verifyLegality(String word, Location location, Location direction) throws IllegalMoveException {
        board.verifyLegality(word, location, direction, board.getHand(player));
    }

    /** Returns the score for playing word at location in direction. Assumes this is a legal play. */
    public int score(String word, Location location, Location direction) {
        return board.score(word, location, direction);
    }

    /** Returns a copy of the scrabble.ScrabbleAI's hand. */
    public ArrayList<Character> getHand() {
        return new ArrayList<Character>(board.getHand(player));
    }

    @Override
    public String toString() {
        return board.toString();
    }

}
