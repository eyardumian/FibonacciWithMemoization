import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;

/**
 * Algorithms to compute the Fibonacci numbers using a recursive 
 * (dot-down) method. 
 *
 *Programing Assignment 2 
 *@author Erika Yardumian - CPSC - 3283
 *@version 6/14/19
 */
public class FibonacciWithMemoization {

   private Map<Integer, BigInteger> memoize = new HashMap<>();

   public BigInteger Fibonacci(int n) {
     // Check if n is already in table.
      if (memoize.containsKey(n)) {
         return memoize.get(n);
      }
      
      // If n = 0, return 0.
      else if (n == 0) {
         return BigInteger.ZERO;
      }
      
      // If n = 1, return 1.
      else if (n == 1) {
         return BigInteger.ONE;
      }
              
      else  {
      // Store the Fibonacci value of n in a variable.
         BigInteger sum = Fibonacci(n - 1).add(Fibonacci(n - 2));
      // Store the variable in the table.
         memoize.put(n, sum); 
         return sum;
      }
   }
   
   public static void main (String args[]) 
   { 
      File F = new File("TimesFive.txt");
      try {
         PrintWriter printWriter = new PrintWriter(F);
               
         for (int i = 1; i < 56; i++) {
            FibonacciWithMemoization fibonacciAlg = new FibonacciWithMemoization();
            long StartTime = System.nanoTime();
            BigInteger f = fibonacciAlg.Fibonacci(i);
            long EndTime = System.nanoTime();
            long ExTime = EndTime - StartTime;
            double ratio;
            if (f == BigInteger.ZERO) {
               ratio = 0;
            }
            else if (f == BigInteger.ONE) {
               ratio = 1;
            }
            else {
               double n = fibonacciAlg.Fibonacci(i).doubleValue();
               double d = fibonacciAlg.Fibonacci(i - 1).doubleValue();
               ratio = n/d;
            } 
            printWriter.println(ratio + " , " + i);
            
         }
         printWriter.close();
      }
      catch (FileNotFoundException ex) {
         System.out.println("File not found.");
      }     
   
   }
} 
