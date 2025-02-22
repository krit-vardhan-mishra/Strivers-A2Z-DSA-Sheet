
class Node {
    Node[] link;
    boolean isEnded;
    int charCount;
    int wordCount;

    Node () {
        link = new Node[26];
        isEnded = false;
        charCount = 0;
        wordCount = 0;
    }

    boolean contains(char ch) {
        return link[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
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
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
            temp.charCount++;
        }

        temp.wordCount++;
        temp.isEnded = true;
    }
    
    public int countWordsEqualTo(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            if (temp.contains(ch)) {
                temp = temp.get(ch);
            } else {
                return 0;
            }
        }

        return temp.wordCount;
    }

    public int countWordsStartingWith(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            if (temp.contains(ch)) {
                temp = temp.get(ch);
            } else {
                return 0;
            }
        }

        return temp.charCount;
    }

    public void erase(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            if (temp.contains(ch)) {
                temp = temp.get(ch);
                temp.charCount--;
            } else {
                return;
            }
        }

        temp.wordCount--;
    }

}

public class ImplementationTwo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Inserting strings 'apple', 'app' into Trie");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'app' from trie");
        trie.erase("app");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'apple': ");
        System.out.println(trie.countWordsStartingWith("app"));
    }
}
