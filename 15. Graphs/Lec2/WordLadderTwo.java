import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderTwo {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        if (!wordList.contains(endWord))
            return result;

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(beginWord);
        queue.offer(initialPath);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String lastWord = path.get(path.size() - 1);

                char[] lastWordChars = lastWord.toCharArray();
                for (int j = 0; j < lastWordChars.length; j++) {
                    char originalChar = lastWordChars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar)
                            continue;

                        lastWordChars[j] = ch;
                        String newWord = new String(lastWordChars);

                        if (newWord.equals(endWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            result.add(newPath);
                            found = true;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            queue.offer(newPath);
                            levelVisited.add(newWord);
                        }
                    }
                    lastWordChars[j] = originalChar;
                }
            }

            visited.addAll(levelVisited);

            if (found)
                break;
        }

        return result;
    }

    public static void main(String[] agrs) {
        List<String> let = new ArrayList<>();
        let.add("hot");
        let.add("dot");
        let.add("dog");
        let.add("lot");
        let.add("log");
        let.add("cog");

        System.out.println(findLadders("hit", "cog", let));

        // beginWord = "hit", endWord = "cog", wordList =
        // ["hot","dot","dog","lot","log","cog"]
    }
}