
public class MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {
        int opening = 0, closing = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') opening++;
            else {
                if (opening > 0) opening--;
                else closing++;
            }
        }

        return opening + closing;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((()))"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()))(("));
    }
}