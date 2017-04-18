import junit.framework.Test;
import junit.framework.TestSuite;

public class Sample {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(sample.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
