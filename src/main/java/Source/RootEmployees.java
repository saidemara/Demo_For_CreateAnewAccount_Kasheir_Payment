package Source;

public class RootEmployees {

    public RootEmployees() {
    }

    private workspace workspace;

    public workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(workspace workspace) {
        this.workspace = workspace;
    }


    public RootEmployees(workspace Ref) {
        this.workspace = Ref;
    }


}
