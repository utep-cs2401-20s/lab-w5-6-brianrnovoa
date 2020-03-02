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
        System.out.println("Tail X: " + testResults[0]);
        System.out.println("Tail Y: " + testResults[1]);
        System.out.println("Snake Length: " + testResults[2]);
        System.out.println("Checks: " + test.getExhaustiveChecks());

        System.out.println();

        SnakeGame test2 = new SnakeGame(board, 0, 2);
        int[] testResults2 = test.findTailRecursive();
        System.out.println("Tail X: " + testResults2[0]);
        System.out.println("Tail Y: " + testResults2[1]);
        System.out.println("Snake Length: " + testResults2[2]);
        System.out.println("Checks: " + test2.getRecursiveChecks());
    }
}
