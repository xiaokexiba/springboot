package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ 2021-11-17 19:33
 */
@Controller
public class TableController {

    @GetMapping("/basic_table.html")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table() {
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table.html")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table() {
        return "table/responsive_table";
    }
}
