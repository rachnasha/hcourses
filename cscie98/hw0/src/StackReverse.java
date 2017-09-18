/**
 * 2. Write a second class StackReverse with a function that uses the stack data structure that you implemented
 * in the previous problem to reverse the elements in an array of Integer objects.
 * • Your array reversal function should take a single Integer[] parameter and return void. When the
 * method returns, the order of the elements in the supplied array should be reversed.
 * • Implement a reversal algorithm using the push, pop and isEmpty methods on the ArrayStack class.
 * Do not use recursion, the Collections classes or other non-stack-based algorithm to reverse the array.
 * • Do not assume anything about the size of the Integer[] being passed in. Your code should work cleanly
 * if the array has any number of elements from zero to 10,000
 */

public class StackReverse {

    // not storing any state , simply mutate the input array.
    public static void reverse(Integer[] arrToReverse) throws Exception {
        int size = arrToReverse.length;
        Integer[] copy = new Integer[size];
        System.arraycopy(arrToReverse, 0, copy, 0, size);
        ArrayStack stack = new ArrayStack();
        int arrayIndex = 0;

        while (arrayIndex < size) {
            for (int i = 0; i < stack.MAX_STACK_SIZE; i++) {
                //populate stack after another check of arrayIndex. needed
                // as we are interating until we hit the max stack size.
                if (arrayIndex < (size)) {
                    stack.push(copy[arrayIndex]);
                    arrayIndex++;
                }
            }
            // now mutate the array , populating the bottom index with the
            // elements popped off the stack.
            int j = arrayIndex;
            while (!stack.isEmpty()) {
                arrToReverse[size - j] = (Integer) stack.pop();
                j--;
            }

        }
    }

}
