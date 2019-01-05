package cmsc351f18;

public class MinHeap{
	
    int[] Heap;
    int size = 0;
    int maxsize;
    int num_comps = 0; 

 
    public MinHeap(int endsize){
        this.maxsize = endsize;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
 
    public boolean leaf(int pos){
        if (pos >=  (size / 2)  &&  pos <= size){ 
            return true;
        }
        return false;
    }
 
    public void swap(int from, int to){
        int tmp;
        tmp = Heap[from];
        Heap[from] = Heap[to];
        Heap[to] = tmp;
    }
 
    public void minHeapify(int pos){
        if (!leaf(pos)){ 
            if ( Heap[pos] > Heap[(2 * pos)]  || Heap[pos] > Heap[((2 * pos) + 1)]){
            	
                if (Heap[(2 * pos)] < Heap[((2 * pos) + 1)]){
                    swap(pos, (2 * pos));
                    minHeapify((2 * pos));
                }else{
                    swap(pos, ((2 * pos) + 1));
                    minHeapify(((2 * pos) + 1));
                }
                num_comps++;
            }
            num_comps+=2;
        }
    }
 
    public void insert(int element){
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[(current / 2)]){
        	num_comps++;
            swap(current,(current / 2));
            current = (current / 2);
        }	
        
    }

 
    public void minHeap(){
        for (int pos = (size / 2); pos >= 1 ; pos--){
            minHeapify(pos);
        }
    }
 
    public int remove()	{
        int popped = Heap[1];
        Heap[1] = Heap[size--]; 
        if(size!=0) minHeapify(1);
        return popped;
    }
}
