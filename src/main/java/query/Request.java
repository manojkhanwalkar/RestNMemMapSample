package query;


import java.util.ArrayList;
import java.util.List;

public class Request
{


    String clientId ;

    List<Identifier> identifiers = new ArrayList<>();
    //NodeType type ;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(Identifier identifier)
    {
        identifiers.add(identifier);
    }
}
