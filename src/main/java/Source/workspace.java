package Source;

public class workspace {
    // Properties
    private String ID;
    private String name;
    private String description;
    private String type;
    private String visibility;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }



//    public workspace(String id, String name ) {
//
//        setID(id);
//        setName(name);
//
//    }
    public workspace()
    {};


    public workspace(String name, String description, String type, String visibility) {
        setName(name);
        setDescription(description);
        setType(type);
        setVisibility(visibility);

    }





}
