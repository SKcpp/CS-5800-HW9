import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterPropertiesTest 
{
    private final CharacterProperties p = new CharacterProperties("Arial", 12, "Red");

    @Test 
    public void getFont()  
    { 
        assertEquals("Arial", p.getFont()); 
    }

    @Test 
    public void getSize()  
    { 
        assertEquals(12, p.getSize());
    }

    @Test 
    public void getColor() 
    { 
        assertEquals("Red", p.getColor()); 
    }

    @Test 
    public void equalsSameValues() 
    {
        assertEquals(p, new CharacterProperties("Arial", 12, "Red"));
    }

    @Test 
    public void equalsDifferentValues() 
    {
        assertNotEquals(p, new CharacterProperties("Arial", 14, "Red"));
        assertNotEquals(p, new CharacterProperties("Calibri", 12, "Red"));
        assertNotEquals(p, new CharacterProperties("Arial", 12, "Blue"));
        assertNotEquals(p, null);
        assertNotEquals(p, "Arial/12/Red");
    }
    @Test public void hashCodeConsistentWithEquals() 
    {
        assertEquals(p.hashCode(), new CharacterProperties("Arial", 12, "Red").hashCode());
    }
    @Test public void toStringFormat() 
    { 
        assertEquals("Arial/12/Red", p.toString()); 
    }
}