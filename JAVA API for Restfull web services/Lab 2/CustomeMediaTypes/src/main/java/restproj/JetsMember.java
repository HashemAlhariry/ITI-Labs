package restproj;

public class JetsMember {
    private String name;

    public JetsMember(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JetsMember [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
