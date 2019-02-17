import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ThirdTaskTest {

    @Test
    public void testSuccessfulFindRanges(){
        ThirdTask tt = new ThirdTask();
        String expectedResult = "[1 3][5][8 10][13 16]";
        String actualResult = tt.findRanges(new int[] {1, 2, 3, 5, 8, 9, 10, 13, 14, 15, 16});
        Assert.assertEquals(expectedResult,  actualResult);
    }
}
