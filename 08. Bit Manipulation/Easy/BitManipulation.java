
public class BitManipulation {

    public static void bitManipulation(int num, int i) {
        int bitI = (num >> (i - 1)) & 1;
        int bitII = num | (1 << (i - 1));
        int bitIII = num & ~(1 << (i - 1));
        System.out.println(bitI + " " + bitII + " " + bitIII);
    }    

    public static void main(String[] args) {
        bitManipulation(70, 3);
        bitManipulation(8, 1);
        bitManipulation(678883006, 16);
    }
}