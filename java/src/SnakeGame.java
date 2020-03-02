public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks = 0;
    private static int recursiveChecks = 0;
    int liveCells;

    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] board, int x, int y) {
        game = new boolean[board.length][board[0].length];
        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game[r].length; c++) {
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

    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }

    public int[] findTailExhaustive() {
        int[] tailPosition = {-1, -1, 0};
        int snakeLength = 0;

        resetCounters();
        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game[r].length; c++) {
                exhaustiveChecks++;
                if (game[r][c]) {
                    snakeLength++;
                    if (liveCells(r, c) == 1 && (r != headPosition[0] && c != headPosition[1])) {
                        exhaustiveChecks--;
                        tailPosition[0] = r;
                        tailPosition[1] = c;
                    }
                    tailPosition[2] = snakeLength;
                }
            }
        }
        return tailPosition;
    }

    public int liveCells(int r, int c) {
        liveCells = 0;
        if ((r - 1 >= 0) && (r - 1 < game.length)) {    // checks bounds //
            if (game[r - 1][c] == true) {     // checks top row, middle column //
                liveCells++;
            }
        }

        if ((c - 1 >= 0) && (c - 1 < game[r].length)) {   // checks bounds //
            if (game[r][c - 1] == true) {     // checks left column //
                liveCells++;
            }
        }
        if (c + 1 < game[r].length) {     // checks bounds //
            if (game[r][c + 1] == true) {     // checks right column //
                liveCells++;
            }
        }

        if ((r + 1 >= 0) && (r + 1 < game.length)) {    // checks bounds //
            if (game[r + 1][c] == true) {     // checks bottom row, middle column //
                liveCells++;
            }
        }
        return liveCells;
    }

    public int[] liveCellsRecursive(int r, int c, int[] previousPosition) {
        int[] array = new int [2];

        if ((r - 1 >= 0) && (r - 1 < game.length) && previousPosition[0] != r - 1) {    // checks bounds //
            if (game[r - 1][c] == true) {     // checks top row, middle column //
                array[0] = r - 1;
                array[1] = c;
            }
        }
        if ((c - 1 >= 0) && (c - 1 < game.length) && previousPosition[1] != c - 1) {   // checks bounds //
            if (game[r][c - 1] == true) {     // checks left column //
                array[0] = r;
                array[1] = c - 1;
            }
        }
        if (c + 1 < game[r].length && previousPosition[1] != c + 1) {     // checks bounds //
            if (game[r][c + 1] == true) {     // checks right column //
                array[0] = r;
                array[1] = c + 1;
            }
        }

        if ((r + 1 >= 0) && (r + 1 < game.length) && previousPosition[0] != r + 1) {    // checks bounds //
            if (game[r + 1][c] == true) {     // checks bottom row, middle column //
                array[0] = r + 1;
                array[1] = c;
            }
        }
        return array;
    }

    public int[] findTailRecursive() {
        resetCounters();
        int [] tailPosition = new int [3];
        return findTailRecursive(headPosition, tailPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        int[] tailPosition = new int [3];
        if(currentPosition[0] == headPosition[0] && currentPosition[1] == headPosition[1]) {
            if(game.length == 1 && game[0].length == 1) {
                recursiveChecks++;
                tailPosition[0] = 0;
                tailPosition[1] = 0;
                tailPosition[2] = 1;
                return tailPosition;
            }
            previousPosition[2] = 1;
            recursiveChecks++;
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            return findTailRecursive(liveCellsRecursive(currentPosition[0], currentPosition[1], currentPosition), previousPosition);
        }
        else if (liveCells(currentPosition[0], currentPosition[1]) > 1) {
            previousPosition[2]++;
            tailPosition[0] = previousPosition[0];
            tailPosition[1] = previousPosition[1];
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            recursiveChecks++;
            return findTailRecursive(liveCellsRecursive(currentPosition[0], currentPosition[1], tailPosition), previousPosition);
        }
        else {
            recursiveChecks++;
            previousPosition[2]++;
            tailPosition[0] = currentPosition[0];
            tailPosition[1] = currentPosition[1];
            tailPosition[2] = previousPosition[2];
            return tailPosition;
        }
    }





// end class //
}



