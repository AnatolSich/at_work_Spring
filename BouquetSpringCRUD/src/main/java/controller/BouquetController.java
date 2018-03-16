package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BouquetService;

@Controller
@RequestMapping(value = "/bouquet")
public class BouquetController {

    @Autowired
    private BouquetService bouquetService;


}
