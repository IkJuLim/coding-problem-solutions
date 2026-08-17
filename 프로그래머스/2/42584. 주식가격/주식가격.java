import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!dq.isEmpty() && prices[dq.getLast()] > prices[i]) {
                int pastIdx = dq.pollLast();
                answer[pastIdx] = i - pastIdx;
            }
            dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int pastIdx = dq.pollLast();
            answer[pastIdx] = prices.length - 1 - pastIdx;
        }

        return answer;
    }
}