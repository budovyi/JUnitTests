package mergesort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] array = {5, 3, 8, 12, 25, 1, 0, 45, 33, -4, 6, 7, 9, 14, 15, 58, 60, 77, -3};
        int[] expectedResult = {-4, -3, 0, 1, 3, 5, 6, 7, 8, 9, 12, 14, 15, 25, 33, 45, 58, 60, 77};
        MergeSort.sort(array);
        Assert.assertArrayEquals(expectedResult,array);
    }
}
