import pack.MyTrickyLinkedList_671725;
import pack.MyLinkedList_671725;

public class Lab04_671725 {

    static void demo_1() {
        System.out.println("demo1");
        MyLinkedList_671725 lis = new MyLinkedList_671725();
        lis.add(5);
        lis.add(1);
        lis.insert(4);
        lis.insert(3);
        System.out.println(lis + " size= " + lis.size());
        lis.delete(2);
        System.out.println("5 is at " + lis.find(5));
        System.out.println(lis);
    }
    static void demo_2() {
        MyLinkedList_671725 lis = new MyLinkedList_671725();
        lis.add(new int[] {1,4,5,3});
        System.out.println(lis + " size= " + lis.size());
        lis.delete(3);
        lis.insert(new int[]{8,2});
        System.out.println(lis + " size= " + lis.size());
    }
    static void q1() {
        int [] d = {10,20,30,40,50};
        MyTrickyLinkedList_671725 lis = new MyTrickyLinkedList_671725();
        lis.insert(d);
        System.out.println("before -> " + lis);
        lis.q1_rotate_clockwise(4);
        System.out.println("(k= " + 4 + ") -> " + lis);
        lis.q1_rotate_clockwise(7);
        System.out.println("(k= " + 7 + ") -> " + lis);
        lis.q1_rotate_clockwise(1);
        System.out.println("(k= " + 1 + ") -> " + lis); 
    }
    static void q2() {
        int [] d = {1,2,3,4,5,6,7,8};
        MyTrickyLinkedList_671725 lis = new MyTrickyLinkedList_671725();
        lis.insert(d);
        System.out.println("before -> " + lis);
        lis.q2_reverse(); 
        System.out.println( lis );       
    }
    static void q3() {
        int [] d = {13,11,4,15,4};
        MyTrickyLinkedList_671725 lis = new MyTrickyLinkedList_671725();
        lis.insert(d);
        System.out.println("before -> " + lis);
        lis.q3_remove_dup();
        System.out.println("after-> " + lis);
        int [] e = {13,11,15,4};
        lis = new MyTrickyLinkedList_671725();
        lis.insert(e);
        System.out.println("before -> " + lis);
        lis.q3_remove_dup();
        System.out.println("after-> " + lis);
    }
    static void q4() {
        int [] d = {1,9,9,9};
        MyTrickyLinkedList_671725 lis = new MyTrickyLinkedList_671725();
        lis.insert(d);
        System.out.println("before -> " + lis);
        lis.q4_increment_digits();
        System.out.println("after-> " + lis);
        int [] e = {9,9,9,9};
        lis = new MyTrickyLinkedList_671725();
        lis.insert(e);
        System.out.println("before -> " + lis);
        lis.q4_increment_digits();
        System.out.println("after-> " + lis);
    }
    static void q5() {
        boolean isTrue;
        int [] d = {21, 33, 33, 21};
        MyTrickyLinkedList_671725 lis = new MyTrickyLinkedList_671725();
        lis.add(d);
        isTrue = lis.q5_isPalindrome();
        System.out.println(lis + " isPalindrome= " + isTrue);
        int [] e = {21,33,44,33,21};
        lis = new MyTrickyLinkedList_671725();
        lis.add(e);
        isTrue = lis.q5_isPalindrome();
        System.out.println(lis + " isPalindrome= " + isTrue);
        int [] f = {1,9,9,9};
        lis = new MyTrickyLinkedList_671725();
        lis.add(f);
        isTrue = lis.q5_isPalindrome();
        System.out.println(lis + " isPalindrome= " + isTrue);
    }
    public static void main(String[] args) {
        System.out.println("calling demo_1");
        demo_1();
        System.out.println("calling demo_2");
        demo_2(); 
        System.out.println("calling q1");
        q1();
        System.out.println("calling q2");
        q2();
        System.out.println("calling q3");
        q3();
        System.out.println("calling q4");
        q4();        
        System.out.println("calling q5");
        q5(); 
    }
}