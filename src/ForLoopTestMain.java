import compiler.FileReader;
import test.TestSuite;
import test.TestSuiteIntf;

public class ForLoopTestMain {

    public static void main(String[] args) throws Exception {
        System.out.println("BEGIN");
        TestSuiteIntf test = new TestSuite(FileReader.fromFileName("ForLoopTestInput.txt"), new ForLoopTest());
        test.testRun();
        System.out.println("END");
    }

}
