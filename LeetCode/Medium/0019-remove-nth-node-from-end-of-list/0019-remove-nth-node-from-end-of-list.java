class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null) {
      return null;
    }

    ListNode node = new ListNode(0, head);

    int listSize = 0;
    ListNode tmp = head;
    while (tmp != null) {
      listSize++;
      tmp = tmp.next;
    }

    tmp = node;
    for (int i = listSize; i > n; i--) {
      tmp = tmp.next;
    }
    tmp.next = tmp.next.next;

    return node.next;
  }
}