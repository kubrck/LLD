package facade;

public class StreamingPlayer {

    public void on()               { System.out.println("Streaming Player ON"); }
    public void off()              { System.out.println("Streaming Player OFF"); }
    public void play(String movie) { System.out.println("Streaming Player playing \"" + movie + "\""); }
    public void stop()             { System.out.println("Streaming Player stopped"); }
}
