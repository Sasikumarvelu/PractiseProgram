package ProjectExample2;

import java.util.*;

public class FindDuplicateUsingMapAndSet {
void ToFindDuplicate(){
    String str;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the line or word to find duplicate");
    str = scanner.nextLine().replace(" ","");
    char [] arr = str.toCharArray();
    Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
    for (char ch: arr) {
        if (charMap.containsKey(ch)){
            charMap.put(ch , charMap.get(ch) + 1);
        }else {
            charMap.put(ch,1);
        }
    }
        Set<Character> charSet = charMap.keySet();
        for (char ch :charSet) {
            if (charMap.get(ch) >1){
                System.out.println("Character "+ ch +" duplicated for "+ charMap.get(ch) + " times");
            }else {
                System.out.println("Character "+ ch +" is not duplicated");
            }

        }
        }
        public static void main(String[] args) {
        FindDuplicateUsingMapAndSet usingMapAndSet = new FindDuplicateUsingMapAndSet();
        usingMapAndSet.ToFindDuplicate();
    }
}
