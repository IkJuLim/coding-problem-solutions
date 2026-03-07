class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode(), tmp = ret;
        List<Integer> nums = new ArrayList<>();
        int cnt = 0;

        for (ListNode list : lists) {
            if (list != null) nums.add(list.val);
            else {
                cnt++;
                nums.add(Integer.MAX_VALUE);
            }
        }

        while (cnt < lists.length) {
            int minIdx = nums.indexOf(Collections.min(nums));
            tmp.next = lists[minIdx];
            tmp = tmp.next;
            if (lists[minIdx].next == null) {
                nums.set(minIdx, Integer.MAX_VALUE);
                cnt++;
            }
            else nums.set(minIdx, tmp.next.val);
            lists[minIdx] = tmp.next;
        }

        return ret.next;
    }
}