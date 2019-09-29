package HomeWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Main {
    private static void PrintSet(String[] S){
        HashSet<String> set = new HashSet<>(Arrays.asList(S));
        System.out.println(set);
    }

    private static void WordsNumber(String[] S){
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:S) {
            if(map.containsKey(s)) map.put(s, map.get(s) + 1);
            else  map.put(s, 1);
        }
        System.out.println(map);
    }
    public static void main(String[] args) {
        String[] S = {"a", "b", "c", "c", "d", "e", "f", "f", "g", "h", "i", "g", "k", "d",
                "e", "f", "f", "g", "h", "i", "g", "k", "u", "y"};
        PrintSet(S);
        WordsNumber(S);


    }
}
