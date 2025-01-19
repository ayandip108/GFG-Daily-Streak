//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
       Set<String>set = new HashSet<>();
       for(String word:wordList)set.add(word);
       set.remove(startWord); // we will remove start word if it is present
       Queue<ArrayList<String>>queue = new LinkedList<>();
       ArrayList<ArrayList<String>>ans = new ArrayList<>();
       
       ArrayList<String>list = new ArrayList<>();
       list.add(startWord);
       queue.add(list);
       
       while(!queue.isEmpty()){
           int size = queue.size();
           List<String>usedWord = new ArrayList<>();  // The list will store all used words in this level.
           while(size-->0){
               ArrayList<String>res = queue.poll();
               String word = res.get(res.size()-1);
               if(word.equals(targetWord)){
                   ans.add(new ArrayList<>(res));
               }
               char[]charArray = word.toCharArray();
               for(int i=0;i<charArray.length;i++){
                   char orignalChar = charArray[i];
                   for(char c='a'; c<='z';c++){
                       charArray[i] = c;
                       String nextWord = String.valueOf(charArray);
                       if(set.contains(nextWord)){
                           res.add(nextWord);
                           usedWord.add(nextWord);
                           queue.add(new ArrayList<>(res));
                           res.remove(res.size()-1);
                        }
                    }
                    charArray[i] = orignalChar;
                }
           }
           for(String w:usedWord)set.remove(w); // remove words from set after completed level. 
           if(ans.size()!=0)break; // becuase if we will not break may be possible the answer will come in next level also so it's better to keeping shortest path from startWord to targetWord we can break.
       }
       
       return ans;
    }
}