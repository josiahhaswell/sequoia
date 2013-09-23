package org.sequoia.model.core;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;


@XmlRootElement
@MappedSuperclass
public class UniqueEntity extends PersistentEntity<UUID> implements UniquelyIdentifiable{

    public UniqueEntity() {
        super(UUID.randomUUID());
    }

}
