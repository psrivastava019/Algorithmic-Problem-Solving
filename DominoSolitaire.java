/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/DOMSOL
 */
public class DominoSolitaire
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		int[][] arr=new int[2][T];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<T;i++){
		    arr[0][i]=Integer.parseInt(s[i]);
		}
		String[] s1=br.readLine().split(" ");
		for(int i=0;i<T;i++){
		    arr[1][i]=Integer.parseInt(s1[i]);
		}
		
		int[] sum=new int[T+1];
		sum[0] = 0;
        sum[1] = Math.abs(arr[0][0] - arr[1][0]);

        for (int l = 2; l <= T; l++) {
            int i = sum[l - 1] + Math.abs(arr[0][l - 1] - arr[1][l - 1]);
            int j = sum[l - 2] + Math.abs(arr[0][l - 1] - arr[0][l - 2]) + Math.abs(arr[1][l - 1] - arr[1][l - 2]);
            if (i > j) {
                sum[l] = i;
            } else {
                sum[l] = j;
            }

        }
        System.out.print(sum[T]);
	}
}
