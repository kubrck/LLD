package adapter;

// Concrete Adaptee — plays MP4 files natively
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String filename) {
        // MP4 player doesn't handle VLC natively here
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("Mp4Player: Playing MP4 file — " + filename);
    }
}
