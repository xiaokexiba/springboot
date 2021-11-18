package boot.controller;

import boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @ 2021-11-17 18:44
 */
@Controller
public class IndexController {

    /**
     * 登入页面
     *
     * @return
     */
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String index(User user, HttpSession session,Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())) {
            session.setAttribute("loginUser",user);
            //登入成功，重定向到index.html,重定向防止表单重复提交
            return "redirect:/index";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登入页面
            return "login";
        }
//        return "index";
    }

    /**
     * 主页面
     *
     * @return
     */
    @GetMapping("/index")
    public String indexPage(HttpSession session,Model model) {
        //是否登入。拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "index";
        }else {
            model.addAttribute("msg","请重新登入");
            //回到登入页面
            return "login";
        }
    }
}
