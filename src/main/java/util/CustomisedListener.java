package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class CustomisedListener  implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Method Started" +context.getName() );
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("PASSED TEST CASES");
            System.out.println("Test Method OnFinished" +context.getName() );

    }
}
