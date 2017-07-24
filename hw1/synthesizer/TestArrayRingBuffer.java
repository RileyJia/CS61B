package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    ArrayRingBuffer<Integer> arb;
    @Test
    public void someTest() {
        arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        arb.enqueue(3);
        System.out.println(arb.peek());
        System.out.println(arb.dequeue());
        System.out.println(arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
