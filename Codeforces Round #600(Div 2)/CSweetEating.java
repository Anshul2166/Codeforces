import java.util.*;

public class CSweetEating{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int m=obj.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=obj.nextInt();
        }
        Arrays.sort(arr);
        arr=reverse(arr);
        for(int i=0;i<n;i++){
            int sum=0;
            int count=0;
            for(int j=n-1-i;j<n;j+=m){
                int cur=0;
                for(int k=j;k<j+m;k++){
                    cur+=arr[k];
                }
                sum+=(((count)/m)+1)*arr[j];
                count++;
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] reverse(int[] a) {
        int n=a.length;
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        }
        return b; 
    }
}