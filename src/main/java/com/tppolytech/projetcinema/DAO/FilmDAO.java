package com.tppolytech.projetcinema.DAO;

import com.tppolytech.projetcinema.models.FilmEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by syl on 07/11/2016.
 */
@Repository
@Transactional
@Service
public class FilmDAO {

    @Autowired
    private LocalSessionFactoryBean _sessionFactory;
    private Session getSession() {return _sessionFactory.getObject().getCurrentSession();}

    public void save(FilmEntity acteur) {
        getSession().save(acteur);
        return;
    }

    public void delete(FilmEntity acteur) {
        getSession().delete(acteur);
        return;
    }


    public List<FilmEntity> getAll() {
        return getSession().createQuery("from FilmEntity").list();
    }

    public FilmEntity getById(long id) {
        return (FilmEntity) getSession().load(FilmEntity.class, id);
    }

    public void update(FilmEntity tacos) {
        getSession().update(tacos);
        return;
    }

    // retourne si le film existe ou non
    public boolean isExist(int id) {
        Query query = getSession().createQuery("from FilmEntity where noFilm = id ");
        if (query.list().size() == 0) {
            return false;
        }
        return true;
    }
}
