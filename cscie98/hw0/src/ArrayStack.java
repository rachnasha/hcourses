/**
 * 1. Write a Java class ArrayStack that implements a stack of Objects. For this exercise, do not use the Java
 * collections library — use an Object[] to store the values.
 * • The stack should support three standard operations: void push(Object) to add an Object to the
 * stack, Object pop() to remove the most recent value added to the stack, and boolean isEmpty()
 * to determine whether there are any Objects on the stack.
 * • The stack should have a maximum size of 50. Your code should define and throw appropriate exceptions
 * in cases of stack overflow or underflow.
 */
public final class ArrayStack {
    protected final int MAX_STACK_SIZE = 50;
    protected final int MIN_STACK_SIZE = 0;
    private Object[] stack = new Object[MAX_STACK_SIZE];
    private int currentStackIndex = -1;

    public void push(Object obj) throws Exception {
        if (currentStackIndex >= MAX_STACK_SIZE) { // should never get to > 50 ever..
            throw new Exception("Stack Overflow");
        }
        currentStackIndex = currentStackIndex + 1;
        stack[currentStackIndex] = obj;

    }

    public Object pop() throws Exception {
        if (currentStackIndex < MIN_STACK_SIZE) {
            throw new Exception("Stack Underflow");
        }

        Object obj = stack[currentStackIndex];
        currentStackIndex = currentStackIndex - 1;
        return obj;
    }


    public boolean isEmpty() {
        return (currentStackIndex < MIN_STACK_SIZE);
    }

}


