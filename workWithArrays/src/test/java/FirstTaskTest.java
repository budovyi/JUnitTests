import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class FirstTaskTest {

    @Test
    public void testSuccessfulArrayRotation() {
        FirstTask ft = new FirstTask();
        int[] expectedResult = {8, 12, 1, 5, 4, 3};
        int[] actualResult = ft.rotateElements(3, new int[]{5, 4, 3, 8, 12, 1});
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
