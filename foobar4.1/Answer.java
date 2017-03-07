import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Answer {
	/**
	 * The general algorithm works like this:
	 * First, find all of the possible pairings for each index.
	 * 
	 * Second, pair the one with the least amount of possible pairings,
	 * with one of its pairs that has the least amount of possible pairs.
	 * 
	 * In this manner we always pair the one with the least amount of pairs
	 * possible with another unlikely pairing so that when we get to the end,
	 * the remaining pairs to create, have possible pairings that will work
	 * still.
	 * @param bananas the list of bananas
	 * @return the amount of guards that cannot be successfully paired
	 */
	public static int answer(int[] bananas) {
		// This is to find the indices with the least amount of pairings.
		Queue<Index> pq = new PriorityQueue<>();
		
		// Checked remembers if an index has been checked yet
		int[] checked = new int[bananas.length];
		
		// This remembers how many pairings each index has
		int[] sizes = new int[bananas.length];
		
		// This is the most possible guards that will remain after the pairings
		int result = bananas.length;

		// Fill the priority queue with 
		for (int i = 0; i < bananas.length; i++) {
			Index index = new Index(i);

			for (int j = 0; j < bananas.length; j++) {
				if(i == j) {
					continue;
				}

				// Fill works with for each index
				int sum = bananas[i] + bananas[j];
				
				// If the number is a candidate for an infinite loop
				if((sum & (sum - 1)) != 0) {
					index.addToWorksWith(j);
					sizes[i]++;
				}
			}

			pq.add(index);
		}

		// While there are still indices that haven't been checked yet
		while(pq.size() != 0) {
			Index index = pq.remove();
			
			// If the index has already been checked or cannot be paired, then get the next one
			if(checked[index.getIndex()] != 0 || sizes[index.getIndex()] == 0) {
				continue;
			}
			List<Integer> worksWith = index.getWorksWith();

			// Next find the index that occurs the least
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int i : worksWith) {
				if(checked[i] != 0) {
					continue;
				}
				int size = sizes[i];

				if(size < min) {
					min = size;
					minIndex = i;
				}
			}

			// If there was one that occurred that it could pair
			// with that wasn't already checked, set them both to
			// checked and we have a pair!
			if(minIndex != -1) {
				checked[index.getIndex()] = 1;
				checked[minIndex] = 1;
				result -= 2;
			}
		}

		return result;
	}
}

/**
 * This class is used for each index. It keeps track of the other
 * indices that it can pair with. This is also how we do the priority
 * queue.
 */
class Index implements Comparable<Index> {
	private int index;
	private List<Integer> worksWithIndices;

	public Index(int i) {
		this.index = i;
		worksWithIndices = new ArrayList<>();
	}

	public int getIndex() {
		return index;
	}

	public List<Integer> getWorksWith() {
		// Since we don't ever edit the works with when getting
		// it, we don't have to return a new arraylist copy
		return worksWithIndices;
	}

	public void addToWorksWith(Integer a) {
		worksWithIndices.add(a);
	}
	
	// This is how we compare to indices. Based off of the documentation
	// for compareTo, this will put priority on indices with a smaller
	// works with size
	@Override
	public int compareTo(Index i) {
		return worksWithIndices.size() - i.worksWithIndices.size();
	}
}
