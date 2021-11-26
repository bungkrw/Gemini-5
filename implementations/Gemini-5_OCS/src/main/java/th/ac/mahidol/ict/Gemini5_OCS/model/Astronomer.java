package th.ac.mahidol.ict.Gemini5_OCS.model;

public class Astronomer extends User {
    private int astronomerID;
    private String organization;

    public Astronomer(int astronomerID, String organization) {
        this.astronomerID = astronomerID;
        this.organization = organization;
    }

    public Astronomer() { }

    public int getAstronomerID() {
        return astronomerID;
    }

    public void setAstronomerID(int astronomerID) {
        this.astronomerID = astronomerID;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
