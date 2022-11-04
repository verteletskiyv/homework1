package part1;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortIntArray {
    public static int[] sort(int[] array) {
        return Stream.ofNullable(array).flatMapToInt(IntStream::of)
                .boxed().filter(i -> i >= 0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
