import java.util.HashMap;
import java.util.LinkedHashMap;

class LFUCache {

    private class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq;
    private final HashMap<Integer, Node> map;
    private final HashMap<Integer, LinkedHashMap<Integer, Node>> frequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        map = new HashMap<>(capacity);
        frequency = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (map.size() == capacity) {
                removeLFU();
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            frequency.computeIfAbsent(1, k -> new LinkedHashMap<>()).put(key, newNode);
            minFreq = 1;
        }  

    }
    
    private void updateNode(Node node) {
            int freq = node.freq;
            LinkedHashMap<Integer, Node> nodes = frequency.get(freq);
            nodes.remove(node.key);
    
            if (freq == minFreq && nodes.size() == 0) {
                minFreq++;
            }
    
            node.freq++;
            frequency.computeIfAbsent(node.freq, k -> new LinkedHashMap<>()).put(node.key, node);
        }
    
    private void removeLFU() {
        LinkedHashMap<Integer, Node> nodes = frequency.get(minFreq);
        int keyToRemove = nodes.entrySet().iterator().next().getKey();
        nodes.remove(keyToRemove);
        if (nodes.size() == 0) {
            frequency.remove(minFreq);
        }
        map.remove(keyToRemove);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
