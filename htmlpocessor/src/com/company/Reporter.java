package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Created by Velychko on 17.03.2017.
 */
class Reporter {

    private static final String DELIMITERS_TO_SPLIT = "\\.|\" \"|,|;|-|\n";

    String report(String content) {
        List<String> words = Arrays.asList(content.split(DELIMITERS_TO_SPLIT));
        Map<String, Long> wordsMap = words.stream()
                .filter(this::onlyLetters)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        long wordQuantity = 0;
        for (Long value : wordsMap.values()) {
            wordQuantity = wordQuantity + value;
        }
        System.out.println("Quantity of words :" + wordQuantity);
        for (Map.Entry<String, Long> entry : wordsMap.entrySet()) {
            System.out.println("Word " + entry.getKey() + " : " + entry.getValue());
        }
        return content;
    }

    private boolean onlyLetters(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

}
