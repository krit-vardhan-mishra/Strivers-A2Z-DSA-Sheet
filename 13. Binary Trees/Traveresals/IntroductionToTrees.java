public class IntroductionToTrees {

    public static int countNodes(int i) {
        return (int)Math.pow(2, i)/2;
    }

    public static void main(String[] args) {
        System.out.println(countNodes(1));

    }
}
