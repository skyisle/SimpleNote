package com.the42apps.simplenote;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by skyisle on 3/18/15.
 */
public class SampleTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSetupOk() {
        assertTrue(true);
    }

    @Test
    public void testAlwaysFail() {
        fail();
    }
}