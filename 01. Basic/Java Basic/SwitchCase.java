import java.util.List;

public class SwitchCase {
    public static double switchCase(int choice, List<Double> arr) {
        switch (choice) {
            case 1:
                return arr.get(0) * Math.PI * arr.get(0);
        
            case 2:
                double l = arr.get(0);
                double r = arr.get(1);
                return l*r;

            default :
                return -1;
        }
    }
    public static void main(String[] args) {
        
    }
}
