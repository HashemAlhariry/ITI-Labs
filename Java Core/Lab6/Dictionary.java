import java.util.*;

public class Dictionary {

    public static void main(String[] args) {

        String [] arr = {"Hashem","Hazem","Khaled","Hany","Mohammed","Kholod","Tamer","Hagras","Hagar","Ahmed","Adel"};
        
        Map<Character, TreeSet<String>> dictionary = new TreeMap<>();

        for (String s: arr) {

            TreeSet<String> treeSet = dictionary.get(s.charAt(0));
            if (treeSet == null)
            {
                treeSet = new TreeSet();
                dictionary.put(s.charAt(0),treeSet);

            }
            treeSet.add(s);

        }


        printMap(dictionary);
        printLetter(dictionary,'H');

    }

    public static void printMap(Map<Character,TreeSet<String>>dictionary){
        for (Object objectName : dictionary.keySet()) {
            System.out.println(objectName);
            System.out.println(dictionary.get(objectName));
        }
    }

    public static void printLetter(Map<Character,TreeSet<String>>map,char letter){
        TreeSet<String> treeSet = map.get(letter);
        if(treeSet==null) {
            System.out.println("this letter has no words");
        }
        else{
            System.out.print("All Name Attached to Character: ");
            System.out.println(treeSet);
        }

    }
}
