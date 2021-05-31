package compiler.logicalexpression.instruction;

import java.io.OutputStreamWriter;

import compiler.ExecutionEnvIntf;
import compiler.InstrIntf;

public class BitNot implements InstrIntf {
    /**
     * execute this instruction
     *
     * @param env
     */
    @Override
    public void execute(ExecutionEnvIntf env) {
        int op0 = env.popNumber();
        env.pushNumber(~op0);
    }

    /**
     * trace this instruction
     *
     * @param os
     */
    @Override
    public void trace(OutputStreamWriter os) throws Exception {
        os.write("BITNOT\n");
    }
}
