package cmsc351f18;

/**
 * 
 * @author kendallwong
 * Process
 *Find which heap to place it in 
 *	
 *insert value into that heap 
 *if heap sizes are wrong then take the root of one heap and transfer it to the other 
 *call heapify on both heaps 
 */

public class MartianOracle {
	final private int m_totalSize;
	MaxHeap maxHeap;
	MinHeap minHeap; 
	int num_processed=0; 
	/**
	 * constructor of the class
	 * @param size The first number in the stream, denoting the total number of positive integers
	 */
	public MartianOracle(int size) {
		m_totalSize = size;
		int x = Math.round((float) (size/3.0));
		maxHeap = new MaxHeap(x);
		minHeap = new MinHeap(size - x);
		
	}
	
	/**
	 * process a positive integer
	 * @param value The new positive integer to process
	 */
	public void process(int value) {
		num_processed++;
		/*
		System.out.println("--------------------------------------");
		System.out.println("Processing "+ value);
		System.out.println("Processed " + num_processed);
		System.out.println("MaxHeap "+ maxHeap.maxsize + " "+ maxHeap.size);
		System.out.println("MinHeap "+ minHeap.maxsize + " "+ minHeap.size);
		*/
		int minOfMinHeap;
		if(minHeap.size == 0) {
			minOfMinHeap = -10000000;
		}else {
			minOfMinHeap = minHeap.Heap[1];
		}
		//System.out.println(Math.round( (float) (num_processed/3.0)));
		//System.out.println(num_processed - Math.round((float) ((num_processed)/3.0)));
		if(minOfMinHeap >= value) {/*place in Max Heap*/
			if(maxHeap.size < Math.round( (float) (num_processed/3.0))) { /*no transfer*/
				//System.out.println("MaxHeap No Transfer");
				maxHeap.insert(value);
			}else { /*transfer*/
				//System.out.println("MaxHeap Transfer");
				int transfer = maxHeap.remove();
				maxHeap.insert(value);
				minHeap.insert(transfer);
			}			
		}else {/*Place in min heap*/
			
			if(minHeap.size < (num_processed - Math.round((float) ((num_processed)/3.0)))) {/*transfer */
				//System.out.println("MinHeap No Transfer");
				minHeap.insert(value);
			}else {/*no transfer*/
				
				//System.out.println("MinHeap Transfer");
				int transfer = minHeap.remove(); 
				maxHeap.insert(transfer);
				minHeap.insert(value);
			}
		}
		/*
		System.out.println("MaxHeap: ");
		for(int i=1; i<=maxHeap.size; i++) { 
			System.out.print(maxHeap.Heap[i] + " ");
		}
		System.out.println();
		System.out.println("MinHeap: ");
		for(int i=1; i<=minHeap.size; i++) {
			System.out.print(minHeap.Heap[i] + " ");
		}
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();
		*/
	}
	
	/**
	 * query the \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 * @return The current \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 */
	public int query() {

		if((num_processed+2)/3 == maxHeap.size) {
			return maxHeap.Heap[1];
		}else {
			return minHeap.Heap[1];
		}
	}

}
