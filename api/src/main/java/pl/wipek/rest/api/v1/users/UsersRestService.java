package pl.wipek.rest.api.v1.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wipek.request.RequestInterceptor;
import pl.wipek.users.ejb.services.UsersService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Krzysztof Adamczyk on 20.09.2017.
 */
@Path("/")
@ApplicationPath("/")
@ApplicationScoped
@XmlRootElement
public class UsersRestService extends Application {

    private static final Logger logger = LoggerFactory.getLogger(UsersRestService.class);

    @EJB
    private UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Interceptors(RequestInterceptor.class)
    public Response getAll(@Context Request request) {
        logger.info(request.toString());
        return Response.ok(usersService.getAll()).build();
    }
}
