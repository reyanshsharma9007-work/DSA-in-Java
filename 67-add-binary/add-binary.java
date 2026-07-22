class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        // Pointers for a and b starting from the end (rightmost bit)
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are digits left in 'a', 'b', or a remaining 'carry'
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char bit to int (0 or 1)
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char bit to int (0 or 1)
                j--;
            }

            // Append the bit for current position (0 or 1)
            result.append(sum % 2);

            // Compute the new carry for the next position
            carry = sum / 2;
        }

        // Since digits were added right-to-left, reverse the final result
        return result.reverse().toString();
    }
}