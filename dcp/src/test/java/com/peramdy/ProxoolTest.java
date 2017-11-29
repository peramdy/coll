package com.peramdy;

import com.peramdy.cp.config.ProxoolDs;
import com.peramdy.cp.service.ProxoolService;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class ProxoolTest extends TestCase {

    public void testOne() {
        ProxoolService.queryProxool(ProxoolDs.CreateDateSource(), 100);
    }

}
