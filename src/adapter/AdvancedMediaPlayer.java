package adapter;

// Adaptee interface — the incompatible interface we need to integrate
public interface AdvancedMediaPlayer {
    void playVlc(String filename);
    void playMp4(String filename);
}
