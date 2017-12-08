package com.peramdy.memcached;

import com.peramdy.memcache.HelloWord;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/12/8.
 */
public class HelloTest extends TestCase {

    public void testOne() {
        HelloWord helloWord = new HelloWord();
        helloWord.simpleOne();
    }

    public void testTwo() {
        HelloWord helloWord = new HelloWord();
        helloWord.simpleTwo();
    }

    public void testThree() {
        HelloWord helloWord = new HelloWord();
        helloWord.simpleThree();
    }

}
