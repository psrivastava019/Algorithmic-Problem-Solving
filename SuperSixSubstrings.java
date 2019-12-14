import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/contests/hourrank-18/challenges/super-six-substrings/problem
 */
public class SuperSixSubstrings {
    static int globalCount=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        // your code goes here
       
        
      
        System.out.println(solve(s));
    }
     static int solve(String s){
      int n = s.length();
      int x=0;
      int ans=0;
      int[] a=new int[4];
        for (int i = 0; i < n; i++)
        {
            x = (x+s.charAt(i))%3;
            if (s.charAt(i) % 2 == 0)
                a[x]++;
        }
        x = 0;
        for (int i = 0; i < n; i++)
        {

            if (s.charAt(i) == '0')
                ans++;
            else
                ans += a[x];
            x = (x+s.charAt(i))%3;
            if (s.charAt(i) % 2 == 0)
                a[x]--;
        }
        return ans;
  }
}
