class Solution {
    Trie trie;
    int xLen, yLen;
    boolean[][] checked;
    char[][] board;
    List<String> ret;
    StringBuilder sb;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        xLen = board.length;
        yLen = board[0].length;
        checked = new boolean[xLen][yLen];
        this.board = board;
        ret = new ArrayList<>();
        sb = new StringBuilder();

        for (String word : words) {
            trie.insert(word);
        }

        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                checked[x][y] = true;
                sb.append(board[x][y]);
                bt(x, y, trie.root);
                checked[x][y] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return ret;
    }

    private void bt(int x, int y, TrieNode node) {
        char ch = board[x][y];

        if (!node.childrenMap.containsKey(ch)) {
            return;
        }

        TrieNode child = node.childrenMap.get(ch);

        if (child.isEndOfWord) {
            ret.add(sb.toString());
            child.isEndOfWord = false;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (0 <= nextX && nextX < xLen && 0 <= nextY && nextY < yLen && !checked[nextX][nextY]) {
                checked[nextX][nextY] = true;
                sb.append(board[nextX][nextY]);
                bt(nextX, nextY, child);
                checked[nextX][nextY] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        insert(root, word);
    }

    private void insert(TrieNode node, String word) {
        for (char ch : word.toCharArray()) {
            TrieNode childNode = node.childrenMap.getOrDefault(ch, new TrieNode());
            node.childrenMap.put(ch, childNode);
            node = childNode;
        }
        node.isEndOfWord = true;
    }

}

class TrieNode {
    Map<Character, TrieNode> childrenMap = new HashMap<>();
    boolean isEndOfWord = false;
}