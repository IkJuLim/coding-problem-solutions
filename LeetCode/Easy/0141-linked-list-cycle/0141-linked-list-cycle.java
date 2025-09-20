public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode fast = head.next;
    ListNode slow = head;
    while(true) {
      if (fast == null) return false;
      if (fast.next == fast) return true;
      slow.next = slow;
      slow = fast;
      fast = fast.next;
    }
  }
}