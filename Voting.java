import java.util.*;

public class Voting
{
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		for(int p_i=0;p_i<t;p_i++){
			Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
			int n=obj.nextInt();
			for(int i=0;i<n;i++){
				int m=obj.nextInt();
				int p=obj.nextInt();
				List<Integer> list;
				if(map.containsKey(m)){
					list=map.get(m);
				}else{
					list=new ArrayList<Integer>();
				}
				list.add(p);
				map.put(m,list);
			}
			Queue<Integer> queue=new PriorityQueue<Integer>();
			long result=0;
			int pref=n;
			int count=0;
			for(int i=n-1;i>=0;i--){
				if(map.containsKey(i)){
					List<Integer> list=map.get(i);
					pref-=list.size();
					int need=i-pref;
					for(int x:list){
						queue.add(x);
					}
					while(count<need){
						count++;
						result+=queue.poll();
					}
				}
			}
			System.out.println(result);
		}
	}
}


