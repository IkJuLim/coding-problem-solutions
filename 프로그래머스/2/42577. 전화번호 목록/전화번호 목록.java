import java.util.Arrays;

class Solution {
    private class TrieNode {
        boolean isLeaf;
        TrieNode[] leafs;

        TrieNode() {
            this.isLeaf = false;
            leafs = new TrieNode[10];
        }
    }

    public boolean solution(String[] phone_book) {
        TrieNode root = new TrieNode();
        for (String phone : phone_book) {
            TrieNode tmp = root;
            char[] charArray = phone.toCharArray();
            for (char c : phone.toCharArray()) {
                if (tmp.leafs[c - '0'] == null) {
                    tmp.leafs[c - '0'] = new TrieNode();
                }
                tmp = tmp.leafs[c - '0'];
                if (tmp.isLeaf) {
                    return false;
                }
            }
            tmp.isLeaf = true;
            
            for (TrieNode leaf : tmp.leafs) {
                if (leaf != null) {
                    return false;
                }
            }
        }
        return true;
    }
}