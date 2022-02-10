package msdingfield;

import com.google.common.base.Preconditions;

/**
 * Convert an integer into a string with the integer written out in English.
 *
 * Examples
 *
 *   0 => "zero"
 *   1 => "one"
 *   10 => "ten"
 *   100 => "one hundred"
 *   101 => "one hundred one"
 *
 * This uses the short-scale system commonly used in English-speaking countries (https://en.wikipedia.org/wiki/Long_and_short_scale)
*/
public class IntToWord {

    private IntToWord() {
        /* prevent instantiation */
    }

    private static final String[] simpleIntToString = {
        "",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen"
    };

    private static final String[] tensToString = {
        "",
        "ten",
        "twenty",
        "thirty",
        "forty",
        "fifty",
        "sixty",
        "seventy",
        "eighty",
        "ninety"
    };

    private static final String[] levels = {
        "",
        "thousand",
        "million",
        "billion" // Java 'int' cannot represent numbers greater than billions
    };

    /**
     * Convert integer into its English word equivalent.
     *
     * @param n number to convert
     * @return number as words
     */
    public static String toWord(int n) {
        if (n == 0) {
            return "zero";
        } else {
            String words = toWordInternal(Math.abs(n));
            if (n < 0) {
                return join("negative", words);
            } else {
                return words;
            }
        }
    }

    private static String toWordInternal(int n) {
        return toWordRecursive(n, 0);
    }

    private static String toWordRecursive(int n, int level) {
        if (n == 0) {
            return "";
        }
        return join(
            toWordRecursive(n / 1000, level + 1),
            toWordSimple(n % 1000, level)
        );
    }

    private static String toWordSimple(int n, int level) {
        String levelWord = toWordSimpleValue(n);
        return levelWord.isEmpty() ? "" : join(levelWord, levels[level]);
    }


    private static String toWordSimpleValue(int n) {
        Preconditions.checkArgument(n < 1000);
        if (n < 20) {
            return simpleIntToString[n];
        } else if (n < 100) {
            return join(tensToString[n / 10], simpleIntToString[n % 10]);
        } else {
            return join(simpleIntToString[n / 100] + " hundred", toWordSimpleValue(n % 100));
        }
    }

    private static String join(String s1, String s2) {
        if (s2.isEmpty()) {
            return s1;
        } else if (s1.isEmpty()) {
            return s2;
        } else {
            return s1 + " " + s2;
        }
    }

}
