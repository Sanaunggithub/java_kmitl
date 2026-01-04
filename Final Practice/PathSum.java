class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // empty tree check
        if(root == null){
            return false; //  only return particular branch
        }

        // stop at leaf node explicitly.(Trickgit)
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        
        boolean left =  hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;

    }
}


//         5
//        / \
//       4   8
//      /   / \
//     11  13  4
//    /  \      \
//   7    2      1

// Start at root 5, targetSum = 22.

// Subtract 5 → remaining sum = 17.

// Go left to 4, remaining sum = 17.

// Subtract 4 → remaining sum = 13.

// Go left to 11, remaining sum = 13.

// Subtract 11 → remaining sum = 2.

// Go left to 7, remaining sum = 2.

// Leaf node, check 7 == 2 → false.

// Go right to 2, remaining sum = 2.

// Leaf node, check 2 == 2 → true.

// Return true up the recursion:

// 11’s left/right → true, so 11 returns true.

// 4 returns true.

// 5 returns true.

// ✅ Path found: 5 → 4 → 11 → 2