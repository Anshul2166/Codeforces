import java.util.*;
public class CHamburgers{
    static int na,nb,nc,pa,pb,pc;
    static long r;
    static Map<String,Integer> map;
    
    public static boolean check(long x){
        long ans=(long)(Math.max(0,map.get("B")*x-na))*pa;
        ans+=(long)(Math.max(0,map.get("C")*x-nc))*pc;
        return r>=ans;
    }

    public static long binarySearch(long lo,long hi){
        while(lo<hi)
        {
            long mid=(lo+hi+1)/2;
            if(check(mid)) lo=mid;
            else hi=mid-1;
        }
        return lo;
    }
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        String str=obj.next();
        na=obj.nextInt();
        nb=obj.nextInt();
        nc=obj.nextInt();
        pa=obj.nextInt();
        pb=obj.nextInt();
        pc=obj.nextInt();
        r=obj.nextLong();
        map=new HashMap<String,Integer>();
        map.put("B",0);
        map.put("S",0);
        map.put("C",0);
        for(int i=0;i<str.length();i++){
            String s=Character.toString(str.charAt(i));
            map.put(s,map.get(s)+1);
        }
        long x=binarySearch(0,(long)Math.pow(10,13));
        System.out.println(x);
    }
}