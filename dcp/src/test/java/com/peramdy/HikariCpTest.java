package com.peramdy;

import com.peramdy.cp.config.HikariDs;
import com.peramdy.cp.service.HikariCpService;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class HikariCpTest extends TestCase {

    public void testOne() {
        HikariCpService.queryHikariCp(HikariDs.CreateDateSource(), 100);
    }

}
