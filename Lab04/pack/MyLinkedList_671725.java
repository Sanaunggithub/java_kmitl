package pack;

public class MyLinkedList_671725{
    public class Node {
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }

    Node head = null;

    // task 1
    public int size(){
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    
    public void add(int d){
        Node node = new Node(d);
        node.next = head;
        head = node;
    }

    // index less, curr ahead
    public int getAt(int index){  
        
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Out of bound");
        }

        Node curr = head;

        while(index > 0){
            curr = curr.next;
            index --;  
        }

        return curr.data;
    }

    public void setAt(int index, int d){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Out of bound");
        }

        Node curr = head;
        
        while (index > 0) {
            curr = curr.next;
            index --;
        }

        curr.data = d;
    }

    public void insert(int d){
        Node q = new Node(d);

        // If the list is empty
        if(head == null){
            head = q;
            return;
        }

        // if data is less than head, insert at front
        if (d < head.data){
            q.next = head;
            head = q;
            return;
        }

        Node curr = head;

        // Find correct position to insert
        while (curr.next != null && curr.next.data < d) {
            curr = curr.next;
        }
        
        // Insert the new node
        q.next = curr.next;
        curr.next = q;
    }

    public int find(int d){
        Node curr = head;
        int count = 0;
        while (curr != null) {
            if (curr.data == d){
                return count;
            }

            count++;
            curr = curr.next;
        }

        return -1;
    }

    public void delete(int d){
        // If there is no element
        if (head == null) {
            return;
        }

        // If head is deleted element
        if (head.data == d) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data == d) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public void add(int [] d){
        for(int i = d.length - 1; i >= 0; i--){
            add(d[i]);
        }
    }

    public void insert(int [] d){
        for (int i = 0; i < d.length; i++) {
            insert(d[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}


