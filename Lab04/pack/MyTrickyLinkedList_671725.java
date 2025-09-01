package pack;

import java.util.ArrayList;

public class MyTrickyLinkedList_671725 extends MyLinkedList_671725{
    public void q1_rotate_clockwise(int k){
        // check k
        if (k > this.size()) {
            return;
        }

        Node new_tail = null;
        Node new_head = head;

        int i = 0;

        while (i < size() - k) {
            new_tail = new_head;
            new_head = new_head.next;
            i++;
        }

        // finding actual tail
        Node tail = new_head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        new_tail.next = null; //
        head = new_head;
    }

    public void q2_reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next; // preserve the next node connection
            curr.next = prev;   
            prev = curr;         
            curr = next;         
        }
        head = prev;            // Update head to point to the new first node
    }

    public void q3_remove_dup(){
        Node curr = head;

        while(curr != null  && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }

            else{
                curr = curr.next;
            }
        }

    }

    public void q4_increment_digits(){
        q2_reverse();
        
        Node curr = head;

        int carry = 1;

        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) {
                break;
            }
            
            // if there's no element and still have carry
            if (curr.next == null && carry > 0) {
                curr.next = new Node(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }
        q2_reverse();
    }

    public boolean q5_isPalindrome(){
        ArrayList<Integer> mid = new ArrayList<Integer>();
        Node p = head;
        int len = size() / 2;
        
        // mid stores the first half of the list value. mid: [1, 2]. p points to 3.
        for (int i = 0; i < len; i++) {
            mid.add(p.data);
            p = p.next;
        }
        
        // If list has odd length, skip the middle.1 → 2 → 3 → 2 → 1. skip 3 and p points to 2.
        if (size() % 2 != 0) {
            p = p.next;
        }

        // loop backward through mid. mid[1, 2]. p.data = 2, mid.get(1) = 2 
        for (int i = len - 1; i >= 0; i--) {
            if (p.data != mid.get(i)) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    
}
