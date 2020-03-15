import java.util.*;

public class BConnectingFridges{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int p=0;p<t;p++){
            int n=obj.nextInt();
            int m=obj.nextInt();
            int[] arr=new int[n];
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=obj.nextInt();
                sum+=(long)arr[i];
            }
            int min1=-500;
            int min2=-500;
            int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
            for (int i = 0; i < arr.length ; i ++) 
            { 
                /* If current element is smaller than first 
                then update both first and second */
                if (arr[i] <= first) 
                { 
                    second = first; 
                    min2=min1;
                    first = arr[i]; 
                    min1=i;
                } 
    
                /* If arr[i] is in between first and second 
                then update second  */
                else if (arr[i] <= second && arr[i] != first) {
                    second = arr[i]; 
                    min2=i;
                }
            } 
            if(m>=n){
                
                System.out.println((min1+1)+" "+(min2+1));
                for(int i=0;i<m;i++){
                    if(i!=min1&&i!=min2){
                        if(i%2==0)
                            System.out.println((min1+1)+" "+(i+1));
                        if(i%2!=0)
                            System.out.println((min2+1)+" "+(i+1));
                    }
                } 
            }else{
                System.out.println(-1);
            }
        }
    }
}