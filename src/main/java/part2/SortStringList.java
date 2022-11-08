package part2;

import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortStringList {
    /**
     * @param inputList a list of strings. Each may contain duplicate words and #hashtags.
     * @return LinkedHashMap with 5 most common #hashtags in the input list sorted by descending.
     * Ignores specific string's duplicate words while counting.
     * @throws NullPointerException if input is NULL;
     */
    public static Map<String, Long> top5Tags(List<String> inputList) {
        List<String> lineUniqueWords = new ArrayList<>();
        inputList.forEach(line -> lineUniqueWords.add(getUniqueWords(line)));

        StringBuilder sb = new StringBuilder();
        lineUniqueWords.forEach(w -> sb.append(w).append(" "));

        return Arrays.stream(sb.toString().split("\\s"))
                .filter(w -> w.startsWith("#"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
    /**
     * @param str the input line of words. May contain #hashtags.
     * @return line with only unique words or an empty String if input is NULL;
     */
     protected static String getUniqueWords(String str) {
        if (str == null) return "";

        StringBuilder sb = new StringBuilder();
        Arrays.stream(str.split("\\s")).distinct().forEach(w -> sb.append(w).append(" "));
        return sb.toString().trim();
    }
}