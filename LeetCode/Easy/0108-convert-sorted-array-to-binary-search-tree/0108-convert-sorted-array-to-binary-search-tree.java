class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }
    if (nums.length == 2) {
      return new TreeNode(nums[1], new TreeNode(nums[0]), null);
    }
    int min = nums.length / 2;
    TreeNode root = new TreeNode(nums[min]);
    int[] arr1 = new int[min];
    int[] arr2 = new int[nums.length - min - 1];
    for(int i = 0; i < nums.length; i++)  {
      if (i < min) {
        arr1[i] = nums[i];
      } else if (i > min) {
        arr2[i - min - 1] = nums[i];
      }
    }

    root.left = sortedArrayToBST(arr1);
    root.right = sortedArrayToBST(arr2);

    return root;
  }
}