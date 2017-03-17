package common;

/**
 * Created by Maria_Akulova on 5/11/2016.
 */
public class Client {

    public String id;
    public String fullName;
    public String greeting;

    public Client(String idClient, String fullNameClient) {
        this.id = idClient;
        this.fullName = fullNameClient;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "common.Client{" + "id='" + id + '\'' + ", fullName='" + fullName + '\'' + ", greeting='" + greeting
                + '\'' + '}';
    }
}
