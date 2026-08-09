import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        return IntStream.range(0, citations.length)
                .map(i -> Math.min(citations.length - i, citations[i]))
                .max()
                .getAsInt();
    }
}