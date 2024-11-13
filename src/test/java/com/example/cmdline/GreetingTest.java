package com.example.cmdline;

import com.example.Greeting;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GreetingTest {

    @Test
    public void sayHi() {
        PrintStream out = System.out;
        ByteArrayOutputStream outCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outCaptor));
        Greeting.sayHi();
        Assert.assertEquals("Hi!", outCaptor.toString().trim());
        System.setOut(out);
    }

}