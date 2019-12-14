import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 */
public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
    	int numOfRows=matrix.size()-1;
    	int numOfColoumns=matrix.get(0).size()-1;
    	int currRow=0;
    	int currCol=0;
    	while((currRow <= numOfRows/2) && (currCol <= numOfColoumns/2)) {
    		List<Integer> list=new ArrayList<>();
    		for(int i=currCol;i<numOfColoumns-currCol+1;i++) {
    			list.add(matrix.get(currRow).get(i));
    		}
    		for(int i=currRow+1;i<numOfRows-currRow+1;i++) {
    			list.add(matrix.get(i).get(numOfColoumns-currCol));
    		}
    		for(int i=numOfColoumns-currCol-1;i>currCol-1;i--) {
    			list.add(matrix.get(numOfRows-currRow).get(i));
    		}
    		for(int i=numOfRows-currRow-1;i>currRow;i--) {
    			list.add(matrix.get(i).get(currCol));
    		}
    		Collections.rotate(list, -r%list.size()); 
    		for(int i=currCol;i<numOfColoumns-currCol+1;i++) {
    			matrix.get(currRow).set(i,list.get(0));
    			list.remove(0);
    		}
    		for(int i=currRow+1;i<numOfRows-currRow+1;i++) {
    			matrix.get(i).set(numOfColoumns-currCol,list.get(0));
    			list.remove(0);
    		}
    		for(int i=numOfColoumns-currCol-1;i>currCol-1;i--) {
    			matrix.get(numOfRows-currRow).set(i,list.get(0));
    			list.remove(0);
    		}
    		for(int i=numOfRows-currRow-1;i>currRow;i--) {
    			matrix.get(i).set(currCol,list.get(0));
    			list.remove(0);
    		}
    		currRow++;
    		currCol++;
    	}
    	for(List<Integer> li:matrix) {
    		for(Integer i:li) {
    			System.out.print(i +" ");
    		}
    		System.out.println("");
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
