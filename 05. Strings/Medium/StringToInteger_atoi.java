
public class StringToInteger_atoi {

    public static int myAtoi(String str) {
        str = str.trim();
        
        if(str.isEmpty()) return 0;

        int sign = 1;
        int start = 0;
        if(start < str.length() && str.charAt(start) == '-' || str.charAt(start)  == '+') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            start = 1;
        }

        return atoi(str.substring(start), 0, sign);
    }

    private static int atoi(String s, int num, int sign) {
        if(s.isEmpty()) return num;

        char current = s.charAt(0);
        if(!Character.isDigit(current)) return num;
        if(Character.isDigit(current)) {
            int digit = current - '0';
            if(num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = (num * 10) + (digit * sign);
            return atoi(s.substring(1), num, sign);
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("45"));
        System.out.println(myAtoi(" -45"));
        System.out.println(myAtoi("qoes1233"));
        System.out.println(myAtoi("1233swod"));
        System.out.println(myAtoi("12345566432324"));
        System.out.println(myAtoi("-38473824732674"));
        System.out.println(myAtoi(" "));
    }
    
}