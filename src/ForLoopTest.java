import compiler.CompileEnv;
import compiler.FileReaderIntf;
import test.TestCaseIntf;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class ForLoopTest implements TestCaseIntf {

    @Override
    public String executeTest(FileReaderIntf fileReader) throws Exception {
        CompileEnv compiler = new CompileEnv(fileReader, false);
        compiler.compile();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        compiler.execute(outStream);
        return outStream.toString(String.valueOf(StandardCharsets.UTF_8));
    }

}
