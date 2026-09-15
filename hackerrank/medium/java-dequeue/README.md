# Java Dequeue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added  to or removed from either the front (head) or back (tail).

    
Deque interfaces can be implemented using various types of collections such as `LinkedList` or `ArrayDeque` classes. For example, deque can be declared as:

    Deque deque = new LinkedList<>();
    or
    Deque deque = new ArrayDeque<>();
    
You can find more details about Deque [here](http://docs.oracle.com/javase/7/docs/api/java/util/Deque.html).

In this problem, you are given $N$ integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size $M$.

*Note*: Time limit is $3$ second for this problem.


**Input Format**

The first line of input contains two integers $N$ and $M$: representing the total number of integers and the size of the subarray, respectively. The next line contains $N$ space separated integers. 

**Constraints**

$1 \le N \le 100000$<br>
$1 \le M \le 100000$<br>
$M\le N$<br>
The numbers in the array will range between $[0,10000000]$.


**Output Format**

Print the *maximum* number of unique integers among all possible contiguous subarrays of size $M$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-15T03:59:13.738Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-dequeue/problem)