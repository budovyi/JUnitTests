package linkedarraylists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyLinkedListTest {
    private MyList<Integer> list;

    @Before
    public void init() {
        list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExpectedException() {
        list.get(7);
    }

    @Test
    public void testGetSuccessfully() {
        int expectedResult = 5;
        int actualResult = list.get(4);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddSuccessfully() {
        list.add(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExpectedIndexException() {
        list.remove(11);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveExpectedNullPointerException() {
        list.remove(-1);
    }

    @Test
    public void testRemoveSuccessfully() {
        list.remove(1);
    }

    @Test
    public void testSizeSuccessfully() {
        int expectedResult = 5;
        int actualResult = list.size();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
