package pl.wipek.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

/**
 * @author Krzysztof Adamczyk on 02.10.2017.
 */
@Interceptor
@RequestBinding
public class RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

//    @AroundInvoke
//    public void saveRequestData(@Context Request request) {
//        logger.info(request);
//    }

    @AroundConstruct
    public Object onConstruct(InvocationContext context) throws Exception {
        // todo new module for this action
        logger.info(context.toString());
        return null;
    }
}
