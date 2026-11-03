import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService 
{
    private final SongService realService;
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realService) 
    { 
        this.realService = realService; 
    }

    @Override 
    public Song searchById(Integer songID) 
    {
        if (idCache.containsKey(songID))
        { 
            return idCache.get(songID);
        }

        Song s = realService.searchById(songID);
        if (s != null)
        {
            idCache.put(songID, s);
        } 
        return s;
    }

    @Override 
    public List<Song> searchByTitle(String title) 
    {
        String key = title.toLowerCase();
        List<Song> cached = titleCache.get(key);

        if (cached != null) 
        {
            return new ArrayList<>(cached);
        }

        List<Song> result = realService.searchByTitle(title);
        titleCache.put(key, new ArrayList<>(result));

        for (Song s : result) 
        {
            idCache.put(s.getId(), s);
        }
        return result;
    }

    @Override 
    public List<Song> searchByAlbum(String album) 
    {
        String key = album.toLowerCase();
        List<Song> cached = albumCache.get(key);

        if (cached != null) 
        {
            return new ArrayList<>(cached);
        }

        List<Song> result = realService.searchByAlbum(album);
        albumCache.put(key, new ArrayList<>(result));

        for (Song s : result) 
        {
            idCache.put(s.getId(), s);
        }
        return result;
    }
}