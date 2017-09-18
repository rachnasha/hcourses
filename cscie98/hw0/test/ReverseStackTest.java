import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests for {@link ArrayStack}.
 */
public class ReverseStackTest extends TestCase {


    public void testReverseSize5() throws Exception {
        Integer[] input = new Integer[5];
        int i = 0;
        while (i < 5) {
            input[i] = i;
            i++;
        }
        Integer[] before = {0, 1, 2, 3, 4};
        Integer[] after = {4, 3, 2, 1, 0};
        assertArrayEquals(input, before);
        StackReverse.reverse(input);
        assertArrayEquals(input, after);


    }


    public void testReverseSize0() throws Exception {
        Integer[] input = new Integer[0];
        assertArrayEquals(input, input);
        StackReverse.reverse(input);
        assertArrayEquals(input, input);


    }


    public void testReverseSize10000() throws Exception {
        Integer[] input = new Integer[10000];
        Integer[] expectedAfter = new Integer[10000];

        int i = 0, j = 9999;

        while (i < 10000) {
            input[i] = i;
            expectedAfter[j] = i;
            i++;
            j--;
        }

        StackReverse.reverse(input);
        assertArrayEquals(input, expectedAfter);


    }

}