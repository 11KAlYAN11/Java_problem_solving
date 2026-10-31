package Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Java");

        Matcher matcher = pattern.matcher("I Love Java & India");

        System.out.println(matcher.find());


        Pattern.compile("Java")
                .matcher("I love Java")
                .find();

        Pattern.compile("Java")
                .matcher("I Love Java")
                .matches();        
    }
    
}
