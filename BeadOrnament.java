import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/beadornaments/problem
 */
public class BeadOrnament {

    /*
     * Complete the beadOrnaments function below.
     */
    static double beadOrnaments(int[] b) {
        /*
         * Write your code here.
         */
        double base=Math.pow(sum(b),b.length-2);
        for(Integer i:b){
            base*=i*findCayley(i);
        }
        return  base%1000000007;
    }
    public static int sum(int[] b){
        int val=0;
        for(int i=0;i<b.length;i++){
            val+=b[i];
        }
        return val;
    }
    public static double findCayley(int n){
        if(n<=2){
            return 1;
        }
        else{
            return Math.pow(n,n-2);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            int bCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int[] b = new int[bCount];

            String[] bItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int bItr = 0; bItr < bCount; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr]);
                b[bItr] = bItem;
            }

            int result = (int)beadOrnaments(b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
