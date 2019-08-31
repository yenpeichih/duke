package Model_Class;

public class FileStringList extends Task {

    public FileStringList (String description){
        super(description);
    }

    @Override
    public String toString() {
        String s = super.getDescription();
        return s;
    }
}
