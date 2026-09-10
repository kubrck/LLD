package composite;

// Leaf — has no children; stores actual size
public class File implements FileSystemComponent {

    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void display(String indent) {
        System.out.printf("%s📄 %s (%d KB)%n", indent, name, size);
    }
}
