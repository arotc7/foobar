public class Answer {
	public static int answer(int start, int length) {
		// Start our result out at 0
		int result = 0;
		
		// This is going to keep track of what number we're at
		int currentFirst = start;
		// Now iterate through the amount of rows we are going to have
		for(int i = 0; i < length; i++) {
			// Each row we will look at 1 less number
			for(int j = 0; j < length - i; j++) {
				// XOR the numbers we want to look at
				result ^= currentFirst + j;
			}
			
			// Need to increment the numbers we're looking at
			currentFirst += length;
		}

		return result;
	}
}
