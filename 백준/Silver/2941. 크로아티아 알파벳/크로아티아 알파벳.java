import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    static class CroatianTrie {
        private final TrieNode root = new TrieNode();

        private static final String[] CROATIAN_ALPHABETS = {
                "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
        };

        public CroatianTrie() {
            for (String token : CROATIAN_ALPHABETS) {
                insert(token);
            }
        }

        private void insert(String token) {
            TrieNode current = root;
            for (int i = 0; i < token.length(); i++) {
                char ch = token.charAt(i);
                current = current.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            current.isEnd = true;
        }

        public int countLetters(String word) {
            int count = 0;
            int i = 0;
            int n = word.length();

            while (i < n) {
                TrieNode current = root;
                int matchedLength = 0;

                for (int j = i; j < n; j++) {
                    TrieNode next = current.children.get(word.charAt(j));
                    if (next == null) {
                        break;
                    }
                    current = next;
                    if (current.isEnd) {
                        matchedLength = j - i + 1;
                    }
                }

                if (matchedLength > 0) {
                    count++;
                    i += matchedLength;
                } else {
                    count++;
                    i++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input == null) {
            System.out.println(0);
            return;
        }

        CroatianTrie trie = new CroatianTrie();
        System.out.println(trie.countLetters(input));
    }
}