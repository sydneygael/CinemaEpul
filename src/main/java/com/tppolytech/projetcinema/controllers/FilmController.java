package com.tppolytech.projetcinema.controllers;

import com.tppolytech.projetcinema.DAO.ActeurDAO;
import com.tppolytech.projetcinema.DAO.CategorieDAO;
import com.tppolytech.projetcinema.DAO.FilmDAO;
import com.tppolytech.projetcinema.DAO.RealisateurDAO;
import com.tppolytech.projetcinema.models.ActeurEntity;
import com.tppolytech.projetcinema.models.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by syl on 07/11/2016.
 */
@RequestMapping(value="/film")
@Controller
public class FilmController {

    @Autowired
    private FilmDAO _filmController;

    @Autowired
    private RealisateurDAO _realisateurController;

    @Autowired
    private CategorieDAO _categorieController;


    //localhost:8080/film/save?titre=monTitre&duree=20&dateSortie=2000-01-01&budget=1000&montantRecette=200&noRea=1&codeCat=PO


    @RequestMapping(value = "/save")
    @ResponseBody
    public FilmEntity create(String titre, int duree, Date dateSortie, int budget, int montantRecette, int noRea, String codeCat) {
        try {
            if (!_realisateurController.isExist(noRea) && !_categorieController.isExist(codeCat)) {
                return null;
            }
            FilmEntity film = new FilmEntity();
            film.setTitre(titre);
            film.setDuree(duree);
            film.setDateSortie(dateSortie);
            film.setBudget(budget);
            film.setMontantRecette(montantRecette);
            film.setNoRea(noRea);
            film.setCodeCat(codeCat);
            _filmController.save(film);
            return film;
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value="/getall")
    @ResponseBody
    public ArrayList<FilmEntity> getAll() {
        ArrayList<FilmEntity> acteurList = (ArrayList<FilmEntity>) _filmController.getAll();
        return acteurList;
    }

}
