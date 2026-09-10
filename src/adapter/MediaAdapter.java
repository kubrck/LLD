package adapter;

/*
 * Adapter — bridges the gap between MediaPlayer (target) and
 * AdvancedMediaPlayer (adaptee). Translates the play() call into
 * the appropriate advanced player method.
 */
public class MediaAdapter implements MediaPlayer {

    private final AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) {
        advancedPlayer = switch (audioType.toLowerCase()) {
            case "vlc" -> new VlcPlayer();
            case "mp4" -> new Mp4Player();
            default    -> throw new IllegalArgumentException("Unsupported format: " + audioType);
        };
    }

    @Override
    public void play(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        if (extension.equals("vlc")) {
            advancedPlayer.playVlc(filename);
        } else if (extension.equals("mp4")) {
            advancedPlayer.playMp4(filename);
        }
    }
}
