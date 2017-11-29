package com.peramdy;

import com.peramdy.cp.config.C3p0Ds;
import com.peramdy.cp.service.C3p0Service;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class C3p0Test extends TestCase {

    public void testOne() {
        C3p0Service.queryC3p0(C3p0Ds.CreateDataSource(), 100);
    }

}
