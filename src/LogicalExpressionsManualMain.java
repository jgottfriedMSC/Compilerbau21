

import compiler.CompileEnv;

public class LogicalExpressionsManualMain {

    public static void main(String[] args) throws Exception {
        System.out.println("BEGIN");
        CompileEnv compiler = new CompileEnv("LogicalExpressionsManualInput.txt", false);
        compiler.compile();
        compiler.execute(System.out);
        System.out.println("END");
    }
}
