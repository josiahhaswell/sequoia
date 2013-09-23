package org.sequoia.model.core;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sequoia.model.auth.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: josiahhaswell
 * Date: 9/23/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class UserTest {


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "org.sequoia.model")
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private boolean rollback;

    protected void setRollback(boolean rollback) {
        this.rollback = rollback;
    }


    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private UserTransaction userTransaction;

    @Before
    public void setUp() {
        try {
            userTransaction.begin();
            entityManager.joinTransaction();
        } catch (NotSupportedException | SystemException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void tearDown() {
        try {
            if(rollback) rollbackTransaction();
            else commitTransaction();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void commitTransaction() throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        userTransaction.commit();
    }

    private void rollbackTransaction() throws SystemException {
        userTransaction.rollback();
    }

    @Test
    public void ensureEntityManagerIsNotNull() {
        assertNotNull(entityManager);
    }

    @Test
    public void ensureEntityManagerCanPersistValidUser() {
        setRollback(true);
        entityManager.persist(new User());
    }


}
