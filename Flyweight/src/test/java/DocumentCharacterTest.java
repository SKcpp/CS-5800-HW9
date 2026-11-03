import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class DocumentCharacterTest 
{
    private final CharacterProperties props = CharacterPropertiesFactory.get("Arial", 12, "Red");
    private final DocumentCharacter dc = new DocumentCharacter('x', props);

    @Test 
    public void getValue()      
    { 
        assertEquals('x', dc.getValue()); 
    }

    @Test 
    public void getProperties() 
    { 
        assertSame(props, dc.getProperties()); 
    }
}