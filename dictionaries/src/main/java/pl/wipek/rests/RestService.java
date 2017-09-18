package pl.wipek.rests;


import pl.wipek.dictionaries.ejb.DictionaryService;

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
 * @author Krzysztof Adamczyk on 17.08.2017.
 */
@Path("/")
@ApplicationPath("/api")
@XmlRootElement
@ApplicationScoped
public class RestService extends Application{

    @Inject
    private DictionaryService dictionaryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAll() {
        return Response.ok(this.dictionaryService.getAll()).build();
    }

}
