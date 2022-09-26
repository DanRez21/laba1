package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Test
    public void step1(){
        assertEquals( 0, calc.add(""));
        assertEquals(1, calc.add("1"));
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void step2(){
        assertEquals(18, calc.add("1,2,3,5,7"));
        assertEquals(0, calc.add("0,0,0,0"));
        assertEquals(21, calc.add("3,1,0,8,9,0,0"));
    }

    @Test
    public void step3(){
        assertEquals(3, calc.add("1\n2"));
        assertEquals(25, calc.add("1\n2,5,8,9"));
        assertEquals(19, calc.add("8\n3\n8"));
        assertEquals(31, calc.add("6\n9,3\n8,1\n4"));
    }

    @Test
    public void step4(){
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(25, calc.add("//!\n3!5,7!9\n1"));
        assertEquals(23, calc.add("//[*]\n9*5*7*2"));
        assertEquals(15, calc.add("//del\n2del5del8del"));
    }

    @Test
    public void step5(){
        assertThrows(IllegalArgumentException.class, () -> calc.add("-1,-2,-3"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("-3,2,1,4,7"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("6,3,2,-1"));
    }

    @Test
    public void step6(){
        assertEquals(1999, calc.add("1000,999,1001"));
        assertEquals(0, calc.add("1003,1002,1001"));
        assertEquals(2994, calc.add("997,998,999"));
    }

    @Test
    public void step7(){
        assertEquals(6, calc.add("//[!]\n1!!2!!3"));
        assertEquals(15, calc.add("//[@!b]\n5@!b8,2\n0"));
        assertEquals(22, calc.add("//[xxx]\n6xxx7xxx9"));
    }

    @Test
    public void step8(){
        assertEquals(25, calc.add("//[;][?]\n6;2,8?6;1\n2"));
        assertEquals(22, calc.add("//[{][}][s]\n9{0}1{4s8"));
        assertEquals(10, calc.add("//[!][!][!]\n3!6!1"));
    }

    @Test
    public void step9(){
        assertEquals(20, calc.add("//[;;][!]\n2;;0!!18"));
        assertEquals(12, calc.add("//[s][xx][{}]\n6{}3s2xx1"));
        assertEquals(34, calc.add("//[*][**]\n6**24***4"));
    }
}