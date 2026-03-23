class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;        
        ListNode ret = head.next;
        head.next = swapPairs(ret.next);
        ret.next = head;
        return ret;
    }
}