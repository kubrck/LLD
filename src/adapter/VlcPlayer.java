package adapter;

// Concrete Adaptee — plays VLC files natively
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String filename) {
        System.out.println("VlcPlayer: Playing VLC file — " + filename);
    }

    @Override
    public void playMp4(String filename) {
        // VLC player doesn't handle MP4 natively here
    }
}
