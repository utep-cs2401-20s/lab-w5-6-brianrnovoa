public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    int liveCells;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] board, int x, int y) {
        game = new boolean[board.length][board[0].length];
        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game[c].length; c++) {
                game[r][c] = board[r][c];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public int[] findTailExhaustive() {
        int[] tailPosition = new int[3];
        int snakeLength = 0;

        resetCounters();
        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game[r].length; c++) {
                exhaustiveChecks++;
                if (game[r][c]) {
                    snakeLength++;
                    if (liveCells(r, c) == 1 && (r != headPosition[0] && c != headPosition[1])) { // fix when head is found before all checks //
                        exhaustiveChecks--;
                        tailPosition[0] = r;
                        tailPosition[1] = c;
                        tailPosition[2] = snakeLength;
                        return tailPosition;
                    }
                }
            }
        }
        return tailPosition;
    }

    public int liveCells(int r, int c) {
        liveCells = 0;
        if ((r - 1 >= 0) && (r - 1 < game[r].length)) {    // checks bounds //
            if (game[r - 1][c] == true) {     // checks top row, middle column //
                liveCells++;
            }
        }

        if ((c - 1 >= 0) && (c - 1 < game.length)) {   // checks bounds //
            if (game[r][c - 1] == true) {     // checks left column //
                liveCells++;
            }
        }
        if (c + 1 < game[r].length) {     // checks bounds //
            if (game[r][c + 1] == true) {     // checks right column //
                liveCells++;
            }
        }

        if ((r + 1 >= 0) && (r + 1 < game[r].length)) {    // checks bounds //
            if (game[r + 1][c] == true) {     // checks bottom row, middle column //
                liveCells++;
            }
        }

        return liveCells;
    }





// end class //
}



