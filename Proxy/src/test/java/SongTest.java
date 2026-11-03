import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SongTest 
{
    private final Song s = new Song(1, "Imagine", "John Lennon", "Imagine", 183);

    @Test 
    public void getId()       
    { 
        assertEquals(Integer.valueOf(1), s.getId()); 
    }

    @Test 
    public void getTitle()    
    { 
        assertEquals("Imagine", s.getTitle()); 
    }

    @Test 
    public void getArtist()   
    {
        assertEquals("John Lennon", s.getArtist()); 
    }

    @Test 
    public void getAlbum()    
    { 
        assertEquals("Imagine", s.getAlbum()); 
    }

    @Test 
    public void getDuration() 
    { 
        assertEquals(183, s.getDuration()); 
    }

    @Test public void toStringContainsAllFields() 
    {
        String t = s.toString();
        assertTrue(t.contains("id=1"));
        assertTrue(t.contains("Imagine"));
        assertTrue(t.contains("John Lennon"));
        assertTrue(t.contains("183"));
    }
}