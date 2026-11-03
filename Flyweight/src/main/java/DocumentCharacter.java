public class DocumentCharacter 
{
    private final char value;
    private final CharacterProperties properties;

    public DocumentCharacter(char value, CharacterProperties properties) 
    {
        this.value = value;
        this.properties = properties;
    }

    public char getValue() 
    { 
        return value; 
    }

    public CharacterProperties getProperties() 
    { 
        return properties;
    }
}