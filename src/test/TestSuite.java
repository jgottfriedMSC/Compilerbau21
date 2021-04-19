package test;

public class TestSuite extends TestSuiteIntf {

	public TestSuite(compiler.FileReaderIntf fileReader, TestCaseIntf testCase) {
		super(fileReader, testCase);
	}

	@Override
	// testSequence: testCase*
	void readAndExecuteTestSequence() throws Exception {
		while (m_fileReader.lookAheadChar() != 0) {
			readAndExecuteTestCase();
		}
	}

	@Override
	// testCase: dollarIn testContent dollarOut testContent
	void readAndExecuteTestCase() throws Exception {
		readDollarIn();
		String input = readTestContent();
		readDollarOut();
		String output = readTestContent();
		executeTestCase(input, output);
	}

	@Override
	// testContent: [^$]*
	String readTestContent() throws Exception {
		// TODO Auto-generated method stub
		String testContent = new String("");
		while (m_fileReader.lookAheadChar() != '$' && m_fileReader.lookAheadChar() != 0) {
			testContent += m_fileReader.lookAheadChar();
			m_fileReader.advance();
		}
		return testContent;
	}

	@Override
	// dollarIn: "$IN" linebreak
	void readDollarIn() throws Exception {
		// TODO Auto-generated method stub
		m_fileReader.expect('$');
		m_fileReader.expect('I');
		m_fileReader.expect('N');
		m_fileReader.expect('\r');
		m_fileReader.expect('\n');
	}

	@Override
	// dollarOut: "$Out" linebreak
	void readDollarOut() throws Exception {
		// TODO Auto-generated method stub
		m_fileReader.expect('$');
		m_fileReader.expect('O');
		m_fileReader.expect('U');
		m_fileReader.expect('T');
		m_fileReader.expect('\r');
		m_fileReader.expect('\n');
	}

}
