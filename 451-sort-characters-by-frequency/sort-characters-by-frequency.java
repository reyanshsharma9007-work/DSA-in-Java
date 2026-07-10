import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find maximum frequency
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 3: Build result from highest frequency to lowest
        StringBuilder result = new StringBuilder();

        for (int freq = maxFreq; freq >= 1; freq--) {
            for (char ch : map.keySet()) {
                if (map.get(ch) == freq) {
                    for (int i = 0; i < freq; i++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}