import java.util.Arrays;
import java.util.List;

public class Driver {
    private static long timeMs(Runnable r) 
    {
        long start = System.nanoTime();
        r.run();
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static void main(String[] args) 
    {
        List<Song> songs = Arrays.asList(
            new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 354),
            new Song(2, "Love of My Life", "Queen", "A Night at the Opera", 219),
            new Song(3, "Hotel California", "Eagles", "Hotel California", 391),
            new Song(4, "New Kid in Town", "Eagles", "Hotel California", 305),
            new Song(5, "Imagine", "John Lennon", "Imagine", 183),
            new Song(6, "Yesterday", "The Beatles", "Help!", 125),
            new Song(7, "Let It Be", "The Beatles", "Let It Be", 243)
        );

        SongService server = new SongServiceImpl(songs);
        SongService proxy = new SongServiceProxy(server);

        System.out.println("=== searchById(3) ===");
        final Song[] s = new Song[1];
        System.out.println("1st call (server): " + timeMs(() -> s[0] = proxy.searchById(3)) + " ms -> " + s[0]);
        System.out.println("2nd call (cache) : " + timeMs(() -> s[0] = proxy.searchById(3)) + " ms -> " + s[0]);

        System.out.println("\n=== searchByTitle(\"Imagine\") ===");
        final List<Song>[] l = new List[1];
        System.out.println("1st call (server): " + timeMs(() -> l[0] = proxy.searchByTitle("Imagine")) + " ms -> " + l[0]);
        System.out.println("2nd call (cache) : " + timeMs(() -> l[0] = proxy.searchByTitle("Imagine")) + " ms -> " + l[0]);

        System.out.println("\n=== searchByAlbum(\"A Night at the Opera\") ===");
        System.out.println("1st call (server): " + timeMs(() -> l[0] = proxy.searchByAlbum("A Night at the Opera")) + " ms");
        l[0].forEach(x -> System.out.println("   " + x));
        System.out.println("2nd call (cache) : " + timeMs(() -> l[0] = proxy.searchByAlbum("A Night at the Opera")) + " ms");

        System.out.println("\n=== searchById(1) after album search (id cache was populated) ===");
        System.out.println("call (cache)     : " + timeMs(() -> s[0] = proxy.searchById(1)) + " ms -> " + s[0]);

        System.out.println("\n=== Direct server call for comparison: searchById(3) ===");
        System.out.println("server           : " + timeMs(() -> s[0] = server.searchById(3)) + " ms");
    }
}