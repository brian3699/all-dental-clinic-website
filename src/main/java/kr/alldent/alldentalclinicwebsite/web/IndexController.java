package kr.alldent.alldentalclinicwebsite.web;

import kr.alldent.alldentalclinicwebsite.config.auth.LoginUser;
import kr.alldent.alldentalclinicwebsite.config.auth.dto.SessionUser;
import kr.alldent.alldentalclinicwebsite.service.ReviewService;
import kr.alldent.alldentalclinicwebsite.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final ReviewService reviewService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index.html";
    }

    @GetMapping("/review")
    public String test(Model model, @LoginUser SessionUser user) {
        model.addAttribute("review", reviewService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "review";
    }

    @GetMapping("/review/new")
    public String postsSave(){
        return "review-new";
    }

    @GetMapping("/review/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        ReviewResponseDto dto = reviewService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
