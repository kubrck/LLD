package adapter;

// Concrete Target — plays MP3 natively, delegates other formats via Adapter
public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();

        if (extension.equals("mp3")) {
            System.out.println("AudioPlayer: Playing MP3 — " + filename);
        } else if (extension.equals("vlc") || extension.equals("mp4")) {
            MediaAdapter adapter = new MediaAdapter(extension);
            adapter.play(filename);
        } else {
            System.out.println("AudioPlayer: Format not supported — " + extension);
        }
    }
}
