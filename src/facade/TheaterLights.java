package facade;

public class TheaterLights {

    public void on()          { System.out.println("Theater Lights ON"); }
    public void dim(int level) { System.out.println("Theater Lights dimmed to " + level + "%"); }
}
