package composite;

/*
 * Composite Pattern — File System
 *
 * Intent: Compose objects into tree structures to represent part-whole hierarchies.
 * Composite lets clients treat individual objects (File) and compositions (Directory)
 * uniformly through a common interface.
 *
 * Real-world use: File systems, UI component trees, org charts, menus.
 */
public class CompositeDemo {

    public static void main(String[] args) {
        // Build a file tree
        Directory root = new Directory("root");

        Directory src = new Directory("src");
        src.add(new File("Main.java",   12));
        src.add(new File("App.java",    8));

        Directory test = new Directory("test");
        test.add(new File("MainTest.java", 5));

        Directory resources = new Directory("resources");
        resources.add(new File("config.yml", 2));
        resources.add(new File("banner.png", 150));

        root.add(src);
        root.add(test);
        root.add(resources);
        root.add(new File("README.md", 3));

        // Client treats the entire tree uniformly
        root.display("");

        System.out.println("\nTotal size of /root: " + root.getSize() + " KB");
        System.out.println("Total size of /src:  " + src.getSize()  + " KB");
    }
}
