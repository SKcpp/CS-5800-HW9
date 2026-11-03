import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService 
{
    private final List<Song> songs;

    public SongServiceImpl(List<Song> songs) 
    { 
        this.songs = new ArrayList<>(songs); 
    }

    @Override 
    public Song searchById(Integer songID) 
    {
        try 
        { 
            Thread.sleep(1000); 
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Unable to find that song" + e.getMessage());
        }

        for (Song s : songs)
        {
            if (s.getId().equals(songID)) 
            {
                return s;
            }
        }
        return null;
    }

    @Override 
    public List<Song> searchByTitle(String title) 
    {
        try 
        { 
            Thread.sleep(1000); 
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Unable to find that song" + e.getMessage());
        }
        List<Song> result = new ArrayList<>();
        for (Song s : songs)
        {
            if (s.getTitle().equalsIgnoreCase(title))
            {
                result.add(s);
            } 
        } 
        return result;
    }

    @Override 
    public List<Song> searchByAlbum(String album) 
    {
        try 
        { 
            Thread.sleep(1000); 
        } 
        catch (InterruptedException e)
        {
            System.out.println("Unable to find that song" + e.getMessage());
        }
        List<Song> result = new ArrayList<>();
        for (Song s : songs)
        {
            if (s.getAlbum().equalsIgnoreCase(album))
            {
                result.add(s);
            }
        }
        return result;
    }
}