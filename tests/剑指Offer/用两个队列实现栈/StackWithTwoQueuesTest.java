package 剑指Offer.用两个队列实现栈;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithTwoQueuesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int pop = stack.pop();
        assertEquals(pop, 3);

    }

    @Test
    public void pop() {
    }
}