package org.sequoia.model.core;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: josiahhaswell
 * Date: 9/21/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Persistable<ID extends Serializable>
{

    ID getId();

    @Override
    boolean equals(Object o);

    @Override
    String toString();
}
