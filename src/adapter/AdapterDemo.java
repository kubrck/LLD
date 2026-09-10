package adapter;

/*
 * Adapter Pattern — Media Player
 *
 * Intent: Convert the interface of a class into another interface that clients
 * expect. Adapter lets classes work together that otherwise couldn't because of
 * incompatible interfaces.
 *
 * Real-world use: Integrating third-party libraries, legacy system migration,
 * format converters (JSON <-> XML), payment gateway integrations.
 */
public class AdapterDemo {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("song.mp3");
        player.play("movie.mp4");
        player.play("video.vlc");
        player.play("audio.wav"); // unsupported
    }
}
