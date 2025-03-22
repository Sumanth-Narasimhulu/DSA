//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int f(String s, int ind, Integer[] dp) {
        if(ind == s.length()) return 1;
        if(s.charAt(ind) == '0') return 0;
        if(dp[ind] != null) return dp[ind];
        
        int ways = 0;
        ways += f(s, ind + 1, dp);
        
        if(ind < s.length() - 1) {
            if(s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) <= '6')) {
                ways += f(s, ind + 2, dp);
            }
        }
        
        dp[ind] = ways;
        return ways;
    }
    
    public int countWays(String digits) {
        return f(digits, 0, new Integer[digits.length() + 1]);
    }
}
