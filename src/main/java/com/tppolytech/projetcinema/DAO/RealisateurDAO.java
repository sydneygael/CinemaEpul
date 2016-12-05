package com.tppolytech.projetcinema.DAO;

import com.tppolytech.projetcinema.models.RealisateurEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by syl on 07/11/2016.
 */
@Repository
@Transactional
public class RealisateurDAO {
    @Autowired
    private LocalSessionFactoryBean _sessionFactory;
    private Session getSession() {return _sessionFactory.getObject().getCurrentSession();}

    public void save(RealisateurEntity acteur) {
        getSession().save(acteur);
        return;
    }

    public void delete(RealisateurEntity acteur) {
        getSession().delete(acteur);
        return;
    }


    public List<RealisateurEntity> getAll() {
        return getSession().createQuery("from RealisateurEntity").list();
    }

    public RealisateurEntity getById(long id) {
        return (RealisateurEntity) getSession().load(RealisateurEntity.class, id);
    }

    public void update(RealisateurEntity tacos) {
        getSession().update(tacos);
        return;
    }

    // retourne si le réalisateur existe ou non
    public boolean isExist(int id) {
        Query query = getSession().createQuery("from RealisateurEntity where noRea = id ");
        if (query.list().size() == 0) {
            return false;
        }
        return true;
    }
}
