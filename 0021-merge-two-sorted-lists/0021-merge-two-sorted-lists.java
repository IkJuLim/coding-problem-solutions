class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null) return list2;
    if(list2 == null) return list1;

    ListNode result = new ListNode();
    ListNode current = result;

    while(list1 != null && list2 != null) {
      if(list1.val > list2.val) {
        current.next = list2;
        list2 = list2.next;
      }
      else {
        current.next = list1;
        list1 = list1.next;
      }
      current = current.next;
    }

    if(list1 == null) {
      current.next = list2;
    }
    else {
      current.next = list1;
    }

    return result.next;
  }
}