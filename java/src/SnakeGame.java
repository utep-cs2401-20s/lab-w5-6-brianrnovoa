public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    int liveCells;

    public SnakeGame() {
        game = new boolean [1][1];
    }

    public SnakeGame(boolean[][] game, int x, int y) {

    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public int[] findTailExhaustive() {
        int[] tailPosition = new int[3];
        int snakeLength = 0;
        // reset counters + exhaustive checks //
        resetCounters();
        for(int r = 0; r < game.length; r++ ) {
            for(int c = 0; c < game[r].length; c++) {
                if(game[r][c] == true) {
                    snakeLength++;
                    if (liveCells(r, c) <= 1) {
                        tailPosition[0] = r;
                        tailPosition[1] = c;
                        tailPosition[2] = snakeLength;
                        return tailPosition;
                    }
                }
                exhaustiveChecks++;
            }
        }
        return tailPosition;
    }

    public int liveCells(int r, int c) {
        // top row //
        liveCells = 0;
        if (r - 1 >= 0 && r - 1 < game.length) {    // checks bounds //
            if (game[r - 1][c] == true) {     // checks top row, middle column //
                liveCells++;
            }
        }

        // same row //
        if (c - 1 >= 0 && c - 1 < game.length) {   // checks bounds //
            if (game[r][c - 1] == true) {     // checks left column //
                liveCells++;
            }
        }
        if (c + 1 < game.length &&  r + 1 < game[r].length) {     // checks bounds //
            if (game[r][c + 1] == true) {     // checks right column //
                liveCells++;
            }
        }

        // bottom row //
        if (r + 1 >= 0 && r + 1 < game.length) {    // checks bounds //
            if (game[r + 1][c] == true) {     // checks bottom row, middle column //
                liveCells++;
            }
        }
        return liveCells;
    }

}



