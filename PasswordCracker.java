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
 * Source:https://www.hackerrank.com/challenges/password-cracker/problem
 */
class Result {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */
static Set<String> set=new HashSet<>();
    public static String passwordCracker(List<String> passwords, String loginAttempt) {
      String sol=solution(loginAttempt,passwords,"");
      set=new HashSet<>();
      if(!sol.equals("WRONG PASSWORD")){
          return sol.substring(1);
      }
      return sol;
    }
      public static String solution(String loginAttempt,List<String> passwords,String result){
          if(loginAttempt.equals("")){
              return result;
          }
          else if(set.contains(loginAttempt)){
              return "WRONG PASSWORD";
          }
          for(String s:passwords){
              if(loginAttempt.indexOf(s)==0){
                  String temp=result+" "+s;
                  String flag=solution(loginAttempt.substring(s.length()),passwords,temp);
                    if(!flag.equals("WRONG PASSWORD")){
                        return flag;
                    }
              }
          }
          set.add(loginAttempt);
          return "WRONG PASSWORD";
      }
}
public class PasswordCracker {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                String result = Result.passwordCracker(passwords, loginAttempt);

				/*
				 * bufferedWriter.write(result); bufferedWriter.newLine();
				 */
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
      //  bufferedWriter.close();
    }
}
