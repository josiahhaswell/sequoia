package org.sequoia.model.auth;

import org.sequoia.model.core.UniqueEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(
    name = "SEQUOIA_USER"
)
@XmlRootElement
public class User extends UniqueEntity {

    @XmlAttribute
    private String name;

    private String password;

}
