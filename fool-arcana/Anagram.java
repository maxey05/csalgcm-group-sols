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

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
        if(s.length() % 2 != 0)
            return -1;
        
        String sub1 = s.substring(0, s.length()/2);
        String sub2 = s.substring(s.length()/2, s.length());
        
        int[] charCount = new int[26];
        
        for(int i = 0; i < sub1.length(); i++)
        {
            charCount[sub1.charAt(i) - 'a']++;
            charCount[sub2.charAt(i) - 'a']--;
        }
        
        int moves = 0;
        for(int j = 0; j < charCount.length; j++)
        {
            if(charCount[j] > 0)
                moves+=charCount[j]; 
        }

        return moves;
    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
