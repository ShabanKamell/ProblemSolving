package challenges.cracking_coding_interview.object_oriented_design.othello

/**
 * Othello: Othello is played as follows: Each Othello piece is white on one side and black on the other.
 * When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom,
 * it is said to be captured and its color is flipped. On your turn, you must capture at least one of
 * your opponent's pieces. The game ends when either user has no more valid moves.
 * The win is assigned to the person with the most pieces. Implement the object-oriented design for Othello.
 */
object Question {
    @JvmStatic
    fun main(args: Array<String>) {
        Game.board.initialize()
        Game.board.printBoard()
        while (!Automator.isOver && Automator.playRandom()) {
        }
        Automator.printScores()
    }
}