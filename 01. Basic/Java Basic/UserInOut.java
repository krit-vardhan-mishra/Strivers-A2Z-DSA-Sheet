import java.util.Scanner;

public class UserInOut {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       System.out.println("Enter any number : ");
       int num = sc.nextInt();
       System.out.println(num);
       sc.close();
    }
    
}