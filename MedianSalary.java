import java.util.*;
public class MedianSalary {
    public static boolean isSorted(List < Integer > list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static boolean ok(int mid, int n, Map < Integer, Integer > map, int max_salary) {
        long sum = 0;
        long count = 0;
        List < Integer > list = new ArrayList < Integer > ();
        Set<Integer> keys= map.keySet();
        Integer[] array = keys.toArray(new Integer[keys.size()]);
        int[] keyset = new int[keys.size()];
		int index = 0;
		for(Integer element : keys) keyset[index++] = element.intValue();

        for (int i = 0; i < keyset.length; i++) {
            int left = keyset[i];
            int right = map.get(left);
            if (right < mid) {
                sum += left;
            } else if (mid  <= left) {
                sum += left;
                count++;
            } else {
                list.add(left);
            }
        }
        if (!isSorted(list)) {
            return false;
        }
        int need = (int)Math.max(0, (n + 1) / 2 - count);
        if (need > list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - need) {
                sum += list.get(i);
            } else {
                sum += mid;
            }
        }
        return sum <= max_salary;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        for (int p_i = 0; p_i < t; p_i++) {
            Map < Integer, Integer > map = new HashMap < Integer, Integer > ();
            int n = obj.nextInt();
            int max_salary = obj.nextInt();
            int right = 100000000;
            for (int i = 0; i < n; i++) {
                int l = obj.nextInt();
                int r = obj.nextInt();
                right = Math.max(right, r);
                map.put(l, r);
            }
            Map < Integer, Integer > sorted = new TreeMap < Integer, Integer > (map);
            int left = 1;
            while (right - left > 1) {
                int mid = (left + right) / 2;
                boolean valid = ok(mid,n, sorted, max_salary);
                if (valid) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            System.out.println(left);
        }
    }
}