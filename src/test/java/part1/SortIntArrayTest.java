package part1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;


public class SortIntArrayTest {
    private static int[] inputArray1, inputArray2, inputArray3, inputArray4, inputArray5;

    @BeforeClass
    public static void initInputs() {
        inputArray1 = new int[]{-1, 122, 33, -214, -15, 26, 170, -8, 0, 11};
        inputArray2 = new int[]{-1, -122, -33, -214, -15, -26, -170, -8, 0, -11};
        inputArray3 = new int[]{1, 122, 33, 214, 15, 26, 170, 8, 0, 11};
        inputArray4 = new int[]{0};
        inputArray5 = new int[]{};
    }

    @Test
    public void sortShouldReturnNonNullArray() {
        Assert.assertNotNull(SortIntArray.sort(inputArray1));
        Assert.assertNotNull(SortIntArray.sort(inputArray2));
        Assert.assertNotNull(SortIntArray.sort(inputArray3));
        Assert.assertNotNull(SortIntArray.sort(inputArray4));
        Assert.assertNotNull(SortIntArray.sort(inputArray5));
        Assert.assertNotNull(SortIntArray.sort(null));
    }

    @Test
    public void sortShouldReturnOnlyPositiveNumbersSortedDESC() {
        int[] expectedArray = new int[]{170, 122, 33, 26, 11, 0};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(inputArray1)));

        expectedArray = new int[]{0};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(inputArray2)));

        expectedArray = new int[]{214, 170, 122, 33, 26, 15, 11, 8, 1, 0};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(inputArray3)));

        expectedArray = new int[]{0};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(inputArray4)));

        expectedArray = new int[]{};
        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(inputArray5)));

        Assert.assertEquals(Arrays.toString(expectedArray), Arrays.toString(SortIntArray.sort(null)));
    }
}
