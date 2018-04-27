package controller;

import model.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.BouquetService;

import java.awt.*;
import java.math.BigDecimal;
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

    @RequestMapping(value = "addBouquet/{eventId}", method = RequestMethod.GET)
    public String addBouquetGet(@PathVariable int eventId,
                                Model model) {
        model.addAttribute("eventId", eventId);
        return "addBouquet";
    }

    @RequestMapping(value = "addBouquet/{eventId}", method = RequestMethod.POST)
    public String addBouquetPost(@PathVariable int eventId,
                                 @RequestParam("bouquetName") String bouquetName,
                                 @RequestParam("color") Color color,
                                 @RequestParam("cost") BigDecimal cost,
                                 @RequestParam("delivery") boolean delivery) {
        Bouquet newBouquet = new Bouquet();
        newBouquet.setBouquetName(bouquetName);
        newBouquet.setColor(color);
        newBouquet.setCost(cost);
        newBouquet.setDelivery(delivery);
        bouquetService.addBouquet(newBouquet, eventId);
        return "redirect:/listBouquetsByEvent";
    }

    @RequestMapping(value = "updateBouquet/{id}", method = RequestMethod.GET)
    public String updateBouquet(@PathVariable int id,Model model){
        model.addAttribute("bouquetId",id);
        return "updateBouquet";
    }

    @RequestMapping(value = "updateBouquet/{id}", method = RequestMethod.POST)
    public String updateBouquet(@PathVariable int id,
                                @RequestParam("bouquetName") String bouquetName,
                                @RequestParam("color") Color color,
                                @RequestParam("cost") BigDecimal cost,
                                @RequestParam("delivery") boolean delivery){

        return "redirect:/listBouquetsByEvent";
    }


}
