package th.ac.mahidol.ict.Gemini5_OCS.model;

public class UserFactory {
    public  User getUser(String role)
    {
        if (role == null) return null;
        if (role.equalsIgnoreCase("ASTRONOMER"))
        {
            return new Astronomer();
        }

        return null;
    }
}
