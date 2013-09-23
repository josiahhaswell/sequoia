package org.sequoia.model.core;

/**
 * Created with IntelliJ IDEA.
 * User: josiahhaswell
 * Date: 9/23/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestCaseTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Persistable.class);
    }

    @Test
    public void testWhatever() {

    }
}
