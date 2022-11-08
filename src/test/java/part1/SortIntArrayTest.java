package part1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SortIntArrayTest {
    private static int[] inputRandom, inputNegatives, inputPositives, inputZero, inputEmpty;

    @BeforeAll
    public static void initInputs() {
        inputRandom = new int[]{-1, 122, 33, -214, -15, 26, 170, -8, 0, 11};
        inputNegatives = new int[]{-1, -122, -33, -214, -15, -26, -170, -8, 0, -11};
        inputPositives = new int[]{1, 122, 33, 214, 15, 26, 170, 8, 0, 11};
        inputZero = new int[]{0};
        inputEmpty = new int[]{};
    }

    @Test
    public void sortShouldReturnNonNullArray() {
        assertNotNull(SortIntArray.sort(inputRandom));
        assertNotNull(SortIntArray.sort(inputNegatives));
        assertNotNull(SortIntArray.sort(inputPositives));
        assertNotNull(SortIntArray.sort(inputZero));
        assertNotNull(SortIntArray.sort(inputEmpty));
        assertNotNull(SortIntArray.sort(null));
    }

    @Test
    public void sortShouldReturnOnlyPositiveNumbersSortedDESC() {
        int[] expectedArray = new int[]{170, 122, 33, 26, 11, 0};
        assertArrayEquals(expectedArray, SortIntArray.sort(inputRandom));

        expectedArray = new int[]{0};
        assertArrayEquals(expectedArray, SortIntArray.sort(inputNegatives));

        expectedArray = new int[]{214, 170, 122, 33, 26, 15, 11, 8, 1, 0};
        assertArrayEquals(expectedArray, SortIntArray.sort(inputPositives));

        expectedArray = new int[]{0};
        assertArrayEquals(expectedArray, SortIntArray.sort(inputZero));

        expectedArray = new int[]{};
        assertArrayEquals(expectedArray, SortIntArray.sort(inputEmpty));

        assertArrayEquals(expectedArray, SortIntArray.sort(null));
    }
}
