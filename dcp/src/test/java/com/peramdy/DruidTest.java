package com.peramdy;

import com.peramdy.cp.config.DruidDs;
import com.peramdy.cp.service.DruidService;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class DruidTest extends TestCase {

    public void testOne() {
        DruidService.queryDruid(DruidDs.CreateDateSource(), 100);
    }

}
