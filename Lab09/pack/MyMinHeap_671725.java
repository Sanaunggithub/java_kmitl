package pack;

public class MyMinHeap_671725 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;
    
    private void swap(int i, int j) {
        heap[i] = heap[i] + heap[j];
        heap[j] = heap[i] - heap[j];
        heap[i] = heap[i] - heap[j];
    }
    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int d) {
        /* your code */

        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = d;
        int i = size;
        size++;
        
        int parent = (i - 1) / 2;
        while (i > 0 && heap[i] < heap[parent]) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }

    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d; // this line is optional
        int i = 0;

        while (true) {
            int left = 2 * i + 1;

            // for leaf node
            if (left >= size) break; // no child

            int right = 2 * i + 2; 
            if (right >= size) { // only left child
                if (heap[i] > heap[left])
                    swap(i, left);
                break; // done
            } else { // two children
                int q = heap[left] < heap[right] ? left : right;
                if (heap[i] > heap[q])
                    swap(i, q);
                else
                    break; // parent is smaller than both children. heap property satisfied
                i = q; // move down
            }

            System.out.println("heap snapshot (cur_size = " + size + ") " + this.toString());
        }

        return d;
    } //end while

    public String toString() {
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < size; i++) {
            sb.append(heap[i]);
            sb.append(",");
        }
        if (size > 0) {
            sb.append("]");
        }
        return sb.toString();
    }
    
}
