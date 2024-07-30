import java.util.Scanner;

public class Pattern {
    
    public static void pattern1(int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void pattern2(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void pattern3(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void pattern4(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    
    public static void pattern5(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=n;j>i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void pattern6(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=n;j>=i;j--) {
                System.out.print(n-j+1);
            }
            System.out.println();
        }
    }
    
    public static void pattern7(int n) {
        for(int i=1;i<=n;i++) {
		    for(int j=n-i;j>=1;j--) {
		        System.out.print(" ");
		    }
		    
		    for(int j=1;j<=2*i-1;j++){
		        System.out.print("*");
		    }
		    System.out.println();
		}
    }
    
    public static void pattern8(int n) {
        for(int i=n;i>=1;i--) {
		    for(int j=n-i;j>=1;j--) {
		        System.out.print(" ");
		    }
		    
		    for(int j=1;j<=2*i-1;j++){
		        System.out.print("*");
		    }
		    System.out.println();
		}
    }
    
    public static void pattern9(int n) {
        for(int i=1;i<=n;i++) {
		    for(int j=n-i;j>=1;j--) {
		        System.out.print(" ");
		    }
		    
		    for(int j=1;j<=2*i-1;j++){
		        System.out.print("*");
		    }
		    System.out.println();
		}
        
        for(int i=n;i>=1;i--) {
		    for(int j=n-i;j>=1;j--) {
		        System.out.print(" ");
		    }
		    
		    for(int j=1;j<=2*i-1;j++){
		        System.out.print("*");
		    }
		    System.out.println();
		}
    }
    
    public static void pattern10(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++) {
            for(int j=n;j>=i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void pattern11(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                if((i+j)%2!=0) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
            System.out.println();
        }
    }
    
    public static void pattern12(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(j);
            }
            for(int j=2*n-i;j>i;j--) {
                System.out.print("#");
            }
            for(int j=i;j>=1;j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void pattern13(int n) {
        int a = 1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(a++);
            }
            System.out.println();
        }
    }
    
    public static void pattern14(int n) {
        for(int i=1;i<=n;i++) {
            char k = 'A';
            for(int j=1;j<=i;j++) {
                System.out.print(k++);
            }
            System.out.println();
        }
    }
    
    public static void pattern15(int n) {
        for(int i=1;i<=n;i++) {
            char k = 'A';
            for(int j=n;j>=i;j--) {
                System.out.print(k++);
            }
            System.out.println();
        }
    }
    
    public static void pattern16(int n) {
        char k = 'A';
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(k);
            }
            k++;
            System.out.println();
        }
    }
    
    public static void pattern17(int n) {
        for(int i=1;i<=n;i++) {
            char k = 'A';
            for(int j=n;j>=i+1;j--) {
                System.out.print("#");
            }
            for(int j=1;j<=i;j++) {
                System.out.print((char)(k+j-1));
            }
            for(int j=i-1;j>=1;j--) {
                System.out.print((char)(k+j-1));
            }
            System.out.println();
        }
    }
    
    public static void pattern18(int n) {
        for(int i=0;i<n;i++) {
            for(char j=(char)('E'-i);j<='E';j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void pattern19(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=n;j>=i;j--) {
                System.out.print("*");
            }
            for(int j=3;j<=2*i;j++) {
                System.out.print("#");
            }
            for(int j=n;j>=i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for(int j=n;j>=i;j--) {
                System.out.print("*");
            }
            for(int j=3;j<=2*i;j++) {
                System.out.print("#");
            }
            for(int j=n;j>=i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern20(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            } 
            for(int j=1;j<=2*(n-i);j++) {
                System.out.print("#");
            }
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n-1;i>=1;i--) {
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            } 
            for(int j=1;j<=2*(n-i);j++) {
                System.out.print("#");
            }
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern21(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void pattern22(int n) {
        for(int i=1;i<=2*n-1;i++) {
            for(int j=1;j<=2*n-1;j++) {
                int num = Math.min(Math.min(i,j), Math.min(2*n-i, 2*n-j));
                System.out.print(n+1-num);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        pattern22(num);
        sc.close();
    }
}