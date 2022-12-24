/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
DAVID CHEN */

import java.util.Stack;

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

public class KnightTour {
    // define all possible movements

    // public static final int[] MOVE1 = {1, -2};
    // public static final int[] MOVE2 = {2, -1};
    // public static final int[] MOVE3 = {2, 1};
    // public static final int[] MOVE4 = {1, 2};
    // public static final int[] MOVE5 = {-1, 2};
    // public static final int[] MOVE6 = {-2, 1};
    // public static final int[] MOVE7 = {-2, -1};
    // public static final int[] MOVE8 = {-1, -2};
    // 0.37, 5.37, 0.08, 9.62, 7832.27, 2392.27

    // public static final int[] MOVE7 = {1, -2};
    // public static final int[] MOVE8 = {2, -1};
    // public static final int[] MOVE1 = {2, 1};
    // public static final int[] MOVE2 = {1, 2};
    // public static final int[] MOVE3 = {-1, 2};
    // public static final int[] MOVE4 = {-2, 1};
    // public static final int[] MOVE5 = {-2, -1};
    // public static final int[] MOVE6 = {-1, -2};
    // 0.38, 5.34, 13.32, 171.63, 4319.83, 4941.84

    public static final int[] MOVE5 = {1, -2};
    public static final int[] MOVE6 = {2, -1};
    public static final int[] MOVE7 = {2, 1};
    public static final int[] MOVE8 = {1, 2};
    public static final int[] MOVE1 = {-1, 2};
    public static final int[] MOVE2 = {-2, 1};
    public static final int[] MOVE3 = {-2, -1};
    public static final int[] MOVE4 = {-1, -2};
    // 0.37, 5.45, 18.39, 48.45, 14.98, 17318.41


    // NOTE: There can be several distinct valid tours; your job is to find
    // and print only one valid tour (the first valid one you discover).
    // Please do NOT attempt to discover all possible valid tours! To get
    // a sense of how many valid board configurations exist for different
    // board sizes, see "The Knight's Paths" table here:
    // http://www.behnel.de/knight.html

    /** tour method is where you add your code for implementing
    * a Knight Tour's solution for an n*n chess board
    * @param n size of the board
    * @return KnightBoard object with a valid Knight Tour
    */
    public static KnightBoard tour(int n){
      // Your solution must utilize the stack "candidates" below,
      // to keep track of different possible sequences of Knight moves
      Stack<KnightBoard> candidates = new Stack<KnightBoard>();
      KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
      candidates.push(kb); // push the initial board onto the stack

      // Create a second stack to keep track of each candidate's moves
      Stack<Integer> trackMoves = new Stack<>();
      trackMoves.push(0); // it does not take any move to get to the first KnightBoard
      trackMoves.push(1); // we start by testing if MOVE1 is a valid move for the first KnightBoard

      // Declare two variables
      // "current" represents the most recently pushed KnightBoard
      // "candidate" is a copy of "current" where different moves will be tested on
      KnightBoard candidate, current;

      // Keep track of the longest sequence of moves 
      KnightBoard bestCandidate = kb;
      int maxNumMoves = 1;

      while (!candidates.empty()) {

        current = candidates.peek();

        // if the least recently added KnightBoard is full, return the KnightBoard
        if ((n == 3 && current.getMoveCount() == 8) || current.getMoveCount() == n * n) {
          return current;
        }

        // if the least recently added KnightBoard is not full, copy the KnightBoard to "candidate"
        candidate = current.copyBoard();


        // keep track of the longest sequence of moves
        if (candidate.getMoveCount() > maxNumMoves) {
          bestCandidate = candidate.copyBoard();
          maxNumMoves = bestCandidate.getMoveCount();
        }

        // for each candidate, always start by testing the move next to the one previously being tested
        int currentMove = trackMoves.pop();

        // if the move is valid, push the "candidate" into "candidates" and "currentMove" into "trackMoves"
        // else if the move is not valid, test the next possible move
        // else, do not push the candidate and tell the previous candidate to test the next move
        if (performMove(candidate, currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else if (performMove(candidate, ++currentMove)) {
          candidates.push(candidate);
          trackMoves.push(currentMove);
          trackMoves.push(1);
        }
        else {
          candidates.pop();
          trackMoves.push(trackMoves.pop() + 1);
        }
      }

      // if all possible sequences have been explored, return the longest sequence
      candidates.push(bestCandidate);
      return candidates.peek(); 
    }

    // Take as parameter a KnightBoard object and a second parameter that specifies the movement to be performed
    // return true if the movement is successfully performed and false otherwise
    public static boolean performMove(KnightBoard kb, int move) {
      int x = kb.getCurrentX();
      int y = kb.getCurrentY();
      if (move == 1) {
        x += MOVE1[0];
        y += MOVE1[1];
      }
      else if (move == 2) {
        x += MOVE2[0];
        y += MOVE2[1];
      }
      else if (move == 3) {
        x += MOVE3[0];
        y += MOVE3[1];
      }
      else if (move == 4) {
        x += MOVE4[0];
        y += MOVE4[1];
      }
      else if (move == 5) {
        x += MOVE5[0];
        y += MOVE5[1];
      }
      else if (move == 6) {
        x += MOVE6[0];
        y += MOVE6[1];
      }
      else if (move == 7) {
        x += MOVE7[0];
        y += MOVE7[1];
      }
      else if (move == 8) {
        x += MOVE8[0];
        y += MOVE8[1];
      }
    
      return kb.move(x, y);
    }



    // Do NOT modify this main method. If you need to add code for
    // testing your solution, just make sure to comment it out before submission
    public static void main(String[] args) {
      int n = 3; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      long startTime = System.nanoTime();
      KnightBoard winner = KnightTour.tour(n);
      long endTime = System.nanoTime();
      double delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");

      n = 4; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      startTime = System.nanoTime();
      winner = KnightTour.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");

      n = 5; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      startTime = System.nanoTime();
      winner = KnightTour.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");

      n = 6; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      startTime = System.nanoTime();
      winner = KnightTour.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");

      n = 7; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      startTime = System.nanoTime();
      winner = KnightTour.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");

      n = 8; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      startTime = System.nanoTime();
      winner = KnightTour.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
      
      // KnightBoard winner2 = KnightTour.tour(4);
      // winner2.printChessBoard();
      // KnightBoard winner3 = KnightTour.tour(5);
      // winner3.printChessBoard();
      // KnightBoard winner4 = KnightTour.tour(6);
      // winner4.printChessBoard();
      // KnightBoard winner5 = KnightTour.tour(5);
      // winner5.printChessBoard();
      // KnightBoard winner6 = KnightTour.tour(2);
      // winner6.printChessBoard();
      // KnightBoard winner7 = KnightTour.tour(7);
      // winner7.printChessBoard();
      // KnightBoard winner8 = KnightTour.tour(8);
      // winner8.printChessBoard();
    }
}
