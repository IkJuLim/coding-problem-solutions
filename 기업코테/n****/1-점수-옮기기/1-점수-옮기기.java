import java.util.*;

class Solution {
    public int transferScore(int cap, int k, int[] score, int m) {
        int n = score.length;
        int highCnt = 0;

        for (int i = 0; i < n; i++) {
            if (score[i] > k) highCnt++;
            else break;
        }

        int nTar = highCnt - m + 1;
        if (nTar <= 0) return 0;

        int need = 0;
        int tarIdx = highCnt - nTar;
        for (int i = tarIdx; i < highCnt; i++) {
            need += (score[i] - k);
        }

        List<Integer> gaps = new ArrayList<>();
        for (int i = highCnt; i < n; i++) {
            gaps.add(cap - score[i]);
        }

        Collections.sort(gaps, Collections.reverseOrder());

        int cover = 0;
        for (int i = 0; i < gaps.size(); i++) {
            cover += gaps.get(i);
            if (cover >= need) {
                return nTar + (i + 1);
            }
        }

        return -1;
    }
}