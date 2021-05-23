

import compiler.FileReader;
import test.TestSuite;
import test.TestSuiteIntf;

public class LogicalExpressionsTestMain {

    public static void main(String[] args) throws Exception {
        System.err.println("BEGIN");
        TestSuiteIntf test = new TestSuite(FileReader.fromFileName("LogicalExpressionsTestInput.txt"), new LogicalExpressionsTest());
        test.testRun();
        System.err.println("END");
    }
}
