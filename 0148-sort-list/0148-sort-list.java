class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmpNode = head;
        int cnt = 1;

        while (tmpNode.next != null) {
            cnt++;
            tmpNode = tmpNode.next;
        }
        ListNode returnNode = sortList(head, cnt);
        return returnNode;
    }

    public ListNode sortList(ListNode list, int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            list.next = null;
            return list;
        }
        ListNode firstList = list;
        ListNode lastList = list;
        for (int i = 0; i < n / 2; i++) {
            lastList = lastList.next;
        }

        ListNode firstReturnList = sortList(firstList, n / 2);
        ListNode lastReturnList = sortList(lastList, n - n / 2);

        ListNode lastNode = null;
        ListNode returnNode = null;
        while (firstReturnList != null || lastReturnList != null) {
            ListNode tmpNode = null;
            if (firstReturnList == null) {
                tmpNode = lastReturnList;
                lastReturnList = lastReturnList.next;
            } else if (lastReturnList == null) {
                tmpNode = firstReturnList;
                firstReturnList = firstReturnList.next;
            } else {
                if (firstReturnList.val >= lastReturnList.val) {
                    tmpNode = lastReturnList;
                    lastReturnList = lastReturnList.next;
                }
                else {
                    tmpNode = firstReturnList;
                    firstReturnList = firstReturnList.next;
                }
            }

            if (returnNode == null) {
                returnNode = tmpNode;
                lastNode = tmpNode;
            }
            lastNode.next = tmpNode;
            lastNode = lastNode.next;
        }
        lastNode.next = null;
        return returnNode;
    }
}