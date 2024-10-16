
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] temp = current.toCharArray();

                for (int j = 0; j < temp.length; j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[j] = ch;
                        String newWord = new String(temp);

                        if (newWord.equals(endWord)) {
                            return length;
                        }

                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit", "cog", word));
    }
}
