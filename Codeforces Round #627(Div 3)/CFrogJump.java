import java.util.*;

public class CFrogJump{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        String[] arr=new String[t];
        for(int p=0;p<t;p++){
            arr[p]=obj.next();
        }
        for(int p=0;p<t;p++){
            String str=arr[p];
            str="R"+str+"R";
            int n=str.length();
            int[] diff=new int[n];
            int prevRight=0;
            char right='R';
            int maxDiff=0;
            for(int i=1;i<n;i++){
                char c=str.charAt(i);
                if(c==right){
                    diff[i]=i-prevRight;
                    prevRight=i;
                    maxDiff=Math.max(diff[i],maxDiff);
                }
            }
            System.out.println(maxDiff);
        }
    }
}