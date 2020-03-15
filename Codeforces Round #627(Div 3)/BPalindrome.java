import java.util.*;

public class BPalindrome{
    public static void main(String args[]){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int p=0;p<t;p++){
            int n=obj.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=obj.nextInt();
            }
            int longestSubsequence=findLongestSubSequence(arr);
            if(longestSubsequence>=3){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static int findLongestSubSequence(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int len=1;len<=n;len++){
            for(int start=0;start<n;start++){
                int end=start+len-1;
                if(end>=n){
                    continue;
                }
                if(start==end){
                    dp[start][end]=1;
                }else if(start+1==end){
                    dp[start][end]=arr[start]==arr[end]?2:1;
                }else{
                    //length is >=3
                    int cur=arr[start]==arr[end]?2+dp[start+1][end-1]:0;
                    dp[start][end]=Math.max(cur,Math.max(dp[start+1][end],dp[start][end-1]));
                }
            }
        }
        return dp[0][n-1];
    }
}