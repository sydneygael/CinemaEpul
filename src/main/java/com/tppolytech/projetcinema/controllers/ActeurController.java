package com.tppolytech.projetcinema.controllers;

import com.tppolytech.projetcinema.DAO.ActeurDAO;
import com.tppolytech.projetcinema.models.ActeurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by syl on 10/10/2016.
 */
@RequestMapping(value="/acteur")
@RestController
public class ActeurController {

    @Autowired
    private ActeurDAO _acteurController;

    /**  @RequestMapping(value="/delete")
     @ResponseBody public String delete(long id) {
     try {
     Tacos tacos = new Tacos(id);
     _tacosDao.delete(tacos);
     }
     catch(Exception ex) {
     return ex.getMessage();
     }
     return "Tacos succesfully deleted!";
     }  */

    /**
     * @RequestMapping(value="/get-by-email")
     * @ResponseBody public String getByEmail(String email) {
     * String userId;
     * try {
     * Tacos tacos = _tacosDao.getByEmail(email);
     * userId = String.valueOf(tacos.getId());
     * }
     * catch(Exception ex) {
     * return "Tacos not found";
     * }
     * return "The user id is: " + userId;
     * }
     */


    // localhost:8080/acteur/save?nomAct=syl&prenAct=Beg&dateNaiss=2000-01-01&dateDeces=2000-01-02

    @RequestMapping(value = "/save")
    @ResponseBody
    public ActeurEntity create(String nomAct, String prenAct, Date dateNaiss, Date dateDeces) {
        try {
            ActeurEntity acteur = new ActeurEntity();
            acteur.setNomAct(nomAct);
            acteur.setPrenAct(prenAct);
            acteur.setDateNaiss(dateNaiss);
            acteur.setDateDeces(dateDeces);
            _acteurController.save(acteur);
            return acteur;
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value="/getall")
    @CrossOrigin(origins = "http://localhost:8080")
    @ResponseBody
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ActeurEntity> getAll() {
        ArrayList<ActeurEntity> acteurList = (ArrayList<ActeurEntity>) _acteurController.getAll();
        return acteurList;
    }

}
