import java.util.Stack;

public class KnightTour2 {

    /** tour method is where you add your code for implementing
    * a Knight Tour's solution for an n*n chess board
    * @param n size of the board
    * @return KnightBoard object with a valid Knight Tour
    */
    public static KnightBoard tour(int n){

      Stack<KnightBoard> candidates = new Stack<KnightBoard>();
      KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
      candidates.push(kb); // push the initial board onto the stack
      KnightBoard bestCandidate = kb; // keep track of the longest sequence of moves
      
      // keep iterating if we still have untested candidates
      while (!candidates.empty()) {

        // the most recently added board and its move count
        KnightBoard current = candidates.pop(); 
        int moveCount = current.getMoveCount(); 

        // the most recently added board is full, return the board
        if ((moveCount == 8 && n == 3) || moveCount == n * n) {
          return current;
        }

        // keep track of the board with the longest sequence of moves
        if (current.getMoveCount() > bestCandidate.getMoveCount()) {
          bestCandidate = current;
        }

        // copy the current board so we don't directly modify the current board
        KnightBoard candidate = current.copyBoard();
        int x = current.getCurrentX(); 
        int y = current.getCurrentY(); 

        // 1. check all the possible moves in clockwise direction
        // 2. if a move is valid, perform the move on a copy of the current board
        // 3. push the copy
        if (current.copyBoard().move(x + 1, y + 2)) {
          candidate = current.copyBoard();
          candidate.move(x + 1, y + 2);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x + 2, y + 1)) {
          candidate = current.copyBoard();
          candidate.move(x + 2, y + 1);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x + 2, y - 1)) {
          candidate = current.copyBoard();
          candidate.move(x + 2, y - 1);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x + 1, y - 2)) {
          candidate = current.copyBoard();
          candidate.move(x + 1, y - 2);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x - 1, y - 2)) {
          candidate = current.copyBoard();
          candidate.move(x - 1, y - 2);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x - 2, y - 1)) {
          candidate = current.copyBoard();
          candidate.move(x - 2, y - 1);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x - 2, y + 1)) {
          candidate = current.copyBoard();
          candidate.move(x - 2, y + 1);
          candidates.push(candidate);
        }
        if (current.copyBoard().move(x - 1, y + 2)) {
          candidate = current.copyBoard();
          candidate.move(x - 1, y + 2);
          candidates.push(candidate);
        }
      }

      // if a full board cannot be obtained, return the board with the longest sequence of moves
      return bestCandidate;
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
      KnightBoard winner = KnightTour2.tour(n);
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
      winner = KnightTour2.tour(n);
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
      winner = KnightTour2.tour(n);
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
      winner = KnightTour2.tour(n);
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
      winner = KnightTour2.tour(n);
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
      winner = KnightTour2.tour(n);
      endTime = System.nanoTime();
      delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}
