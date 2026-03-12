class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> dq = new LinkedList<>();
        ListNode curr = head, ret = null, last = null;

        boolean isLastBatch = false;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (curr == null) {
                    break;
                }
                dq.add(curr);
                curr = curr.next;
            }

            boolean isFirstNode = true, isFull = dq.size() == k;
            while (!dq.isEmpty()) {

                ListNode tmp = null;
                if (!isFull) {
                    tmp = dq.pollFirst();
                    tmp.next = dq.peekFirst();
                } else {
                    tmp = dq.pollLast();
                    tmp.next = dq.peekLast();
                }

                if (isFirstNode) {
                    if (last == null) {
                        ret = tmp;
                    } else {
                        last.next = tmp;
                    }
                }
                if (dq.isEmpty()) {
                    last = tmp;
                }
                isFirstNode = false;
            }
            if (curr == null) {
                break;
            }
        }
        return ret;
    }
}