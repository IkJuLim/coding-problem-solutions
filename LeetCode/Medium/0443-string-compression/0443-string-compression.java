class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int cnt = 0;
        int ret = 0;
        for (char c : chars) {
            if (c != prev) {
                ret = getRet(chars, prev, cnt, ret);
                cnt = 1;
                prev = c;
                continue;
            }
            cnt++;
            prev = c;
        }

        ret = getRet(chars, prev, cnt, ret);
        return ret;
    }

    private int getRet(char[] chars, char prev, int cnt, int ret) {
        if (cnt == 1) {
            chars[ret] = prev;
            ret += 1;
        } else if (cnt < 10) {
            chars[ret] = prev;
            chars[ret+1] = (char)(cnt + 48);
            ret += 2;
        } else if (cnt < 100) {
            chars[ret] = prev;
            chars[ret+1] = (char)(cnt % 100 / 10 + 48);
            chars[ret+2] = (char)(cnt % 10 + 48);
            ret += 3;
        } else if (cnt < 1000) {
            chars[ret] = prev;
            chars[ret+1] = (char)(cnt % 1000 / 100 + 48);
            chars[ret+2] = (char)(cnt % 100 / 10 + 48);
            chars[ret+3] = (char)(cnt % 10 + 48);
            ret += 4;
        } else {
            chars[ret] = prev;
            chars[ret+1] = (char)(cnt % 10000 / 1000 + 48);
            chars[ret+2] = (char)(cnt % 1000 / 100 + 48);
            chars[ret+3] = (char)(cnt % 100 / 10 + 48);
            chars[ret+4] = (char)(cnt % 10 + 48);
            ret += 5;
        }
        return ret;
    }
}