package regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Useful regex matching patterns.
 *
 * @author ruifengm
 * @since 2018-Jun-22
 */
public class RegexMatch {

    /**
     * Matching event strings like below where event name is followed by duration, and lightning means "5 minutes".
     * - Talk show 10 min
     * - Movie screening 60minutes
     * - Reading a book 120min
     * - Walk lightning
     * - Break 3 eggs 2 MIN
     */
    private static class Event {
        String eventName;
        int duration; // in minutes

        public Event(String name, int duration) {
            this.eventName = name;
            this.duration = duration;
        }

        public void print() {
            System.out.println("[Name=" + eventName + ",Duration=" + duration + " min]\n");
        }
    }

    private static final Pattern INPUT_EVENT_PATTERN = Pattern.compile("(?i)^(.+)\\s+((\\d+)\\s*(min(|ute)s?)|(lightning))$"); // greedy quantifier
    private static final int EVENT_NAME_IDX = 1;
    private static final int DURATION_NUMBER_IDX = 3;
    private static final int LIGHTNING_IDX = 6;

    private static Event parseEvent(String s) {
        Matcher regexMatcher = INPUT_EVENT_PATTERN.matcher(s);
        if (!regexMatcher.find()) return null;
        System.out.println("Regex group count: " + regexMatcher.groupCount());
        for (int i = 0; i <= regexMatcher.groupCount(); i++)
            System.out.println("Group " + i + ": " + regexMatcher.group(i));
        String name = regexMatcher.group(EVENT_NAME_IDX).trim();
        int duration;
        if (regexMatcher.group(LIGHTNING_IDX) != null) duration = 5;
        else duration = Integer.parseInt(regexMatcher.group(DURATION_NUMBER_IDX));
        return new Event(name, duration);
    }

    /**
     * Use negative look-arounds
     * https://stackoverflow.com/questions/406230/regular-expression-to-match-a-line-that-doesnt-contain-a-word
     */
    private static final Pattern EXCLUSION_PATTERN = Pattern.compile("^((?!bar).)*$");

    private static boolean testXORRegex(String s) {
        System.out.println(s);
        Matcher m = EXCLUSION_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println("Regex group count: " + m.groupCount());
            for (int i = 0; i <= m.groupCount(); i++) System.out.println("Group " + i + ": " + m.group(i));
            return true;
        }
        return false;
    }

    /**
     * Match IPV4 IP address
     * https://stackoverflow.com/questions/5284147/validating-ipv4-addresses-with-regexp
     * https://www.rexegg.com/regex-lookarounds.html
     * https://www.rexegg.com/regex-disambiguation.html#negative-lookbehind
     * Non-capturing groups by (?: re) are to avoid unwanted sub-matches.
     */
