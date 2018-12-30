package com.steps.ui;

import com.utilities.Dummy2;
import com.utilities.DummyDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PicoHooks  {

    private DummyDriver base;
    private Dummy2 dum;
    public PicoHooks(DummyDriver base,Dummy2 dum)
    {
        this.base = base;
        this.dum  = dum;
    }

    @Before
    public void before()
    {
        base.text = "test pico ";
        System.out.println("before "+base.text + " dummy text "+ dum.temp);
    }

    @After
    public void after()
    {
        System.out.println("After "+ base.text);
    }

}
