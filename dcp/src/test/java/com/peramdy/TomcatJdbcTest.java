package com.peramdy;

import com.peramdy.cp.config.TomcatJdbc0Ds;
import com.peramdy.cp.service.TomcatJdbcService;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class TomcatJdbcTest extends TestCase {

    public void testOne() {
        TomcatJdbcService.queryTomcatJdbc(TomcatJdbc0Ds.CreateDataSource(), 100);
    }

}
