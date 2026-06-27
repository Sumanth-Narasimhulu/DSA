class Solution {
    public String originalDigits(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] count = new int[10];

        // Unique letters
        count[0] = freq['z' - 'a']; // zero
        count[2] = freq['w' - 'a']; // two
        count[4] = freq['u' - 'a']; // four
        count[6] = freq['x' - 'a']; // six
        count[8] = freq['g' - 'a']; // eight

        // Derived digits
        count[3] = freq['h' - 'a'] - count[8]; // three
        count[5] = freq['f' - 'a'] - count[4]; // five
        count[7] = freq['s' - 'a'] - count[6]; // seven

        count[1] = freq['o' - 'a']
                 - count[0]
                 - count[2]
                 - count[4]; // one

        count[9] = freq['i' - 'a']
                 - count[5]
                 - count[6]
                 - count[8]; // nine

        StringBuilder ans = new StringBuilder();

        for (int digit = 0; digit <= 9; digit++) {
            while (count[digit]-- > 0) {
                ans.append(digit);
            }
        }

        return ans.toString();
    }
}