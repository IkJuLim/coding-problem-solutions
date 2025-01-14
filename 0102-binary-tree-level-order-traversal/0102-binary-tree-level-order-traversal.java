/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Queue<TreeNode> currentQ = new LinkedList<>();
    Queue<TreeNode> nextQ = new LinkedList<>();
    currentQ.add(root);
    int depth = 0;
    ret.add(new ArrayList<>());
    while (!currentQ.isEmpty() || !nextQ.isEmpty()) {
      TreeNode currentNode = currentQ.poll();
      if (currentNode.left != null) {
        nextQ.add(currentNode.left);
      }
      if (currentNode.right != null) {
        nextQ.add(currentNode.right);
      }
      ret.get(depth).add(currentNode.val);
      if (currentQ.isEmpty()) {
        currentQ = nextQ;
        nextQ = new LinkedList<>();
        ret.add(new ArrayList<>());
        depth++;
      }
    }
    ret.remove(ret.size()-1);
    return ret;
  }
}