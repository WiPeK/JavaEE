package pl.wipek.users.resources;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * @author Krzysztof Adamczyk on 21.09.2017.
 */
public class EntityManagerResourceTest {

    private static EntityManager entityManager;

    @Test
    public void createEntityManager() throws Exception {
        EntityManagerResource entityManagerResource = new EntityManagerResource();
        entityManager = entityManagerResource.createEntityManager();
    }

    @After
    public void afterCreateEntityManager() {
        Assert.assertNotNull(entityManager);
    }

}