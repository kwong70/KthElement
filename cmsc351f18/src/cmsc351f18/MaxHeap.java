package cmsc351f18;

public class MaxHeap {
    public int[] Heap;
    public int size;
    public int maxsize;
    int num_comps = 0; 
 
    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
 
    public boolean leaf(int pos){
        if (pos >=  (size / 2)  &&  pos <= size){
            return true;
        }
        return false; 
    }
 
    public void swap(int from,int to){
        int tmp;
        tmp = Heap[from];
        Heap[from] = Heap[to];
        Heap[to] = tmp;
    }
 
    public void maxHeapify(int pos){
        if (!leaf(pos)){ 
            if ( Heap[pos] < Heap[2 * pos]  || Heap[pos] < Heap[((2 * pos) + 1)]){ 
                if (Heap[2 * pos] > Heap[((2 * pos) + 1)]){
                    swap(pos, 2 * pos);
                    maxHeapify(2 * pos);
                }else{
                    swap(pos, ((2 * pos) + 1));
                    maxHeapify(((2 * pos) + 1));
                }
                num_comps++;
            }
            num_comps+=2;
        }
    }
 
    public void insert(int element){
        Heap[++size] = element;
        int current = size;
 
        while(Heap[current] > Heap[current/2]){
        	num_comps++;
            swap(current,current/2);
            current = current/2;
        }	
    }

 
    public void maxHeap(){
        for (int pos = (size / 2); pos >= 1; pos--){
            maxHeapify(pos);
        }
    }
 
    public int remove(){
        int popped = Heap[1];
        Heap[1] = Heap[size]; 
        size--;
        if (size!=0) maxHeapify(1);
        return popped;
    }

}
