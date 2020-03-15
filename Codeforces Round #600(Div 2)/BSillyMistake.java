           
import java.util.*;

public class BSillyMistake{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=obj.nextInt();
        } 
        int[] sum=new int[n];
        sum[0]=arr[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        boolean validArray=validateArray(sum,0,n-1);
        int i=0;
        boolean notPossible=false;
        List<Integer> list=new ArrayList<Integer>();
        while(i<n){
            int index=findValidZero(arr,sum,i);
            if(index==-1){
                notPossible=true;
                break;
            }
            i=index+1;
            list.add(index+1);
        }
        if(notPossible){
            System.out.println(-1);
        }else{
            System.out.println(list.size());
            System.out.print(list.get(0)+" ");
            for(int p=1;p<list.size();p++){
                int num=list.get(p)-list.get(p-1);
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int findValidZero(int[] arr,int[] sum,int left){
        int i=left;
        for(;i<arr.length;i++){
            if(sum[i]==0){
                boolean validArray=validateArray(arr,left,i);
                if(validArray){
                    return i;
                }else{
                    continue;
                }
            }
        }
        return -1;
    }
    public static boolean validateArray(int[] arr,int left,int right){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=left;i<=right;i++){           
            int cur=arr[i];
            if(map.containsKey(cur)){
                return false;
            }else if(cur<0&&!map.containsKey(cur*-1)){
                return false;
            }else{
                map.put(cur,1);
            }
        }
        return true;
    }
    
}