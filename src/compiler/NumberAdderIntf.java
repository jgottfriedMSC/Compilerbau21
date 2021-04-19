package compiler;

public interface NumberAdderIntf {
	
    // creates a NumberAdder for a given FileReader
	// NumberAdderIntf(FileReaderIntf reader)
	
	/** 
	 * reads sum from FileReader
	 * grammar: sum : NUMBER ("+"|"-" NUMBER)*
	 * 
	 * @throws Exception
	 */
	int getSum() throws Exception;
}
