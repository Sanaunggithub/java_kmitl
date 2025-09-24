package pack;

public class MyPriorityQueue_671725 implements MyQueueIntf {
    MyMinHeap_671725 heap = new MyMinHeap_671725();
    
    @Override
    public void enqueue(int d) {
        heap.insert(d);
    }

    @Override
    public int dequeue() {
        if (heap.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // or throw exception
        }
        return heap.remove();
    }

    @Override
    public int front() {
        if (heap.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // or throw exception
        }

        return heap.peek();
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }    

    @Override
    public String toString() {
        return heap.toString();
    }
}
