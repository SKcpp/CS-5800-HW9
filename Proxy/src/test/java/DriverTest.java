import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class DriverTest 
{
    @Test 
    public void mainRunsAndShowsCacheBenefit() 
    {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf));

        try 
        { 
            Driver.main(new String[0]); 
        } 
        finally 
        { 
            System.setOut(old); 
        }
        
        String out = buf.toString();
        assertTrue(out.contains("1st call (server)"));
        assertTrue(out.contains("2nd call (cache)"));
        assertTrue(out.contains("Hotel California"));
    }
}