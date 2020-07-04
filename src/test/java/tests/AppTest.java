package tests;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private static final String EOL = System.getProperty("line.separator");
    private PrintStream console;
    private ByteArrayOutputStream bytes;

    @Test
    public void testAbortWhenInsufficientArgumentsSupplied() throws IOException {
        Matrix.main();
        assertEquals(Matrix.MSG_TOO_FEW_ARGUMENTS + EOL + Matrix.USAGE + EOL, bytes.toString());
    }

    @Test
    public void testAbortWhenTooManyArgumentsSupplied() throws IOException {
        //matrix.main("5", "b", "c");
        //assertEquals(matrix.MSG_TOO_MANY_ARGUMENTS + EOL + matrix.USAGE + EOL, bytes.toString());
    }
}