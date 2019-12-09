package chapter5;

import java.util.Stack;

import java.util.EmptyStackException;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

//Write unit test for methods push and pop of class Stack. Use a fixture that you initialize before every test, and make sure your tests cover documented exceptional behavior.

public class JoshTestStack {

    private final String FOO = "FOO";
    private final String BAR = "BAR";

    private Stack<String> stack;

    @BeforeEach
    private void initStack() {
        stack = new Stack<String>();
    }

    @Test
    public void testPush_empty() {
        assertSame(FOO, stack.push(FOO));
        assertSame(FOO, stack.peek());
    }

    @Test
    public void testPush_nonEmpty() {
        stack.push(BAR);
        assertSame(FOO, stack.push(FOO));
        assertSame(FOO, stack.peek());
    }

    //LMAO what is this
    @Test
    public void testPop_empty() {
        assertThrows(EmptyStackException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                stack.pop();
            }
        });
    }

    @Test
    public void testPop_nonEmpty() {
        stack.push(FOO);
        assertSame(FOO, stack.pop());
        assertTrue(stack.isEmpty());
    }

}