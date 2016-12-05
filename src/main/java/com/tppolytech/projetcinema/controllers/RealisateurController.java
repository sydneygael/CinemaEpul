package com.tppolytech.projetcinema.controllers;

import com.tppolytech.projetcinema.DAO.FilmDAO;
import com.tppolytech.projetcinema.DAO.RealisateurDAO;
import com.tppolytech.projetcinema.models.ActeurEntity;
import com.tppolytech.projetcinema.models.FilmEntity;
import com.tppolytech.projetcinema.models.RealisateurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by syl on 07/11/2016.
 */
@RequestMapping(value="/realisateur")
@Controller
public class RealisateurController {
    @Autowired
    private RealisateurDAO _realisateurController;


    // localhost:8080/tacos/save?name=name&description=description&latitude=12.34&longitude=54.87&image=image
    @RequestMapping(value = "/save")
    @ResponseBody
    public RealisateurEntity create(String nomRea, String prenRea) {
        try {
            RealisateurEntity tacos = new RealisateurEntity();
            tacos.setNomRea(nomRea);
            tacos.setPrenRea(prenRea);
            _realisateurController.save(tacos);
            return tacos;
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value="/getall")
    @ResponseBody
    public ArrayList<RealisateurEntity> getAll() {
        ArrayList<RealisateurEntity> acteurList = (ArrayList<RealisateurEntity>) _realisateurController.getAll();
        return acteurList;
    }

}
