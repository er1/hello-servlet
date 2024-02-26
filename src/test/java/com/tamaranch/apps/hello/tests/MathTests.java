package com.tamaranch.apps.hello.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;


public class MathTests {

    @Test
    public void additionWorks() {
        assertEquals(2 + 3, 5);
    }
    
    @Disabled
    @Test
    public void additionIsNotAlwaysFour() {
        assertEquals(2 + 3, 4);
    }
    
}
