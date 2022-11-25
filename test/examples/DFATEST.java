package examples;

import nfa.NFA;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DFATEST {

    @Test
    public void testAutomatonA(){
        NFA fa = new NFA(0);
        fa.addRule(0, '0', 0);
        fa.addRule(0, '1', 1);
        fa.addRule(1, '0', 2);
        fa.addRule(1, '1', 3);
        fa.addRule(2, '0', 0);
        fa.addRule(2, '1', 1);
        fa.addRule(3, '0', 2);
        fa.addRule(3, '1', 3);
        fa.addAcceptState(0);


        fa.readString("0");
        assertEquals(true, fa.accepts());

        fa.readString("00");
        assertEquals(true, fa.accepts());

        fa.readString("11");
        assertEquals(false, fa.accepts());

        fa.readString("11001");
        assertEquals(false, fa.accepts());

    }
    @Test
    public void testAutomatonB() {
        NFA fa = new NFA(1);
        fa.addRule(1, '0', 2);
        fa.addRule(1, '1', 4);
        fa.addRule(2, '0', 1);
        fa.addRule(2, '1', 3);
        fa.addRule(3, '0', 4);
        fa.addRule(3, '1', 2);
        fa.addRule(4, '0', 3);
        fa.addRule(4, '1', 1);
        fa.addAcceptState(2);
        fa.addAcceptState(4);


        fa.readString("110101010");
        assertEquals(true, fa.accepts());





    }

    @Test
    public void testAutomatonC() {
        NFA fa = new NFA(1);
        fa.addRule(1, '1', 2);
        fa.addRule(1, '0', 2);
        fa.addRule(2, '1', 3);
        fa.addRule(2, '0', 2);
        fa.addRule(3, '1', 1);
        fa.addAcceptState(1);
        fa.addAcceptState(2);
        fa.addAcceptState(3);

        fa.readString("010");
        assertEquals(false, fa.accepts());

    }
}


