import java.util.*;

public class AChangingVolume{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int p=0;p<t;p++){
            int a=obj.nextInt();
            int b=obj.nextInt();
            int diff=b-a;
            int count=0;
            diff=Math.abs(diff);
            if(diff>0){
                count=diff/5;
                diff=diff%5;
                if(diff==4||diff==3){
                    count+=2;
                }else if(diff==2||diff==1){
                    count+=1;
                }
            }
            System.out.println(count);
        }
    }
}