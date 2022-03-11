import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class SentenceToCount {

        public static void main(String[] args) {

                String sentence = "abc bb cc dd ff aa ss abc ss ss yyy aa cc ss ss ww ss";
                String word = "abc";
                StringTokenizer string = new StringTokenizer(sentence);
                int count=0;
                while(string.hasMoreTokens()){
                        if(string.nextToken().equals(word)){
                                count++;
                        }
                }
                System.out.println(count);

        }


}
// First one with substring

/*
     Scanner sc= new Scanner(System.in);
            System.out.print("Enter a word to serch on it : ");
            String wordToSearch = sc.nextLine();
            System.out.print("Enter string : ");
            String string = sc.nextLine();
            Pattern pattern = Pattern.compile(wordToSearch);
            Matcher matcher = pattern.matcher(string);
            boolean matchFound = matcher.find();
            int count=0;
            if(matchFound) {
                for(int i=0;i<string.length() - wordToSearch.length()+1 ;i++) {
                  if(  wordToSearch.compareTo(string.substring(i,i+wordToSearch.length())) ==0  )
                            count++;
                }
                System.out.println("Number of occurrence "+ count);
            } else {
                System.out.println("Match not found");
            }
*/

// Second one with substring

/*

     Scanner sc= new Scanner(System.in);
                System.out.print("Enter a word to serch on it : ");
                String wordToSearch = sc.nextLine();
                System.out.print("Enter string : ");
                String string = sc.nextLine();
                Pattern pattern = Pattern.compile(wordToSearch);
                Matcher matcher = pattern.matcher(string);
                boolean matchFound = matcher.find();
                int count=0;
                if(matchFound) {
                        int index=0;
                        while(true){
                             index = string.indexOf(wordToSearch,index);

                             if(index!= -1){
                                     count++;
                                     index= index+wordToSearch.length();
                             }else{
                                     break;
                             }

                        }
                        System.out.println("Number of occurrence "+ count);

                } else {
                        System.out.println("Match not found");
                }
 */


//Third one
/*
  String sentence = "abc bb cc dd ff aa ss abc ss ss yyy aa cc ss ss ww ss";
                String word = "abc";
                StringTokenizer string = new StringTokenizer(sentence);
                int count=0;
                while(string.hasMoreTokens()){
                        if(string.nextToken().equals(word)){
                                count++;
                        }
                }
                System.out.println(count);

 */




// Fourth one
/*


                Scanner sc= new Scanner(System.in);
                System.out.print("Enter a word to serch on it : ");
                String wordToSearch = sc.nextLine();

                System.out.print("Enter string : ");
                String string = sc.nextLine();
                int numberOfOccurence=0;
                int count = 0;
                for (int i = 0; i < string.length(); i++) {
                        if(string.charAt(i) == ' ')
                                count++;
                }
                System.out.println("spaces number: " + count);
                int lastIndex=0;
                int firstIndex=0;

                for (int i = 0; i < count+1; i++) {
                        lastIndex = string.indexOf(' ', firstIndex);
                         //System.out.println("Last Index: "+ lastIndex);

                        if(lastIndex != -1){
                              //System.out.println("Entered");
                           if(wordToSearch.compareTo(string.substring(firstIndex,lastIndex))==0){
                                   numberOfOccurence++;
                           }
                          firstIndex=lastIndex+1;
                        }
                        else if (lastIndex == -1) {
                                break;
                        }

                }

                System.out.println("Number of occurence " + numberOfOccurence);


 */





























