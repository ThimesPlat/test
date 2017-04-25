package model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ToMeg on 2017-04-23.
 */
public class SubjectTest {

    Subject testSub;
    String namn;

    @Before
    public void setUp() throws Exception {
        namn= "TestSubject";
        testSub= new Subject(namn);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNamn() throws Exception {

        Assert.assertEquals(namn, testSub.getNamn());

    }

}