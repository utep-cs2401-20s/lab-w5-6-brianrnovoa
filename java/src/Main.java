public class Main {
    public static void main(String[] args) {
        boolean[][] board ={
                {false, false, true},
                {false, false, true},
                {false, false, true},
                {false, false, true},
                {false, true, true},
        };


        SnakeGame test = new SnakeGame(board, 0, 2);
        int[] testResults = test.findTailExhaustive();
        System.out.println("X: " + testResults[0]);
        System.out.println("Y: " + testResults[1]);
        System.out.println("Snake Length: " + testResults[2]);

    }
}
