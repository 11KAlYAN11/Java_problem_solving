package Strings;

/*
=====================================================================================
                        JAVA REGEX COMPLETE MASTERCLASS
=====================================================================================

PACKAGE:
--------
java.util.regex

MAIN CLASSES:
-------------
1. Pattern
2. Matcher

=====================================================================================
WHAT IS REGEX?
=====================================================================================

Regex (Regular Expression) is a pattern matching mechanism used for:

- Validation
- Searching
- Extracting
- Replacing
- Splitting
- Parsing

=====================================================================================
REAL WORLD USAGE
=====================================================================================

Used in:
--------
- Email Validation
- Password Validation
- Mobile Validation
- Log Parsing
- Search Engines
- Spring Validation
- Compilers
- NLP
- Web Scraping
- Security Filtering

=====================================================================================
BASIC FLOW
=====================================================================================

1. Compile Pattern
2. Create Matcher
3. Perform Match

Example:
--------
Pattern p = Pattern.compile("Java");
Matcher m = p.matcher("I love Java");
m.find();

=====================================================================================
IMPORTANT METHODS
=====================================================================================

Pattern Methods:
----------------
compile()

Matcher Methods:
----------------
find()
matches()
group()
start()
end()
replaceAll()
replaceFirst()

=====================================================================================
REGEX META CHARACTERS
=====================================================================================

.   -> Any character
*   -> 0 or more
+   -> 1 or more
?   -> 0 or 1
^   -> Start
$   -> End
[]  -> Character set
()  -> Grouping
{}  -> Count
|   -> OR
\\  -> Escape

=====================================================================================
PREDEFINED CHARACTER CLASSES
=====================================================================================

\\d  -> Digit
\\D  -> Non-digit
\\w  -> Word character
\\W  -> Non-word
\\s  -> Whitespace
\\S  -> Non-whitespace

=====================================================================================
QUANTIFIERS
=====================================================================================

x*      -> 0 or more
x+      -> 1 or more
x?      -> optional
x{3}    -> exactly 3
x{2,5}  -> 2 to 5

=====================================================================================
VERY IMPORTANT JAVA POINT
=====================================================================================

In Java:
--------
Backslash must be escaped.

Actual Regex:
-------------
\d

Java String:
------------
"\\d"

=====================================================================================
COMPLETE PROGRAM STARTS
=====================================================================================
*/

import java.util.regex.*;

public class JavaRegexMasterClass {

