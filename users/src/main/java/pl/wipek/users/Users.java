package pl.wipek.users;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Krzysztof Adamczyk on 18.09.2017.
 */
@ApplicationPath("/dashboard")
@Path("/users")
public class Users extends Application {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return null;
    }
}
