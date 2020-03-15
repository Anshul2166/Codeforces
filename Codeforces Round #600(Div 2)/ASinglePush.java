import java.util.*;

public class ASinglePush{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int p=0;p<t;p++){
            int n=obj.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=obj.nextInt();
            }
            int[] arr2=new int[n];
            for(int i=0;i<n;i++){
                arr2[i]=obj.nextInt();
            }
            int maxPositiveChanges=0;
            boolean negative=false, maxPositiveChangesOver=false;
            for(int i=0;i<n;i++){
                arr[i]=arr[i]-arr2[i];
            }
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    continue;
                }else if(arr[i]!=0){
                    int cur=arr[i];
                    i++;
                    if(cur>0){
                        negative=true;
                        break;
                    }
                    maxPositiveChanges++;
                    if(maxPositiveChanges>1){
                        maxPositiveChangesOver=true;
                        break;
                    }
                    while(i<n&&arr[i]==cur){
                        i++;
                    }   
                    i--;
                }
            }
            if(negative||maxPositiveChangesOver){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}