//    private static final Pattern IPV4_PATTERN = Pattern.compile("((?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)((?<!\\.)\\b|\\.)){4}");
    private static final String IPV4_BYTE_REGEX = "25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?";
    private static final Pattern IPV4_PATTERN = Pattern.compile("(?:(?:" + IPV4_BYTE_REGEX + ")\\.){3}" + "((" + IPV4_BYTE_REGEX + "))");

    private static List<String> parseIPv4Addresses(String s) {
        System.out.println("Input string: " + s);
        List<String> matches = new ArrayList<>();

        Matcher m = IPV4_PATTERN.matcher(s);
        while (m.find()) {
            matches.add(m.group());
            for (int i=0; i<m.groupCount(); i++) System.out.println("Group " + i + ": " + m.group(i));
        }

        return matches;
    }

    /**
     * Roman numeric string matching
     */
    private static final Pattern ROMAN_NUMBER_PATTERN = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    private static final Pattern ROMAN_SYMBOL_PATTERN = Pattern.compile("CM|M|CD|D|XC|C|XL|L|IX|X|IV|V|I");

    private static boolean isValidRomanNumber(String romanNumeralString) {
        System.out.println("Input string: " + romanNumeralString);
        List<String> matches = new ArrayList<>();

        Matcher m = ROMAN_NUMBER_PATTERN.matcher(romanNumeralString);
        while (m.find()) {
            matches.add(m.group());
            for (int i=0; i<m.groupCount(); i++) System.out.println("Group " + i + ": " + m.group(i));
        }

        System.out.println("Matches found:" + matches);
        return ! matches.isEmpty();
    }

    private static List<String> parseRomanNumber(String romanNumeralString) {
        System.out.println("Input string: " + romanNumeralString);
        // if ( ! isValidRomanNumber(romanNumeralString)) return Collections.EMPTY_LIST;

        List<String> matches = new ArrayList<>();

        Matcher m = ROMAN_SYMBOL_PATTERN.matcher(romanNumeralString);

        while (m.find()) {
            matches.add(m.group());
            for (int i=0; i<m.groupCount(); i++) System.out.println("Group " + i + ": " + m.group(i));
        }

        return matches;
    }

    /**
     * Capturing group with quantifier
     */
    private static final Pattern REPEATED_GROUP_PATTERN = Pattern.compile("(\\d\\s+){4}");
    private static List<String> parseRepeatedGroupsWithQuantifier(String numStr) {
        System.out.println("Input string: " + numStr);

        List<String> matches = new ArrayList<>();

        Matcher m = REPEATED_GROUP_PATTERN.matcher(numStr);

        while (m.find()) {
            matches.add(m.group());
            for (int i=0; i<m.groupCount(); i++) System.out.println("Group " + i + ": " + m.group(i));
        }

        return matches;
    }

    public static void main(String[] args) {
        /* Event matching */
        System.out.println("\n============ Event Matching (Start) ============");
        String e1 = "Talk show 10 min";
        parseEvent(e1).print();
        String e2 = "Movie screening 60minutes";
        parseEvent(e2).print();
        String e3 = "Break 3 eggs 2 MIN";
        parseEvent(e3).print();
        String e4 = "Walk lightning";
        parseEvent(e4).print();
        String e5 = "Walk 2 min lightning";
        parseEvent(e5).print();
        String e6 = "Run 10 mins";
        parseEvent(e6).print();
        String e7 = "Sleep     20      minute";
        parseEvent(e7).print();
        String e8 = "    20      minute";
        parseEvent(e8).print();
        System.out.println("============ Event Matching (End)===========\n");

        /* Exclusion matching */
        System.out.println("\n============ Exclusive Matching (Start) ============");
        String s1 = "foo";
        System.out.println(testXORRegex(s1));
        String s2 = "bar";
        System.out.println(testXORRegex(s2));
        String s3 = "foobar";
        System.out.println(testXORRegex(s3));
        String s4 = "testfoobartest";
        System.out.println(testXORRegex(s4));
        System.out.println("============ Exclusive Matching (End)===========\n");

        /* IPv4 address parsing */
        System.out.println("\n============ IPv4 Matching (Start) ============");
        String ipStr1 = "127.0.0.124.198.192.3.45.123.4.5.6.7";
        for (String match : parseIPv4Addresses(ipStr1)) System.out.println(">>> Match: " + match);

        String ipStr2 = "91.2.3.1. .8. 0.1.7... .4.5..";
        for (String match : parseIPv4Addresses(ipStr2)) System.out.println(">>> Match: " + match);
        System.out.println("============ IPv4 Matching (End)===========\n");

        /* Roman number matching */
        System.out.println("\n============ Roman Number Matching (Start) ============");
        String romanNumStr = "MMMCMXCIX";
        System.out.println("Is valid Roman number? " + isValidRomanNumber(romanNumStr));
        System.out.println("============ Roman Number Matching (End)===========\n");

        /* Roman number parsing */
        System.out.println("\n============ Roman Number Parsing (Start) ============");
        for (String match : parseRomanNumber("MMMCDLXXXIV")) System.out.println(">>> Match: " + match);
        System.out.println("============ Roman Number Parsing (End)===========\n");        /* Roman number parsing */

        /* Repeated capturing group with quantifier */
        System.out.println("\n============ Roman Number Parsing (Start) ============");
        for (String match : parseRepeatedGroupsWithQuantifier("1 2 5 3 ")) System.out.println(">>> Match: " + match);
        System.out.println("============ Roman Number Parsing (End)===========\n");

    }

}
