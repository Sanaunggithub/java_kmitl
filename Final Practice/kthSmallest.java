class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        return (lst.get(k - 1)); // 0-Indexed
    }

    public void inorder(TreeNode root, List<Integer> lst){
        if(root == null) return;
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
}

// Note : Binary Search Tree : in-order is sorted.