import java.math.*; 
import java.lang.*; 
import java.util.*;
import java.io.*;
import java.math.BigInteger;     
/** 
 * Author: Priyanshu Srivastava
 * Source:https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/000000000008830b
 */
public class Cryptopanagrams
{ 
	public static char getValue(BigInteger b,List<BigInteger> list) {
		for(int i=0;i<list.size();i++) {
			if(b.equals(list.get(i))) {
				return (char)('A'+i);
			}
		}
		return '0';
	}
    public static void main(String[] args) 
    { 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); 
        for (int i = 1; i <= T; i++) 
        { 
          //System.out.println("\nz);
          BigInteger N = in.nextBigInteger();
          int L = in.nextInt();
          //System.out.print(bi+" "+l);
          BigInteger[] A=new BigInteger[L];
          for(int j=0;j<L;j++)
          {
             A[j]=in.nextBigInteger();
          }
          Set<BigInteger> set = new HashSet<BigInteger>();
          for(int j=0;j<A.length;j++) {
        	  for(int k=j+1;k<A.length;k++) {
        		  BigInteger p=A[j].gcd(A[k]);
        		  if(!p.equals(BigInteger.ONE) && !p.equals(A[j]) && !p.equals(A[k])) {
        			  set.add(p);
        			  set.add(A[j].divide(p));
        			  set.add(A[k].divide(p));
        		  }
        	  }
          }
          List<BigInteger> list=new ArrayList<>();
          for(BigInteger s:set) {
        	  list.add(s);
          }
          Collections.sort(list);
          char[] ch=new char[L+1];
          for(int j=0;j+1<A.length;j++) {
        	  BigInteger g=A[j].gcd(A[j+1]);
        	  if(!g.equals(BigInteger.ONE) && !g.equals(A[j]) && !g.equals(A[j+1])) {
        		  ch[j+1]=getValue(g,list);
        		  BigInteger a=g;
        		  for(int k=j;k>=0;k--) {
        			  a=A[k].divide(a);
        			  ch[k]=getValue(a,list);
        		  }
        		  a=g;
        		  for(int k=j+1;k<A.length;k++) {
        			  a=A[k].divide(a);
        			  ch[k+1]=getValue(a,list);
        		  }
        		  break;
        	  }
          }
        String res="";
        for(int j=0;j<ch.length;j++) {
        	res+=ch[j];
        }
        System.out.println("Case #"+i+": "+res);
        } 
    } 
}