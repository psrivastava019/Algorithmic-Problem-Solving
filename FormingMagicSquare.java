import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
public class FormingMagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s[0].length;j++){
                list.add(s[i][j]);
            }
        }
        List<List<Integer>> listOfPermutations=new ArrayList<>();
        List<Integer> listOfNums=new ArrayList<>();
        for(int i=1;i<=9;i++){
            listOfNums.add(i);
        }
        backtrack(listOfNums.size(),listOfNums,listOfPermutations,0);
        int val=100;

        for(List<Integer> l:listOfPermutations){
            int cost=0;
            if(sum(l,0,3)==15 && sum(l,3,6)==15 && sum(l,6,9)==15 
            && (l.get(0)+l.get(4)+l.get(8))==15 && (l.get(2)+l.get(4)+l.get(6))==15 && (l.get(0)+l.get(3)+l.get(6))==15 && (l.get(1)+l.get(4)+l.get(7))==15 && (l.get(2)+l.get(5)+l.get(8))==15){
                for(int i=0;i<9;i++){
                    cost+=Math.abs(l.get(i)-list.get(i));
                }
                if(cost<val){
                    val=cost;
                }
            }
        }

    return val;

    }

    public static int sum(List<Integer> list,int from,int to){
        int sum=0;
        for(int i=from;i<to;i++){
            sum+=list.get(i);
        }
        return sum;
    }

    public static void backtrack(int n,List<Integer> list,List<List<Integer>> output,int first){
        if(n==first){
            output.add(new ArrayList<Integer>(list));
        }
        else{
            for(int i=first;i<n;i++){
                Collections.swap(list,first,i);
                backtrack(n,list,output,first+1);
                Collections.swap(list,first,i);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
