import compiler.FileReader;

public class InterpreterMain {

	public static void main(String[] args) throws Exception {
		System.out.println("BEGIN");
		test.TestSuiteIntf test = new test.TestSuite(FileReader.fromFileName(args[0]), new InterpreterTest());
		test.testRun();
		System.out.println("END");
	}

}

