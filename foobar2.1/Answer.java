/**
  SUCCESSFULLY SOLVE GEARING UP FOR DESTRUCTION IN JAVA (FOOBAR2)
**/
public class Answer {
  public static void main(String args[]) {
    int[] answer = Answer.answer(new int[]{1, 77, 104, 161});
    System.out.println("Should be: 212/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{7, 32, 50, 72});
    System.out.println("Should be: 58/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 51});
    System.out.println("Should be: 100/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 52});
    System.out.println("Should be: 34/1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 53});
    System.out.println("Should be: 104/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 54});
    System.out.println("Should be: 106/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 5, 20});
    System.out.println("Should be: -1/-1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 15, 20});
    System.out.println("Should be: -1/-1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{4, 59});
    System.out.println("Should be: 110/3");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{1, 28});
    System.out.println("Should be: 18/1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{4, 30, 50});
    System.out.println("Should be: 12/1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);

    answer = Answer.answer(new int[]{4, 17, 50});
    System.out.println("Should be: -1/-1");
    System.out.println("Was: " + answer[0] + "/" + answer[1]);
  }

  public static int[] answer(int[] pegs) {
    // Check if it is even possible first
    if(pegs.length > 2) {
      // The maximum radius of the first peg is the distance between the
      // first two pegs - 1
      int maxFirstRadius = pegs[1] - pegs[0] - 1;

      // The distance between the last two is only as big as the maximum distance
      // between the last three gears
      int minLastRadius = (pegs[pegs.length - 1] - pegs[pegs.length - 2]) - (pegs[pegs.length - 2] - pegs[pegs.length - 3]) - 1;

      // No possible configuration that will solve the problem
      if(maxFirstRadius < 2 * minLastRadius) {
        return new int[]{-1, -1};
      }
    }

    // Start the radii off at their minimum
    int firstRadius = 1;
    int lastRadius = 0;
    int currentRadius = 1;

    boolean foundConfiguration = false;

    // Start by finding a valid configuration where the gears fit
    while(!foundConfiguration) {
      currentRadius = firstRadius;
      for(int i = 1; i < pegs.length; i++) {
        currentRadius = pegs[i] - (pegs[i - 1] + currentRadius);

        // If we aren't at the last one, make sure that this radius can
        // work with the placement of the next gear. If not, this radius
        // does not build a valid configuration
        if(i < pegs.length - 1) {
          if(pegs[i] + currentRadius >= pegs[i+1] - 1) {
            break;
          }
        } else {
          // You've found a configuration where the gears fit and set the last
          // radius to be the current radius
          foundConfiguration = true;
          lastRadius = currentRadius;
        }
      }
      // If there is a found configuration don't increment the first radius
      if(!foundConfiguration) {
        firstRadius++;
      }

      // If the first radius gets too large, this is not a valid configuration
      if(firstRadius + pegs[0] > pegs[1] - 1) {
        return new int[]{-1, -1};
      }
    }

    // The gear sizes are linearly related. When there are an odd number and
    // an even number, they behave differently.
    if(pegs.length % 2 == 1) {

      // Solve firstRadius + x = 2*(lastRadius + x)
      int x = firstRadius - (2 * lastRadius);
      // Add x to both sides since they are directly related
      firstRadius += x;
      lastRadius += x;

      // If this doesn't solve it, this configuration cannot work
      if(firstRadius != (2 * lastRadius)) {
        return new int[]{-1, -1};
      }

      // Ensure that the answer you find is actually a valid answer
      currentRadius = firstRadius;
      for(int i = 0; i < pegs.length - 2; i++) {
        if(pegs[i] + currentRadius > pegs[i + 1] - 1) {
          return new int[]{-1, -1};
        }
        currentRadius = pegs[i + 1] - (pegs[i] + currentRadius);
      }

      // Else you've found a configuration that solves the problem
      return new int[]{firstRadius, 1};
    } else {
      // Solve firstRadius + x = 2*(lastRadius - x)
      int numerator = ((2 * lastRadius) - firstRadius);
      int denominator = 3;
      int firstRadiusNumerator = (firstRadius * 3);
      int lastRadiusNumerator = (lastRadius * 3);

      // They are inversely related so increasing the first radius will decrease
      // the last radius
      firstRadiusNumerator += numerator;
      lastRadiusNumerator -= numerator;

      if(firstRadiusNumerator != (2 * lastRadiusNumerator)) {
        return new int[]{-1, -1};
      }

      // Ensure that the answer you find is actually a valid answer
      currentRadius = firstRadiusNumerator;
      for(int i = 0; i < pegs.length - 2; i++) {
        if(pegs[i] * denominator + currentRadius >= (pegs[i+1] - 1) * denominator) {
          return new int[]{-1, -1};
        }
        currentRadius = (pegs[i + 1] * denominator) - ((pegs[i] * denominator) + currentRadius);
      }

      // If it is divisible by three, then reduce it
      if(firstRadiusNumerator % 3 == 0) {
        // Fully reduced final answer
        return new int[]{firstRadiusNumerator / denominator, 1};
      }

      // Fully reduced final answer
      return new int[]{firstRadiusNumerator, denominator};
    }
  }
}
