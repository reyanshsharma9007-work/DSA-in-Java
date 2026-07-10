import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create buckets
        List<Character>[] buckets = new List[s.length() + 1];

        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(ch);
        }

        // Step 3: Build result from highest frequency to lowest
        StringBuilder result = new StringBuilder();

        for (int freq = buckets.length - 1; freq >= 1; freq--) {
            if (buckets[freq] != null) {
                for (char ch : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}