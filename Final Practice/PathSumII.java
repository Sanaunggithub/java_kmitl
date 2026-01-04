class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
       

        dfs(root, targetSum, current, result);
        return result;

    }

    public void dfs(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result){
        if(root == null) return;    

        current.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            result.add(new ArrayList<Integer>(current));
        } else {
            dfs(root.left, targetSum - root.val, current, result);
            dfs(root.right, targetSum - root.val, current, result);
        }

        current.remove(current.size() - 1); // backtracking
    }

}