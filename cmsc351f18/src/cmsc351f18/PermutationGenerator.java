package cmsc351f18;

import java.util.Random;

public class PermutationGenerator {
	final private Random m_random;
	
	/**
	 * constructor. You should not modify this constructor
	 * @param random The random source
	 */
	PermutationGenerator(Random random) {
		m_random = random;
	}
	
	/**
	 * Generate a new random permutation of {1, 2, 3, ... , n}
	 * @param n The size of the permutation
	 * @return The new random permutation
	 */
	public int[] nextPermutation(int n) {
		int i = 0; 
		int[] list = new int[n];
		
		for(i=0; i < n ; i++) {
			int random_num = m_random.nextInt(Integer.MAX_VALUE);
			random_num++;
			
			while(!unique(list, i-1, random_num)) {
				random_num = m_random.nextInt(Integer.MAX_VALUE);
				random_num++;
			}
			list[i] = random_num;
		}
		return list;
	}
	
	public boolean unique(int [] list, int bound, int val) {
		
		int i = 0; 
		for(i=0; i < bound; i++) {
			if(list[i] == val) return false;
		}
		return true;
	}
}
