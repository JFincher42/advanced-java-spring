package platform.codingnomads.co.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quote")
    public String quote(Model model)
    {
        String quote = quoteService.getRandomQuote();

        model.addAttribute("quote", quote);

        return "getting_started/quote";
    }
}
