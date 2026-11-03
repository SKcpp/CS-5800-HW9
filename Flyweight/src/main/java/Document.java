import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Document 
{
    private final List<DocumentCharacter> characters = new ArrayList<>();

    public void addCharacter(char c, String font, int size, String color) 
    {
        characters.add(new DocumentCharacter(c, CharacterPropertiesFactory.get(font, size, color)));
    }

    public void addText(String text, String font, int size, String color) 
    {
        for (char c : text.toCharArray()) addCharacter(c, font, size, color);
    }

    public void editCharacter(int index, char c, String font, int size, String color) 
    {
        characters.set(index, new DocumentCharacter(c, CharacterPropertiesFactory.get(font, size, color)));
    }

    public void removeCharacter(int index) 
    { 
        characters.remove(index);
    }

    public int length() 
    { 
        return characters.size(); 
    }

    public String getText() 
    {
        StringBuilder sb = new StringBuilder();
        for (DocumentCharacter dc : characters) sb.append(dc.getValue());
        return sb.toString();
    }

    public void save(String filename) throws IOException 
    {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) 
        {
            for (DocumentCharacter dc : characters) 
            {
                CharacterProperties p = dc.getProperties();
                out.println((int) dc.getValue() + "," + p.getFont() + "," + p.getSize() + "," + p.getColor());
            }
        }
    }

    public static Document load(String filename) throws IOException 
    {
        Document doc = new Document();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = in.readLine()) != null) 
            {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                doc.addCharacter((char) Integer.parseInt(f[0]), f[1], Integer.parseInt(f[2]), f[3]);
            }
        }
        return doc;
    }

    public void print() 
    {
        for (DocumentCharacter dc : characters) 
        {
            CharacterProperties p = dc.getProperties();
            System.out.printf("'%c'  %-8s %2d  %-5s  (props id %08x)%n",
                    dc.getValue(), p.getFont(), p.getSize(), p.getColor(), System.identityHashCode(p));
        }
    }
}