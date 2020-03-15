import java.util.*;
public class ATetris{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int p=0;p<t;p++){
            int n=obj.nextInt();
            int[] arr=new int[n];
            int countOdd=0,countEven=0;
            for(int i=0;i<n;i++){
                arr[i]=obj.nextInt();
                if(arr[i]%2==0){
                    countEven++;
                }else{
                    countOdd++;
                }
            }
            if(n==countEven||n==countOdd){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}