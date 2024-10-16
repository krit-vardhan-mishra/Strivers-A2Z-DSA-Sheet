import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictonary {

    public static String findOrder(String[] dict, int n, int k) {
        if (dict.length == 0) return "";
    
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> charToNum = new HashMap<>();
        Map<Character, List<Character>> list = new HashMap<>();
    
        for (int i = 0; i < k; i++) {
            charToNum.put((char)('a' + i), i);
        }
    
        for (String word : dict) {
            for (char ch : word.toCharArray()) {
                list.putIfAbsent(ch, new ArrayList<>());
            }
        }
    
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    char from = word1.charAt(j);
                    char to = word2.charAt(j);
                    list.get(from).add(to);
                    break;
                }
            }
        }
    
        int[] inDegree = new int[k];
    
        // Step 1: Calculate the in-degree of each vertex
        for (char key : list.keySet()) {
            for (char ch : list.get(key)) {
                inDegree[charToNum.get(ch)]++;
            }
        }
    
        // Step 2: Add all vertices with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
    
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.append((char)(node + 'a'));
    
            if (list.get((char)(node + 'a')) != null) {
                for (char neighbor : list.get((char)(node + 'a'))) {
                    inDegree[charToNum.get(neighbor)]--;
                    if (inDegree[charToNum.get(neighbor)] == 0) {
                        queue.offer(charToNum.get(neighbor));
                    }
                }
            }
        }
    
        return res.length() == k ? res.toString() : "";
    }

    public static void main(String[] args) {
        String[] ar = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(ar, 5, 4));
    }
}