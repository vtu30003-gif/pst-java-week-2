import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add new element to window
            deque.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Maintain window size m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
                
                // If maximum possible unique count is achieved, exit early
                if (maxUnique == m) {
                    break;
                }

                // Remove the oldest element going out of window
                int removed = deque.removeFirst();
                int count = map.get(removed);
                if (count == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, count - 1);
                }
            }
        }
        
        in.close();
        System.out.println(maxUnique);
    }
}