    public static void main(String[] args) {

        /* ========================================================================
           1. SIMPLE FIND
           ======================================================================== */

        System.out.println("================ SIMPLE FIND ================");

        Pattern pattern1 = Pattern.compile("Java");

        Matcher matcher1 = pattern1.matcher("I love Java and Spring");

        System.out.println("Found: " + matcher1.find());

        System.out.println();

        /* ========================================================================
           2. find() vs matches()
           ======================================================================== */

        System.out.println("============ find() vs matches() ============");

        Pattern pattern2 = Pattern.compile("Java");

        Matcher matcher2 = pattern2.matcher("I love Java");

        System.out.println("find(): " + matcher2.find());

        Matcher matcher3 = pattern2.matcher("I love Java");

        System.out.println("matches(): " + matcher3.matches());

        System.out.println();

        /* ========================================================================
           3. EXTRACT DIGITS
           ======================================================================== */

        System.out.println("============= EXTRACT DIGITS =============");

        String text = "Java 17 released in 2023";

        Pattern digitPattern = Pattern.compile("\\\\d+");

        Matcher digitMatcher = digitPattern.matcher(text);

        while (digitMatcher.find()) {

            System.out.println("Match: " + digitMatcher.group());
            System.out.println("Start: " + digitMatcher.start());
            System.out.println("End: " + digitMatcher.end());

            System.out.println();
        }

        /* ========================================================================
           4. CHARACTER CLASS
           ======================================================================== */

        System.out.println("=========== CHARACTER CLASS ===========");

        String regex1 = "[a-z]+";

        System.out.println("java".matches(regex1));
        System.out.println("JAVA".matches(regex1));

        System.out.println();

        /* ========================================================================
           5. MOBILE VALIDATION
           ======================================================================== */

        System.out.println("========== MOBILE VALIDATION ==========");

        String mobileRegex = "\\\\d{10}";

        System.out.println("9876543210".matches(mobileRegex));
        System.out.println("98765".matches(mobileRegex));

        System.out.println();

        /* ========================================================================
           6. EMAIL VALIDATION
           ======================================================================== */

        System.out.println("=========== EMAIL VALIDATION ===========");

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        System.out.println(
                "abc@gmail.com".matches(emailRegex)
        );

        System.out.println(
                "abcgmail.com".matches(emailRegex)
        );

        System.out.println();

        /* ========================================================================
           7. PASSWORD VALIDATION
           ======================================================================== */

        System.out.println("========= PASSWORD VALIDATION =========");

        /*
        Rules:
        ------
        1 uppercase
        1 lowercase
        1 digit
        1 special char
        minimum 8 chars
        */

        String passwordRegex =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=]).{8,}$";

        System.out.println(
                "Java@123".matches(passwordRegex)
        );

        System.out.println(
                "java123".matches(passwordRegex)
        );

        System.out.println();

        /* ========================================================================
           8. REPLACE ALL
           ======================================================================== */

        System.out.println("============= REPLACE ALL =============");

        String sentence = "Java 17 version";

        String replaced =
                sentence.replaceAll("\\\\d", "*");

        System.out.println(replaced);

        System.out.println();

        /* ========================================================================
           9. SPLIT
           ======================================================================== */

        System.out.println("================ SPLIT ================");

        String skills = "Java,Spring,Docker,Kubernetes";

        String[] arr = skills.split(",");

        for (String s : arr) {
            System.out.println(s);
        }

        System.out.println();

        /* ========================================================================
           10. OR OPERATOR
           ======================================================================== */

        System.out.println("============= OR OPERATOR =============");

        String orRegex = "Java|Python";

        System.out.println("Java".matches(orRegex));
        System.out.println("Python".matches(orRegex));
        System.out.println("C++".matches(orRegex));

        System.out.println();

        /* ========================================================================
           11. STARTS WITH
           ======================================================================== */

        System.out.println("============= STARTS WITH =============");

        String startRegex = "^Java";

        System.out.println(
                Pattern.compile(startRegex)
                        .matcher("Java is good")
                        .find()
        );

        System.out.println();

        /* ========================================================================
           12. ENDS WITH
           ======================================================================== */

        System.out.println("============== ENDS WITH ==============");

        String endRegex = "Spring$";

        System.out.println(
                "Java Spring".matches(".*" + endRegex)
        );

        System.out.println();

        /* ========================================================================
           13. CASE INSENSITIVE FLAG
           ======================================================================== */

        System.out.println("========= CASE INSENSITIVE =========");

        Pattern casePattern = Pattern.compile(
                "java",
                Pattern.CASE_INSENSITIVE
        );

        Matcher caseMatcher =
                casePattern.matcher("JAVA");

        System.out.println(caseMatcher.find());

        System.out.println();

        /* ========================================================================
           14. GREEDY MATCHING
           ======================================================================== */

        System.out.println("=========== GREEDY MATCHING ===========");

        String html = "<h1>Hello</h1>";

        Pattern greedy = Pattern.compile("<.*>");

        Matcher greedyMatcher = greedy.matcher(html);

        while (greedyMatcher.find()) {
            System.out.println(greedyMatcher.group());
        }

        System.out.println();

        /* ========================================================================
           15. LAZY MATCHING
           ======================================================================== */

        System.out.println("============ LAZY MATCHING ============");

        Pattern lazy = Pattern.compile("<.*?>");

        Matcher lazyMatcher = lazy.matcher(html);

        while (lazyMatcher.find()) {
            System.out.println(lazyMatcher.group());
        }

        System.out.println();

        /* ========================================================================
           16. PAN CARD VALIDATION
           ======================================================================== */

        System.out.println("========== PAN VALIDATION ==========");

        String panRegex = "[A-Z]{5}[0-9]{4}[A-Z]";

        System.out.println(
                "ABCDE1234F".matches(panRegex)
        );

        System.out.println(
                "abc123".matches(panRegex)
        );

        System.out.println();

        /* ========================================================================
           17. AADHAAR VALIDATION
           ======================================================================== */

        System.out.println("========= AADHAAR VALIDATION =========");

        String aadhaarRegex = "\\\\d{12}";

        System.out.println(
                "123456789012".matches(aadhaarRegex)
        );

        System.out.println();

        /* ========================================================================
           18. REMOVE EXTRA SPACES
           ======================================================================== */

        System.out.println("========= REMOVE EXTRA SPACES =========");

        String messy = "Java     Spring      Docker";

        System.out.println(
                messy.replaceAll("\\\\s+", " ")
        );

        System.out.println();

        /* ========================================================================
           19. EXTRACT WORDS
           ======================================================================== */

        System.out.println("=========== EXTRACT WORDS ============");

        Pattern wordPattern = Pattern.compile("\\\\w+");

        Matcher wordMatcher =
                wordPattern.matcher("Java Spring Boot");

        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }

        System.out.println();

        /* ========================================================================
           20. LOOKAHEAD EXAMPLE
           ======================================================================== */

        System.out.println("=========== LOOKAHEAD EXAMPLE ============");

        String lookAheadRegex = "Java(?=17)";

        Matcher lookAheadMatcher =
                Pattern.compile(lookAheadRegex)
                        .matcher("Java17 Java11");

        while (lookAheadMatcher.find()) {
            System.out.println(lookAheadMatcher.group());
        }

        System.out.println();

        /* ========================================================================
           21. LOOKBEHIND EXAMPLE
           ======================================================================== */

        System.out.println("=========== LOOKBEHIND EXAMPLE ============");

        String lookBehindRegex = "(?<=Rs\\\\.)\\\\d+";

        Matcher lookBehindMatcher =
                Pattern.compile(lookBehindRegex)
                        .matcher("Price Rs.500");

        while (lookBehindMatcher.find()) {
            System.out.println(lookBehindMatcher.group());
        }

        System.out.println();

        /* ========================================================================
           22. NON DIGITS
           ======================================================================== */

        System.out.println("=========== NON DIGITS ============");

        System.out.println(
                "Java123".replaceAll("\\\\D", "")
        );

        System.out.println();

        /* ========================================================================
           23. ONLY ALPHABETS
           ======================================================================== */

        System.out.println("=========== ONLY ALPHABETS ============");

        System.out.println(
                "Java".matches("[a-zA-Z]+")
        );

        System.out.println();

        /* ========================================================================
           24. ONLY ALPHANUMERIC
           ======================================================================== */

        System.out.println("=========== ALPHANUMERIC ============");

        System.out.println(
                "Java123".matches("[a-zA-Z0-9]+")
        );

        System.out.println();

        /* ========================================================================
           25. FINAL INTERVIEW SUMMARY
           ======================================================================== */

        System.out.println("=========== FINAL SUMMARY ============");

        System.out.println("Regex = Pattern Matching");
        System.out.println("Pattern = Compiles regex");
        System.out.println("Matcher = Performs matching");
        System.out.println("find() = Partial match");
        System.out.println("matches() = Full match");
        System.out.println("String internally supports regex methods");

        System.out.println();

        /* ========================================================================
           PERFORMANCE TIP
           ======================================================================== */

        System.out.println("=========== PERFORMANCE TIP ============");

        System.out.println(
                "Reuse compiled Pattern objects for better performance"
        );
    }
}
