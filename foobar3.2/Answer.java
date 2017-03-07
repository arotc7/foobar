package foobar5;

public class Answer {   
	public static int answer(int[] l) {
		int solution = 0;
		
		int[] numOfLuckyDoubles = new int[l.length];
		
		// Start by finding lucky double first
		for(int i = 1; i < l.length - 1; i++) {
			for(int j = 0; j < i; j++) {
				if(l[i] % l[j] == 0) {
					numOfLuckyDoubles[i]++;
				}
			}
		}
		
		// Now add up the lucky triples
		for(int k = 2; k < l.length; k++) {
			for(int j = 1; j < k; j++) {
				if(l[k] % l[j] == 0) {
					solution += numOfLuckyDoubles[j];
				}
			}
		}
		
		return solution;
	}
}
