package com.cdac1.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AssertEquals {



	    @Test
	    public void testAddition() {
	        int result = 2 + 3;
	        assertEquals(result, 5, "Addition should be correct");
	    }


	    @Test
	    public void testSubtraction() {
	        int result = 5 - 2;
	        assertEquals(result, 3, "Subtraction should be correct");
	    }
	}
