package controller;

import model.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BouquetService;

import java.util.List;

@Controller
@RequestMapping(value = "/bouquet")
public class BouquetController {

    @Autowired
    private BouquetService bouquetService;

    @RequestMapping(value = "bouquets", method = RequestMethod.GET)
    public String getAllBouquetsGet(Model model) {
        List<Bouquet> list = bouquetService.geaAllBouquets();
        model.addAttribute("bouquets", list);
        return "listBouquets";
    }

    @RequestMapping(value = "addBouquet", method = RequestMethod.GET)
    public String addBouquetGet(){
        return "addBouquet";
    }

    /*@RequestMapping(value = "addBouquet", method = RequestMethod.POST)
    public String addBouquetPost(Model model){
        model.addAttribute()
        return "addBouquet";
    }*/
}
