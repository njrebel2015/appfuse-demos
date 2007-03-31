package org.appfuse.tutorial.dao.jpa;

import org.appfuse.tutorial.model.Person;
import org.appfuse.tutorial.dao.PersonDao;
import org.appfuse.dao.jpa.GenericDaoJpa;

import javax.persistence.Query;
import java.util.List;

public class PersonDaoJpa extends GenericDaoJpa<Person, Long> implements PersonDao {

    public PersonDaoJpa() {
        super(Person.class);
    }

    @SuppressWarnings("unchecked")
	public List<Person> findByLastName(String lastName) {
        Query q = super.entityManager.createQuery("select p from Person p where p.lastName=?");
        q.setParameter(1, lastName);
        return q.getResultList();
    }
}