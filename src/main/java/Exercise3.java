import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String regex = "http.*"+"://.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
            return matcher.group();
        }
        else{
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "@";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        int count=0;
        int indice=0;
        while (matcher.find()){
            count++;
            indice=matcher.start();
        }
        //System.out.println("number of @: "+count);
        if (count==1) {
            //System.out.println("indices of where @ locate: " + indices);
            String username = email.substring(0, indice);
            System.out.println("username: " + username);
            regex = "\\W";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(username);
            if (matcher.find()) {
                //System.out.println("invalid email");
                return false;
            }
            else {
                //System.out.println("validated email");
                return true;
            }
        }
        else {
            //System.out.println("invalid email");
            return false;
        }
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters=new ArrayList<>();
        String regex="\\W";
        Pattern pattern=Pattern.compile(regex);
        String[] arr_input=pattern.split(input);
        for (String s : arr_input) {
            //System.out.println(s);
            for (int i=0;i<s.length()-1;i++){
                if (s.substring(i+1).contains(s.substring(i,i+1))){
                    //System.out.println(s);
                    wordsWithRepeatLetters.add(s);
                    break;
                };
            }
        }
        return wordsWithRepeatLetters;
    }

    /*
    Bonus Problem ;)p
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String input) {
        List<String> repeatedWords=new ArrayList<>();
        String regex="\\W";
        Pattern pattern=Pattern.compile(regex);
        String[] arr_input=pattern.split(input);
        for (String s:arr_input){
            for (int i=0;i<s.length();i++){
                if (s.substring(0,i+1).equals(s.substring(i+1))){
                    repeatedWords.add(s);break;
                }
            }
        }
        //System.out.println(repeatedWords);
        return repeatedWords;

    }

    public static void main(String[] args) {
        // test your code here!
    }
}