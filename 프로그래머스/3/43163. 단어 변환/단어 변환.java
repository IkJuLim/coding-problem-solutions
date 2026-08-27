import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (isPosable(begin, str)) {
                visited[i] = true;
                q.add(i);
                break;
            }
        }

        int cnt = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = words[q.poll()];

                if (cur.equals(target)) {
                    return cnt;
                }

                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;

                    String str = words[i];
                    if (isPosable(cur, str)) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
            cnt++;
        }

        return 0;
    }

    private boolean isPosable(String begin, String target) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == target.charAt(i)) {
                cnt++;
            }
        }
        return begin.length() == cnt+1;
    }
}