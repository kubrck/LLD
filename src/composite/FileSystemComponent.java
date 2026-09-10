package composite;

// Component — uniform interface for both leaf (File) and composite (Directory)
public interface FileSystemComponent {
    String getName();
    long getSize();
    void display(String indent);
}
