package platform.codingnomads.co.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {
    //"inject" the bean of the QuoteService into this class
    @Autowired
    QuoteService quoteService;

    //quote endpoint
    @GetMapping("/quote")
    public String quote (Model model){

        //random quote
        String quote = quoteService.getRandomQuote();

        //attach random quote to data model
        model.addAttribute("quote", quote);

        //return the view quote/html view
        return "getting_started/quote";
    }
}
