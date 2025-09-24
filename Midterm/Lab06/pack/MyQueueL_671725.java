package pack;

import java.util.LinkedList;
import java.util.Iterator;

public class MyQueueL_671725<T> implements Iterable<T> {
    private LinkedList<T> items = new LinkedList<>();

    public void enqueue(T d) {
        items.addLast(d);
    }

    public T dequeue() {
        return items.removeFirst();
    }

    public T peek() { 
        return items.getFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        for (T item : items)
            sb.append(item).append("-> ");
        sb.append("bottom");
        return sb.toString();
    }
}
