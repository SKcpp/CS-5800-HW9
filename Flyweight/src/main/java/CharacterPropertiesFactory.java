import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory 
{
    private static final Map<String, CharacterProperties> cache = new HashMap<>();

    private CharacterPropertiesFactory() {}

    public static CharacterProperties get(String font, int size, String color) 
    {
        String key = font + "|" + size + "|" + color;
        CharacterProperties p = cache.get(key);
        if (p == null) 
        {
            p = new CharacterProperties(font, size, color);
            cache.put(key, p);
        }
        return p;
    }

    public static int count() { return cache.size(); }
}