package part1;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortIntArray {
    /**
     * @param array the input array of random ints, including negative;
     * @return only positive ints sorted in descending order OR an empty int[] if the input is NULL;
     */
    public static int[] sort(int[] array) {
        return Stream.ofNullable(array).flatMapToInt(IntStream::of)
                .boxed().filter(i -> i >= 0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
