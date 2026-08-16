import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q = new LinkedList<>();

        for (int priority : priorities) {
            pq.add(priority);
            q.add(priority);
        }

        while (!q.isEmpty()) {
            int maxPriority = pq.poll();
            while (q.peek() != maxPriority) {
                q.add(q.poll());
                location = (location - 1 + q.size()) % q.size();
            }
            q.poll();
            answer++;
            location--;
            if (location < 0) {
                return answer;
            }
        }

        return answer;
    }
}