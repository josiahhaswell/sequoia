package org.sequoia.model.core;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: josiahhaswell
 * Date: 9/23/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
@SuppressWarnings("unchecked")
public class PersistentEntityTestCase {

    @Test
    public void ensurePersistentEntityIsNotEqualToNull() {
        assertThat(createPersistentEntity().equals(null), is(false));
    }

    @Test(expected = AbstractMethodError.class)
    public void ensurePersistentEntityPublicConstructorThrowsMethodError() {
        new PersistentEntity() {

        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureProvidingNullIdThrowsIllegalArgumentException() {
        new PersistentEntity(null) {

        };

    }


    protected PersistentEntity createPersistentEntity() {
        return new PersistentEntity("test") {

        };
    }

}
