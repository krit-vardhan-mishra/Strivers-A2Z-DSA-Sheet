public class DataType {
    public static int dataTypeSize(String str) {
        if (str.equals("Integer")) {
            return 4;
        }

        if (str.equals("Long")) {
            return 8;
        }

        if (str.endsWith("Float")) {
            return 4;
        }

        if (str.equals("Double")) {
            return 8;
        }

        if (str.equals("Character")) {
            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(dataTypeSize("Integer"));
        System.out.println(dataTypeSize("Character"));
        System.out.println(dataTypeSize("Long"));
        System.out.println(dataTypeSize("Double"));
        System.out.println(dataTypeSize("Float"));
    }
}
