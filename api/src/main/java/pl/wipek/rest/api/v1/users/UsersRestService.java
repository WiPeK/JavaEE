package pl.wipek.rest.api.v1.users;

import pl.wipek.users.ejb.services.UsersService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Krzysztof Adamczyk on 20.09.2017.
 */
@Path("/")
@ApplicationPath("/")
@XmlRootElement
@ApplicationScoped
public class UsersRestService extends Application {

    @Inject
    private UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAll() {
        return Response.ok(usersService.getAll()).build();
    }
}
