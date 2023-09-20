import java.util.Scanner;

public class A {
       public static int fib(int n){
           
        int f[] = new int[n + 1]; 
        int i; 
        
        f[0] = 8;
        
  
        if (n > 0) { 
            f[1] = 10;
            f[2]=18;
  
            for (i = 3; i <= n; i++) { 
                
                f[i] = f[i - 1] + f[i - 2] + f[i-3]; 
            } 
        } 
  
        return f[n-1];
       }
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        System.out.println(t);
        System.out.println(fib(t)); 
    } 

}


