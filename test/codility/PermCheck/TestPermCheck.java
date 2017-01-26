package codility.PermCheck;

import static org.junit.Assert.*;

import org.junit.Test;

import codility.CodilitySolution;


public class                    TestPermCheck
extends                         CodilitySolution                    {


    @Test
    public void         testSingleValueOk() {
        assertEquals(1, invokeI("solution",new int [] { 1}));
    }

    @Test
    public void         testSingleValueBad() {
        assertEquals(0, invokeI("solution",new int [] { 2}));
        assertEquals(0, invokeI("solution",new int [] { 3}));
        assertEquals(0, invokeI("solution",new int [] {-1}));
    }

    @Test
    public void         testPairValuesOk() {
        assertEquals(1, invokeI("solution",new int [] {1,2}));
    }

    @Test
    public void         testPairValuesBad() {
        assertEquals(0, invokeI("solution",new int [] {2,4}));
        assertEquals(0, invokeI("solution",new int [] {-1,1}));
        assertEquals(0, invokeI("solution",new int [] {1,3}));
    }


    @Test
    public void         testDuplicate() {
        assertEquals(0, invokeI("solution",new int [] {1,2,2,3,4,6}));
    }


}
