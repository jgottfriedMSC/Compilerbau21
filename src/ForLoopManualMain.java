import compiler.CompileEnv;

public class ForLoopManualMain {

    public static void main(String[] args) throws Exception {
        System.out.println("BEGIN");
        CompileEnv compiler = new CompileEnv("ForLoopManualInput.txt");
        compiler.compile();
        compiler.execute(System.out);
        System.out.println("END");
    }

}
