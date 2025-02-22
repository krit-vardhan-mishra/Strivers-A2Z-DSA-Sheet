
class Node {
    Node[] link;
    boolean isEnded;

    Node () {
        link = new Node[26];
        isEnded = false;
    }

    boolean contains(char ch) {
        return link[ch - 'a'] != null;
    }

    void insert(char ch, Node node) {
        link[ch - 'a'] = node;
    }

    Node get(char ch) {
        return link[ch - 'a'];
    }
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                temp.insert(ch, new Node());
            }
            temp = temp.get(ch);
        }

        temp.isEnded = true;
    }
    
    public boolean search(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }

        return temp.isEnded;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;

        for (char ch : prefix.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }

        return true;
    }
}

public class Implementation {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("samsung");
    }
}
