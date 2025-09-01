package pack;

import java.util.ArrayList;

public class MyStack_671725<T> {   
    private ArrayList<T> items = new ArrayList<>();

    public void push(T d){
        items.add(d); // add elements to the end of the list
    }

    public T pop(){
        return items.removeLast();
    }

    public T peek(){
        return items.getLast();
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size() - 1; i > 0; i--)
            sb.append(items.get(i) + ", "); 
        if (items.size() > 0)
            sb.append(items.get(0));
        sb.append("]");
        return sb.toString();
    }
}