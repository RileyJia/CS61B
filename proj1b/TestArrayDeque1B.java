import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


public class TestArrayDeque1B{

    @Test
    public void testEqual(){
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDeque = new ArrayDequeSolution<>();
        String m = new String();
        int max = 30;

        for (int i = 0; i < max; i++){
            Integer insertNumber = StdRandom.uniform(max);

            switch (StdRandom.uniform(1,4)){
                case 1:
                    studentArrayDeque.addFirst(insertNumber);
                    arrayDeque.addFirst(insertNumber);
                    m = m + "\naddFirst(" + insertNumber + ")";
                    for ( int j = 0; j< studentArrayDeque.size(); j++) {
                        assertEquals(m, studentArrayDeque.get(j), arrayDeque.get(j));
                    }
                    break;
                case 2:
                    studentArrayDeque.addLast(insertNumber);
                    arrayDeque.addLast(insertNumber);
                    m = m + "\naddLast(" + insertNumber + ")";
                    for ( int j = 0; j< studentArrayDeque.size(); j++) {
                        assertEquals(m, studentArrayDeque.get(j), arrayDeque.get(j));
                    }
                    break;
                case 3:
                    if (studentArrayDeque.size() !=0 && arrayDeque.size() !=0) {
                        m = m + "\nremoveFirst()";
                        assertEquals(m,studentArrayDeque.removeFirst(),arrayDeque.removeFirst());
                    }
                    break;
                case 4:
                    if(studentArrayDeque.size() != 0 && arrayDeque.size() !=0){
                        m = m + "\nremoveLast()";
                        assertEquals(m,studentArrayDeque.removeLast(),arrayDeque.removeLast());
                    }
                    break;
                default:break;
            }
        }

        assertEquals("size()",studentArrayDeque.size(),arrayDeque.size());

    }
}