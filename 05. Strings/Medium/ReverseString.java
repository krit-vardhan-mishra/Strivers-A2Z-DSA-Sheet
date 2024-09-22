public class ReverseString {
    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        StringBuilder res = new StringBuilder();
        
        String[] str = s.split(" ");

        for (int i = str.length-1; i >= 0; i--) {
            res.append(str[i]);
            if(i > 0) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky     is blue"));
    }
}
