package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.config.auth.LoginUser;
import kr.alldent.alldentalclinicwebsite.config.auth.dto.SessionUser;
import kr.alldent.alldentalclinicwebsite.service.BlogPostService;
import kr.alldent.alldentalclinicwebsite.service.ReservationService;
import kr.alldent.alldentalclinicwebsite.service.ReviewService;
import kr.alldent.alldentalclinicwebsite.web.dto.review.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final ReviewService reviewService;
    private final BlogPostService blogPostService;
    private final ReservationService reservationService;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index.html";
    }

    @GetMapping("/review")
    public String reviewList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("review", reviewService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "review-list";
    }

    @GetMapping("/review/{id}")
    public String reviewPage(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        model.addAttribute("review", reviewService.findById(id));
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "review";
    }

    @GetMapping("/review/new")
    public RedirectView reviewNew( Model model, @LoginUser SessionUser user){
        if(user == null){
            return new RedirectView("/login");
        }
        model.addAttribute("userName", user.getName());
        return new RedirectView("/review-write");
    }

    @GetMapping("/review-write")
    public String reviewWrite( Model model, @LoginUser SessionUser user){
        if(user == null){
            return("/login");
        }
        model.addAttribute("userName", user.getName());
        return "review-new";
    }

    @GetMapping("/review/update/{id}")
    public String reviewUpdate(@PathVariable Long id, Model model) {
        ReviewResponseDto dto = reviewService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/blog")
    public String blogMain(Model model, @LoginUser SessionUser user){
        model.addAttribute("blog", blogPostService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "blog";
    }

    @GetMapping("/reservation")
    public String reservation(Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("reservationList", reservationService.findByUid(user.getId()));
        }

        return "reservation";
    }

    @GetMapping("/reservation-new")
    public String reservationNew(Model model, @LoginUser SessionUser user){
        if(user == null){
            return("/login");
        }

        model.addAttribute("name", user.getName());
        model.addAttribute("uid", user.getId());

        return "reservation-new";
    }

    @GetMapping("/login")
    public String siteLogin(){

        return "login";
    }

}
