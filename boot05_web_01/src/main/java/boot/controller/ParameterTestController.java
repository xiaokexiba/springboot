package boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ 2021-11-13 15:14
 */
@RestController
public class ParameterTestController {

    @RequestMapping("/car/{id}/owner/{userName}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("userName") String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String,String> header) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);
        return map;
    }

}
