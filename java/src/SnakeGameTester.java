import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {

    // boards to be tested //
    boolean[][] board1 = {
            {true}
    };

    boolean[][] board2 = {
            {true, false, false},
            {true, false, false},
            {true, true, false},

    };

    boolean[][] board3 = {
            {false, false, false},
            {false, false, false},
            {false, false, true},
    };

    boolean[][] board4 = {
            {false, true, false},
            {false, true, false},
            {false, true, false},
            {false, true, false},
            {false, true, false},
            {false, true, false},
    };

    boolean[][] board5 = {
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, true,  true,  true,  true,  true},
            {false, false, false, false, false, true},
            {false, false, false, false, false, true},
    };

    // findTailExhaustive tests //
    @Test
    public void findTailExhaustive1() {                     // this test is to ensure it works on a default 1x1 board //
        SnakeGame test = new SnakeGame(board1, 0, 0);   // i chose it because the program should be able to handle any size board given, assuming it's full //
        test.findTailExhaustive();                              // expected output is to be: -1, -1, 0 since -1 are the default values when no tail is found and 1 is the length //
        int[] results = {-1, -1, 1};                                // the test passed since this was technically the head, not the tail //
        test.liveCells(0,0);
        assertArrayEquals(results,test.findTailExhaustive());
        assertEquals(1, test.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive2() {                     // this test is to ensure that the program can handle a regular, full board //
        SnakeGame test = new SnakeGame(board2, 0, 0);   // i chose to test a regular board because it is the first step in ensuring that the program can handle a full board //
        test.findTailExhaustive();                                 // expected output is to be: 2, 2, 5 since the head is at 0, 0, the tail must not be there, and the length is of course 5 //
        int[] results = {2, 1, 4};                                      // the test passed since the tail != head and it gives the correct length/checks //
        assertArrayEquals(results, test.findTailExhaustive());
        assertEquals(8, test.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive3() {                     // this test is to see what would happen if the snake was only one cell and was at the end //
        SnakeGame test = new SnakeGame(board3, 2, 2);   // i chose this to ensure that it would go through the whole array and was able to determine if it was the tail or not //
        test.findTailExhaustive();                              // expected output is to be: -1, -1, 1, since the head is at 2,2, then there is no other cell for a tail, the length is still one //
        int[] results = {-1, -1, 1};                                // the test passed since it went through the whole array and determined it had no tail and gave the right length/checks //
        assertArrayEquals(results, test.findTailExhaustive());
        assertEquals(9, test.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive4() {                     // this test is to see if the program can find the tail if the snake is just vertical and in the middle //
        SnakeGame test = new SnakeGame(board4, 0, 1);   // i chose this because a vertical snake is a possibility and i wanted to see how the program would handle it //
        test.findTailExhaustive();                              // expected output is to be: 5, 1, 6, since the head is at 0,1 and the length of it would be 6 //
        int[] results = {5, 1, 6};                                  // the test passed since it the tail != the head and the length/checks were correct //
        assertArrayEquals(results, test.findTailExhaustive());
        assertEquals(17, test.getExhaustiveChecks());
    }

    @Test
    public void findTailExhaustive5() {                     // this test is to test a bigger board and make it go through all of it //
        SnakeGame test = new SnakeGame(board5, 3, 1);  // although the board isn't crazy big, i wanted to make sure the program could handle a bigger board //
        test.findTailExhaustive();                             // expected output is to be: 5, 5, 36, since the tail is at the very end of the array //
        int[] results = {5, 5, 7};                                 // the test passed since it went through the whole array and had the correct x,y plus the checks //
        assertArrayEquals(results, test.findTailExhaustive());
        assertEquals(36, test.getExhaustiveChecks());
    }


    //recursive tests //
    @Test
    public void findTailRecursive1() {                     // this test is to ensure it works on a default 1x1 board //
        SnakeGame test = new SnakeGame(board1, 0, 0);   // i chose it because the program should be able to handle any size board given, assuming it's full //
        test.findTailRecursive();                              // expected output is to be: 0, 0, 1 since it starts at the head //
        int[] results = {0, 0, 1};                                // the test passed since its the head/tail //
        test.liveCells(0,0);
        assertArrayEquals(results,test.findTailRecursive());
        assertEquals(1, test.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive2() {                     // this test is to ensure that the program can handle a regular, full board //
        SnakeGame test = new SnakeGame(board2, 0, 0);   // i chose to test a regular board because it is the first step in ensuring that the program can handle a full board //
        test.findTailRecursive();                                 // expected output is to be: 2, 1, 4 since the head is at 0, 0, the tail must not be there, and the length is of course 4 //
        int[] results = {2, 1, 4};                                      // the test passed since the tail != head and it gives the correct length/checks //
        assertArrayEquals(results, test.findTailRecursive());
        assertEquals(4, test.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive3() {                     // this test is to see what would happen if the snake was only one cell and was at the end //
        SnakeGame test = new SnakeGame(board3, 2, 2);   // i chose this to ensure that it would go through the whole array and was able to determine if it was the tail or not //
        test.findTailRecursive();                              // expected output is to be: -1, -1, 1, since the head is at 2,2, then there is no other cell for a tail, the length is still one //
        int[] results = {-1, -1, 1};                                // the test passed since it went through the whole array and determined it had no tail and gave the right length/checks //
        assertArrayEquals(results, test.findTailRecursive());
        assertEquals(1, test.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive4() {                     // this test is to see if the program can find the tail if the snake is just vertical and in the middle //
        SnakeGame test = new SnakeGame(board4, 0, 1);   // i chose this because a vertical snake is a possibility and i wanted to see how the program would handle it //
        test.findTailRecursive();                              // expected output is to be: 5, 1, 6, since the head is at 0,1 and the length of it would be 6 //
        int[] results = {5, 1, 6};                                  // the test passed since it the tail != the head and the length/checks were correct //
        assertArrayEquals(results, test.findTailRecursive());
        assertEquals(6, test.getRecursiveChecks());
    }

    @Test
    public void findTailRecursive5() {                     // this test is to test a bigger board and make it go through all of it //
        SnakeGame test = new SnakeGame(board5, 3, 1);  // although the board isn't crazy big, i wanted to make sure the program could handle a bigger board //
        test.findTailRecursive();                             // expected output is to be: 5, 5, 36, since the tail is at the very end of the array //
        int[] results = {5, 5, 7};                                 // the test passed since it went through the whole array and had the correct x,y plus the checks //
        assertArrayEquals(results, test.findTailRecursive());
        assertEquals(7, test.getRecursiveChecks());
    }




}
