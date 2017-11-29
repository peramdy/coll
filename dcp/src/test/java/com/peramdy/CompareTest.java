package com.peramdy;

import com.peramdy.cp.config.*;
import com.peramdy.cp.service.*;
import junit.framework.TestCase;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class CompareTest extends TestCase {

    public void testOne() {
        C3p0Service.queryC3p0(C3p0Ds.CreateDataSource(), 100000);
        DruidService.queryDruid(DruidDs.CreateDateSource(), 100000);
        HikariCpService.queryHikariCp(HikariDs.CreateDateSource(), 100000);
        ProxoolService.queryProxool(ProxoolDs.CreateDateSource(), 100000);
        TomcatJdbcService.queryTomcatJdbc(TomcatJdbc0Ds.CreateDataSource(), 100000);
    }

}
