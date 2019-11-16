public class FactorialDigits{
     public static void main(String agrs[]){
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        long num=obj.nextLong();
        int[] arr=new int[];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        initializeMap(map);
        while(num>0){
            int cur=(int)num%10;
            addToMap(cur);
            num=num/10;
        }
        String sRepeated = IntStream.range(0, map.get(9)).mapToObj(i -> "9").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(8)).mapToObj(i -> "8").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(7)).mapToObj(i -> "7").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(6)).mapToObj(i -> "6").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(5)).mapToObj(i -> "5").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(4)).mapToObj(i -> "4").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(3)).mapToObj(i -> "3").collect(Collectors.joining(""));
        sRepeated += IntStream.range(0, map.get(2)).mapToObj(i -> "2").collect(Collectors.joining(""));
        System.out.println(sRepeated);
     }
     
     public static void initializeMap(Map<Integer,Integer> map){
        map.put(2,0);
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,0);
        map.put(7,0);
        map.put(8,0);
        map.put(9,0);
        return map;
     }
     
     public static void addToMap(int cur){
        if(cur==0||cur==1){

        }else if(cur==2||cur==3||cur==5||cur==7){
            int val=map.get(cur);
            map.put(cur,val+1);
        }else if(cur==4){
            int val=map.get(2);
            map.put(2,val+2);
            val=map.get(3);
            map.put(3,val+1);
        }else if(cur==6){
            map.put(3,map.get(3)+1);
            map.put(5,map.get(5)+1);
        }else if(cur==8){
            map.put(2,map.get(2)+3);
            map.put(7,map.get(7)+1);
        }else if(cur==9){
            map.put(3,map.get(3)+2);
            map.put(2,map.get(2)+1);
            map.put(7,map.get(7)+1);
        }
     }
}    
