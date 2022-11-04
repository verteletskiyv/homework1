package part2;

import java.util.*;
import java.util.stream.Collectors;

public class SortStringList {
    public static Map<String, Long> top5(List<String> inputList) {
        if (inputList == null) return Collections.emptyMap();

        List<String> lineUniqueWords = new ArrayList<>();
        inputList.forEach(line -> lineUniqueWords.add(getUniqueWords(line)));

        StringBuilder sb = new StringBuilder();
        lineUniqueWords.forEach(w -> sb.append(w).append(" "));

        List<String> uniqueWords = Arrays.asList(sb.toString().split("\\s"));

        return uniqueWords.stream().filter(ht -> ht.startsWith("#"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    static String getUniqueWords(String str) {
        if (str == null) return "";

        StringBuilder sb = new StringBuilder();
        List<String> words = Arrays.asList(str.split("\\s"));
        words.stream().distinct().forEach(w -> sb.append(w).append(" "));
        return sb.toString().trim();
    }
}
