import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/string-similarity/problem
 */
public class StringSimilarity {
    // Complete the stringSimilarity function below.
   
    static long stringSimilarity(String s) {
        int len=s.length();
         long count=0;
        int index=1;
        while(index!=s.length()){
            int temp=index;
            int temp2=0;
            while(s.charAt(temp2++)==s.charAt(temp++)){
                count++;
                if(temp2>=len|| temp>=len){
                    break;
                }
            }
            index++;
        }
        return count+s.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            long result = stringSimilarity(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

