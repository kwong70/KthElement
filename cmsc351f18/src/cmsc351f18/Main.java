package cmsc351f18;

import java.util.Random;
import java.util.Scanner;
/**
 * Sample Main for you to test your class(es)
 * You don't need to submit this file
 */
public class Main {
	
	public static void main(String[] args) {
		MartianOracle orc;
		Random random;
		PermutationGenerator perm;
		int[] num;
		/*
		// Create a scanner from stdin
		Scanner scanner = new Scanner(System.in);
		// First value is the total number of positive integers
		int totalSize = scanner.nextInt();
		// Create a MartianOracle
		MartianOracle oracle = new MartianOracle(totalSize);
		while(scanner.hasNext()) {
			// Read next value
			int value = scanner.nextInt();
			if(value == 0) {
				// Query
				System.out.println(oracle.query());
			}
			else {
				// Process
				oracle.process(value);
			}
		}
		scanner.close();
		*/
		
		
		for (int i = 1001; i <= 10001; i += 1000) {
			orc = new MartianOracle(i);
			random = new Random((long)i);
			perm = new PermutationGenerator(random);
			num = perm.nextPermutation(i);

			for (int j = 0; j < i; j++) {
				orc.process(num[j]);
			}

			System.out.println("n = " + i + ", C(n) = " + (orc.minHeap.num_comps + orc.maxHeap.num_comps) + ", D(n) = " + (orc.minHeap.num_comps + orc.maxHeap.num_comps)/(i*(Math.log10(i))));
		}
		
		
	}

}
