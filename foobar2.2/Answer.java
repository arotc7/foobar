import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Answer {
  public static void main(String[] args) {
    int answer = Answer.answer(18, 35);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(0, 1);
    System.out.println("Answer should be 3, was: " + answer);

    answer = Answer.answer(18, 8);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(16, 10);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(23, 13);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(23, 6);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(23, 38);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(23, 29);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(23, 25);
    System.out.println("Answer should be 3, was: " + answer);

    answer = Answer.answer(39, 29);
    System.out.println("Answer should be 1, was: " + answer);

    answer = Answer.answer(39, 9);
    System.out.println("Answer should be 3, was: " + answer);
  }

  public static int answer(int src, int dest) {
    // These are used for checking the sides of the board
    int lengthFromLeft = (src % 8);
    int lengthFromRight = 7 - (src % 8);

    // A list of the directions that you can move in
    int[] directions = new int[]{-17,-15, -10, -6, 6, 10, 15, 17};

    // Keep track of the amount of moves that we make
    int moves = 0;
    // This will be used to keep track of when we need
    // to increment moves. After the iteration where it equals 0
    // we will have to increment
    int itemsAdded = 0;

    Queue<Integer> positionsToCheck = new LinkedList<>();
    Set<Integer> checked = new HashSet<>();
    positionsToCheck.add(src);
    itemsAdded++;

    // Continue checking while there are still more positions to check
    while(positionsToCheck.size() != 0) {
      int currentPosition = positionsToCheck.remove();
      checked.add(currentPosition);

      // Check if the current position is where we want to be
      if(currentPosition == dest) {
        return moves;
      }

      // Need to add the next iteration of moves possible
      for(int i = 0; i < directions.length; i++) {
        int newPosition = currentPosition + directions[i];
        // Need to check distance from left and right for the current position
        lengthFromLeft = (newPosition % 8);
        lengthFromRight = 7 - (newPosition % 8);

        // Need to make sure that it doesn't overlap the top or the bottom
        // of the board
        if(newPosition >= 0 && newPosition <= 63 && !checked.contains(newPosition)) {
          // Need to make sure that it doesn't overlap the sides of the board
          if((newPosition % 8) - (currentPosition % 8) <= 2 && (currentPosition % 8) - (newPosition % 8) <= 2) {

            // If this is the position you're looking for, you're done!
            if(newPosition == dest) {
              // Need to return + 1 because you're searching through the problem
              // plus 1 possible answer space
              return moves + 1;
            }

            // If it hasn't been added to the positions that need to be checked
            if(!positionsToCheck.contains(newPosition)) {
              positionsToCheck.add(newPosition);
            }
          }
        }
      }

      itemsAdded--;
      // When you run out of the items that are n away, you need to search through
      // the ones that are n+1 away
      if(itemsAdded == 0) {
        moves++;
        // This the is amount of positions that are n+1 away
        itemsAdded = positionsToCheck.size();
      }
    }
    return -1;
  }
}
