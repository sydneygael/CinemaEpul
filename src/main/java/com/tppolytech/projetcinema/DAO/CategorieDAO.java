package com.tppolytech.projetcinema.DAO;

import com.tppolytech.projetcinema.models.CategorieEntity;
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
public class CategorieDAO {

    @Autowired
    private LocalSessionFactoryBean _sessionFactory;
    private Session getSession() {return _sessionFactory.getObject().getCurrentSession();}

    public void save(CategorieEntity acteur) {
        getSession().save(acteur);
        return;
    }

    public void delete(CategorieEntity acteur) {
        getSession().delete(acteur);
        return;
    }


    public List<CategorieEntity> getAll() {
        return getSession().createQuery("from CategorieEntity").list();
    }

    public CategorieEntity getById(long id) {
        return (CategorieEntity) getSession().load(CategorieEntity.class, id);
    }

    public void update(CategorieEntity tacos) {
        getSession().update(tacos);
        return;
    }


    // retourne si la catégorie existe ou non
    public boolean isExist(String id) {
        Query query = getSession().createQuery("from CategorieEntity where codeCat = id ");
        if (query.list().size() == 0) {
            return false;
        }
        return true;
    }
}
