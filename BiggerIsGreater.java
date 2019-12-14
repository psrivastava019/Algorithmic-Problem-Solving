import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] ch=w.toCharArray();
        int largestIndex=-1;
        int secondLargestIndex=-1;
        
        for(int i=ch.length-1;i>0;i--){
            if((int)ch[i]>(int)ch[i-1]){
                largestIndex=i;
                break;
            }
        }
        if(largestIndex==-1){
            return "no answer";
        }
        for(int j=largestIndex;j<ch.length;j++){
            if((int)ch[j]>(int)ch[largestIndex-1]){
                secondLargestIndex=j;
            }
        }
        char temp=ch[largestIndex-1];
        ch[largestIndex-1]=ch[secondLargestIndex];
        ch[secondLargestIndex]=temp;

        int j=ch.length-1;
        while(largestIndex<j){
            temp = ch[largestIndex];
            ch[largestIndex] = ch[j];
            ch[j] = temp;
            largestIndex++;
            j--;
        }

        return String.valueOf(ch);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
