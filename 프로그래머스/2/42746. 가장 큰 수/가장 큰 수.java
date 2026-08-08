import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

        for (int number : numbers) {
            pq.add(String.valueOf(number));
        }

        if (pq.peek().equals("0")) {
            return "0";
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        String answer = sb.toString();

        return answer;
    }
}