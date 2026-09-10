package composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite — can contain both Files (leaves) and other Directories.
 * Delegates size calculation and display recursively to children.
 */
public class Directory implements FileSystemComponent {

    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    // Size is the sum of all children — recursive by design
    @Override
    public long getSize() {
        return children.stream().mapToLong(FileSystemComponent::getSize).sum();
    }

    @Override
    public void display(String indent) {
        System.out.printf("%s📁 %s (%d KB)%n", indent, name, getSize());
        children.forEach(child -> child.display(indent + "  "));
    }
}
