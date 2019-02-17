import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SecondTaskTest {

    @Test
    public void testSuccessfulRestoreArray() {
        SecondTask st = new SecondTask();
        int[] expectedResult = {1, 2, 3, 4, 7, 6, 5, 4} ;
        int[] actualResult = st.restoreArray(new int[]{1, 2, -1, 4, 7, 6, -2, 4});

        Assert.assertArrayEquals(expectedResult,actualResult);
    }
}
