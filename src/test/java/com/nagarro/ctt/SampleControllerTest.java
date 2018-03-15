package com.nagarro.ctt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


@RunWith(BlockJUnit4ClassRunner.class)
public class SampleControllerTest {

    SampleController target;
    
    @Before
    public void setup(){
        target = new SampleController();
    }
    
    @Test
    public void testGetData(){
        Assert.assertEquals("Ctt Test assigment",target.getData());
    }
    
}
