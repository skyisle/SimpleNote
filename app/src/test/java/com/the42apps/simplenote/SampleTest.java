package com.the42apps.simplenote;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by skyisle on 3/18/15.
 */
public class SampleTest {

    @Before
    public void setUp() throws Exception {
        // setup test
    }

    @Test
    public void testSetupOk() {
        assertTrue(true);
    }

    @Test
    public void testAlwaysFail() {
        fail();
    }

    @After
    public void tearDown() {
        // clean up test
    }
}