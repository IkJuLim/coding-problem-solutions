import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>((a, b) -> b - a);
        for (String operation : operations) {
            if (operation.charAt(0) == 'I') {
                Integer num = Integer.valueOf(operation.substring(2));
                pqAsc.add(num);
                pqDesc.add(num);
            } else if (!pqDesc.isEmpty() && !pqAsc.isEmpty()) {
                if (operation.charAt(2) == '1') {
                    Integer num = pqDesc.poll();
                    pqAsc.remove(num);
                } else {
                    Integer num = pqAsc.poll();
                    pqDesc.remove(num);
                }
            }
        }

        if (!pqDesc.isEmpty() && !pqAsc.isEmpty()) {
            answer[0] = pqDesc.peek();
            answer[1] = pqAsc.peek();
        }
        
        return answer;
    }
}