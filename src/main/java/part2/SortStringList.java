package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
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
        Set<String> set = new HashSet<>();

        for (String line : inputList) {
            if (line == null) line = "";

            set.addAll(List.of(line.split("\\s")));
            lineUniqueWords.addAll(set);
            set.clear();
        }

        return lineUniqueWords.stream()
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}