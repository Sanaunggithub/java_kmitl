class Solution {
    int sum = 0; // global variable to updatesum
    public int rangeSumBST(TreeNode root, int low, int high) {
      
        inorder(root, low, high);
        return sum;
    }

    public void inorder(TreeNode root,  int low, int high){
        if(root == null) return;

        // If root is too big, only check left
        if (root.val > high) {
            inorder(root.left, low, high);
        }
        // If root is too small, only check right
        else if (root.val < low) {
            inorder(root.right, low, high);
        }

        else{
            sum += root.val;
            inorder(root.left ,low, high);
            inorder(root.right,low, high);
        }
        
    }
}