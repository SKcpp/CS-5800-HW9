import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterPropertiesFactoryTest 
{
    @Test 
    public void getReturnsSameInstanceForSameProperties() 
    {
        CharacterProperties a = CharacterPropertiesFactory.get("TestFontA", 10, "Green");
        CharacterProperties b = CharacterPropertiesFactory.get("TestFontA", 10, "Green");
        assertSame(a, b);
    }

    @Test 
    public void getReturnsDifferentInstanceForDifferentProperties() 
    {
        CharacterProperties a = CharacterPropertiesFactory.get("TestFontB", 10, "Green");
        CharacterProperties b = CharacterPropertiesFactory.get("TestFontB", 11, "Green");
        assertNotSame(a, b);
    }

    @Test 
    public void getStoresCorrectValues() 
    {
        CharacterProperties p = CharacterPropertiesFactory.get("TestFontC", 18, "Pink");
        assertEquals("TestFontC", p.getFont());
        assertEquals(18, p.getSize());
        assertEquals("Pink", p.getColor());
    }

    @Test 
    public void countGrowsOnlyForNewProperties() 
    {
        int before = CharacterPropertiesFactory.count();
        CharacterPropertiesFactory.get("TestFontD", 9, "Teal");
        assertEquals(before + 1, CharacterPropertiesFactory.count());
        CharacterPropertiesFactory.get("TestFontD", 9, "Teal");
        assertEquals(before + 1, CharacterPropertiesFactory.count());
    }
}