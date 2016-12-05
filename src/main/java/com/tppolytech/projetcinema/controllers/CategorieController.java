package com.tppolytech.projetcinema.controllers;

import com.tppolytech.projetcinema.DAO.CategorieDAO;
import com.tppolytech.projetcinema.models.CategorieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by syl on 07/11/2016.
 */
@RequestMapping(value="/categorie")
@Controller
public class CategorieController {

    @Autowired
    private CategorieDAO _categorieController;

    // localhost:8080/tacos/save?name=name&description=description&latitude=12.34&longitude=54.87&image=image
    @RequestMapping(value = "/save")
    @ResponseBody
    public CategorieEntity create(String codeCat, String libelleCat) {
        try {
            CategorieEntity categorieEntity = new CategorieEntity();
            categorieEntity.setCodeCat(codeCat);
            categorieEntity.setLibelleCat(libelleCat);
            _categorieController.save(categorieEntity);
            return categorieEntity;
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value="/getall")
    @ResponseBody
    public ArrayList<CategorieEntity> getAll() {
        ArrayList<CategorieEntity> categorieList = (ArrayList<CategorieEntity>) _categorieController.getAll();
        return categorieList;
    }
}
