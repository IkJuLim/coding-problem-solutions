class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode();
    ListNode ret = node;
    boolean carry = false;
    while (l1 != null || l2 != null) {
      int val = carry ? 1 : 0;
      if (l1 != null) {
        val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        val += l2.val;
        l2 = l2.next;
      }
      if (val >= 10) {
        carry = true;
        val -= 10;
      } else {
        carry = false;
      }

      ListNode newNode = new ListNode(val);
      node.next = newNode;
      node = node.next;
    }
    if (carry) {
      node.next = new ListNode(1);
    }
    return ret.next;
  }
}