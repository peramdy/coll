package com.peramdy;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * Created by peramdy on 2017/12/1.
 */
public class JmeterTest extends AbstractJavaSamplerClient {


    /**
     * input java parameters
     *
     * @return
     */
    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("a", "1");
        arguments.addArgument("a", "2");
        return arguments;
    }


    /**
     * @param context
     */
    @Override
    public void setupTest(JavaSamplerContext context) {
        super.setupTest(context);
    }


    /**
     * @param javaSamplerContext
     * @return
     */
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        javaSamplerContext.getParameter("a");
        javaSamplerContext.getParameter("b");

        return null;
    }


    /**
     * @param context
     */
    @Override
    public void teardownTest(JavaSamplerContext context) {
        super.teardownTest(context);
    }
}
