package org.sequoia.model.core;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@MappedSuperclass
public abstract class PersistentEntity<ID extends Serializable> implements Persistable<ID> {

    @Id
    @XmlAttribute
    private ID id;


    protected PersistentEntity(ID id) {
        setId(id);
        if(id == null) {
            throw new IllegalArgumentException("Error: ID must not be null!");
        }
    }

    public PersistentEntity() {
        throw new AbstractMethodError("PersistentEntity() is abstract!");
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersistentEntity)) return false;

        PersistentEntity that = (PersistentEntity) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PersistentEntity{" + "id=" + id + '}';
    }
}
