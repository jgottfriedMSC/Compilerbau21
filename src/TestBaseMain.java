import compiler.FileReader;
import test.TestSuite;

public class TestBaseMain {

	public static void main(String[] args) throws Exception {
		System.out.println("BEGIN");
		test.TestSuiteIntf test = new TestSuite(FileReader.fromFileName(args[0]), new TestCase());
		test.testRun();
		System.out.println("END");
	}

}
