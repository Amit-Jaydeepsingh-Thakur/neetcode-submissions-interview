public class Node {
    Node[] child = new Node[26];
    boolean end = false;
}

class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] != null) {
                curr = curr.child[ch - 'a'];
            } else {
                return false;
            }
        }

        return (curr.end == true) ? true : false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int len = 0;

        for (char ch : prefix.toCharArray()) {
            if (curr.child[ch - 'a'] != null) {
                curr = curr.child[ch - 'a'];  
                len++;
            } 
        }

        return (len == prefix.length()) ? true : false;
    }
}
