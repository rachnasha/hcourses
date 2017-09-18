

import junit.framework.TestCase;

/**
 * Tests for {@link ArrayStack}.
 */
public class ArrayStackTest extends TestCase {


    public void testPushStackSimple() {
        ArrayStack as = new ArrayStack();
        assertTrue(as.isEmpty());
        for (int i = 0; i < as.MAX_STACK_SIZE; i++) {
            try {
                as.push(i); // autobox
            }
            catch (Exception e) {
                fail("Unexpected Exception. Message =" + e.getMessage());
            }
        }
        assertFalse(as.isEmpty());
    }

    public void testStackOverflow() {
        ArrayStack as = new ArrayStack();
        assertTrue(as.isEmpty());
        try {
            for (int i = 0; i < as.MAX_STACK_SIZE + 2; i++) {
                as.push(i); // autobox
            }
            fail("expected stack overflow");
        }
        catch (Exception e) {
            // do nothing for now.
        }

    }


    public void testPopStackSimple() {
        ArrayStack as = new ArrayStack();
        assertTrue(as.isEmpty());
        for (int i = 0; i < as.MAX_STACK_SIZE; i++) {
            try {
                as.push(i); // autobox
            }
            catch (Exception e) {
                assert (e.getMessage().equals("Stack Overflow"));
            }
        }

        for (int j = as.MAX_STACK_SIZE - 1; j >= 0; j--) {
            try {
                assertTrue((Integer) as.pop() == j);
            }
            catch (Exception e) {
                fail("Unexpected Exception. Message =" + e.getMessage());
            }
        }

    }


    public void testStackUnderflow() {
        ArrayStack as = new ArrayStack();
        assertTrue(as.isEmpty());
        try {
            for (int i = 0; i < as.MAX_STACK_SIZE; i++) {
                as.push(i); // autobox
            }
            while (!as.isEmpty()) {
                as.pop();
            }
            as.pop();
            fail("expected Stack Underflow");

        }
        catch (Exception e) {
            // do nothing for now.
        }

    }


}