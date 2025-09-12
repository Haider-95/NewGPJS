package se.systementor.supershoppen1.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se.systementor.supershoppen1.shop.model.Product;
import se.systementor.supershoppen1.shop.services.ProductService;
import se.systementor.supershoppen1.shop.services.SubscriberService;

@Controller
public class HomeController {
    private  ProductService productService;
    private SubscriberService subscriberService;
    @Autowired
    public HomeController(ProductService productService, SubscriberService subscriberService) {
        this.productService = productService;
        this.subscriberService = subscriberService;
    }

    @GetMapping(path = "/")
    String empty(Model model) {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("hideSubscription", false);

        if (auth == null || !auth.isAuthenticated()) {
            return "home";
        }

        Object principal = auth.getPrincipal();

        if (principal instanceof UserDetails ud) {
            String user = ud.getUsername();
            model.addAttribute("username", user);

            boolean isSub = subscriberService.isSubscriber(user);
            model.addAttribute("hideSubscription", isSub);
            return "home";
        }

        // 2) OAuth2 (GitHub/Discord)
        if (principal instanceof org.springframework.security.oauth2.core.user.OAuth2User oauth) {
            // Försök hämta ett vettigt namn i denna ordning:
            String name      = oauth.getAttribute("name");        // GitHub full name
            String login     = oauth.getAttribute("login");       // GitHub username
            String global    = oauth.getAttribute("global_name"); // Discord display name
            String username  = (name != null && !name.isBlank()) ? name
                    : (global != null && !global.isBlank()) ? global
                    : login != null ? login
                    : oauth.getAttribute("username");     // Discord username (fallback)

            if (username != null) {
                model.addAttribute("username", username);
            }
            // Behåll din default hideSubscription=false för OAuth
            return "home";
        }

        // 3) Okänd principal-typ → gäst
        return "home";
    }


    @GetMapping(path="/test2")
    List<Product> getAll(){
        return productService.getAll();
    }


}
