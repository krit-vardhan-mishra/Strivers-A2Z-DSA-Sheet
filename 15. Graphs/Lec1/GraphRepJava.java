
import java.util.List;
import java.util.ArrayList;

public class GraphRepJava {
    public List<List<Integer>> printGraph(int v, int edges[][]) {
        List<List<Integer>> list = new ArrayList<>(v);

        for (int i=0; i<v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int one = edges[i][0];
            int two = edges[i][1];
            list.get(one).add(two);
            list.get(two).add(one);
        }

        return list;
    }
}