import java.util.*;

public class MinHeap {
    private List<Integer> minHeap;
    private int size;

    public int parent(int i){
        return (i-1)/2;
    }

    public int left(int i){
        return (i*2)+1;
    }

    public int right(int i){
        return (i*2)+2;
    }

    public void swap(int a, int b){
        int temp = minHeap.get(a);
        minHeap.set(a, minHeap.get(b));
        minHeap.set(b, temp);
    }

    public void heapifyDown(int p){
        int smallest = p;
        int l = left(smallest);
        int r = right(smallest);

        if(l < size && minHeap.get(l) < minHeap.get(smallest)) smallest = l;
        if(r < size && minHeap.get(r) < minHeap.get(smallest)) smallest = r;

        if(smallest == p) return;

        swap(smallest, p);
        heapifyDown(smallest);
    }

    public void initializeHeap() {
        minHeap = new ArrayList<>();
        size = 0;
    }

    public void insert(int key) {
        minHeap.add(key);
        size++;

        int c = size-1;
        int p = parent(c);
        while(p != 0 && minHeap.get(p) > minHeap.get(c)){
            swap(c, parent(c));
            c = parent(c);
        }
    }

    public int extractMin() {
        if (size == 0) return -1;

        int min = minHeap.get(0);

        minHeap.set(0, minHeap.get(size - 1));
        minHeap.remove(size - 1);
        size--;

        heapifyDown(0);

        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        if(size == 0) return -1;
    
        return minHeap.get(0);
    }

    public int heapSize() {
        return size;
    }
}