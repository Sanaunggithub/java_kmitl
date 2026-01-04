package pack;
import java.util.Stack;

public class MyBST_671725 extends MyBST_Basic_671725 {

    public MyBST_671725() { 
        super(); 
    }

    public MyBST_671725(Integer[] input) {
        super(input);
    }

    public BNode getRoot() {
        return root;        
    }

    public BNode findMin(BNode node) {
        if (node == null) throw new IllegalArgumentException("Empty Tree");
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BNode findMax(BNode node) {
        if (node == null) throw new IllegalArgumentException("Empty Tree");
        while (node.right != null /* your code 2 */) {    
            node = node.right;
        }
        return node;        
    }

    public void delete(BNode node, int d) {
        if (node == null) return;

        if (d < node.data) {
            /* your code 3 */;   
            delete(node.left, d);       
        } else if (d > node.data /* your code 4 */) {     
            delete(node.right, d);
        } else { // found
            if (node.left == null || node.right == null) { // 0 or 1 child
                BNode q = node.left == null  ? node.right : node.left;
                if (node.parent != null) {
                    if (node.parent.left == node) 
                        node.parent.left = q;
                    else
                        node.parent.right = q;

                    if (q != null) q.parent = node.parent; /* your code 5 */;
                } else {
                    root = q;
                }
            } else { // 2 children
                BNode q = findMax(node.left);  /* your code 6 */;            
                delete(node.left, q.data);

                // if findMin(node.right), delete(node.right, q.data); 

                if (node.parent == null) {
                    root = q;
                } else if (node.parent.left == node) {
                    node.parent.left = q;
                } else {
                    node.parent.right = q;
                }
                q.parent = node.parent;

                // migrate node's children
                q.left = node.left;
                if (q.left != null) q.left.parent = q;

                q.right = node.right;
                if (q.right != null) q.right.parent = q;
            }
        }
    }

    // smaller than val
    public BNode inorderPredecessor(int val) {
        BNode node = root;
        BNode pred = null;
        while (node != null) {
            if (node.data < val) {
                pred = node; /* your code 7 */
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return pred;  /* your code 8 */        
    }

    // larger than val  
    public BNode inorderSuccessor(int val) {
        BNode node = root, succ = null;
        while (node != null) {
            if (node.data > val) {
                succ = node; /* your code 9 */
                node = node.left;   
            } else {
                node = node.right;
            }
        }
        return succ;
    }

    public int kthSmallest(BNode node, int k) {
        Stack<BNode> stack = new Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left; /* your code 10 */
            }
            node = stack.pop(); /* your code 11 */
            if (--k == 0) return node.data;
            node = node.right;
        }
    }    

    public static void leftRotate(MyBST_671725 bst, BNode node) {
        // if node is null or doesn't have right child, can't rotate left.      
        if (node == null || node.right == null) return;

        BNode rightChild = node.right;
        BNode tmp = rightChild.left;    

        // rotate
        rightChild.left = node; /* your code 12 */
        node.right = tmp;

        // update parents
        rightChild.parent = node.parent;
        node.parent = rightChild;
        if (tmp != null) tmp.parent = node; /* your code 13 */ 
        
        /* your code 14*/ 
        // update children
        if (rightChild.parent == null) {
            bst.root = rightChild;  // node was root
        } else if (rightChild.parent.left == node) {
            rightChild.parent.left = rightChild;
        } else {
            rightChild.parent.right = rightChild;
        }
    }

    public static void rightRotate(MyBST_671725 bst, BNode node) {
        if (node == null || node.left == null) return;

        BNode leftChild = node.left;
        BNode tmp = leftChild.right;

        // rotate
        leftChild.right = node;
        node.left = tmp;

        // update parents
        leftChild.parent = node.parent;
        node.parent = leftChild;
        if (tmp != null) tmp.parent = node;

        // update children
        if (leftChild.parent == null) {
            bst.root = leftChild;
        } else if (leftChild.parent.left == node) {
            leftChild.parent.left = leftChild;
        } else {
            leftChild.parent.right = leftChild;
        }
    }

    public static void rightLeftRotate(MyBST_671725 bst, BNode node) {
        if (node == null || node.right == null) return;
        
        rightRotate(bst, node.right);
        leftRotate(bst, node);
    }
}
