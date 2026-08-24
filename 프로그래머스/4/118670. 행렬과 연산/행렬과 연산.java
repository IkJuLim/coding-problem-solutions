import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int rLen = rc.length;
        int cLen = rc[0].length;
        ArrayDeque<Integer> leftCol = new ArrayDeque<>();
        ArrayDeque<Integer> rightCol = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> rows = new ArrayDeque<>();

        for (int i = 0; i < rLen; i++) {
            leftCol.add(rc[i][0]);
            rightCol.add(rc[i][cLen-1]);
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < cLen-1; j++)
                tmp.add(rc[i][j]);
            rows.add(tmp);
        }

        for (String operation : operations) {
            if (operation.charAt(0) == 'S') {
                leftCol.addFirst(leftCol.removeLast());
                rightCol.addFirst(rightCol.removeLast());
                rows.addFirst(rows.removeLast());
            }
            else {
                rows.getFirst().addFirst(leftCol.removeFirst());
                rightCol.addFirst(rows.getFirst().removeLast());
                rows.getLast().addLast(rightCol.removeLast());
                leftCol.addLast(rows.getLast().removeFirst());
            }
        }

        while (!leftCol.isEmpty() && !rightCol.isEmpty()){
            ArrayDeque<Integer> tmp = rows.removeFirst();
            tmp.addFirst(leftCol.removeFirst());
            tmp.addLast(rightCol.removeFirst());
            rows.addLast(tmp);
        }

        return rows.stream()
                .map(value -> value.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }
}
