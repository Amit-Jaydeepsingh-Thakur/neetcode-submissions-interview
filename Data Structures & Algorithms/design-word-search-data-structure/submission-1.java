public class Node {
    //Map<Character, Node> child = new HashMap<>();
    Node[] child = new Node[26];
    boolean end = false;
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] =  new Node();
            }

            curr = curr.child[ch - 'a'];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, Node root) {
        Node curr = root;

        for (int i = j; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Node node : curr.child) {
                    if (node != null && dfs(word, i + 1, node)) {
                        return true;
                    }
                }
                return false;
            }
            else if (curr.child[ch - 'a'] == null) {
                return false;
            } else {
                curr = curr.child[ch - 'a'];
            }
        }

        return (curr.end == true) ? true : false;
    }
}
