package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard randomCatCard() {
        CatFact catFact = catFactService.getFact();
        CatPic catPic = catPicService.getPic();
        CatCard newCard = new CatCard();
        newCard.setCatFact(catFact.getText());
        newCard.setImgUrl(catPic.getFile());
        return newCard;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public void saveNewCard(@Valid @RequestBody CatCard catCard){
        catCardDao.save(catCard);
    }

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> getAllCards() {
        return catCardDao.list();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard getCardById(@Valid @PathVariable int id){
        return catCardDao.get(id);
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public boolean updateCard(@Valid @RequestBody CatCard catCard, @Valid @PathVariable int id){
        if(id > 0){
            catCardDao.update(id, catCard);
            return true;
        }
        return false;
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public void deleteCard(@Valid @PathVariable int id){
        catCardDao.delete(id);
    }


}
