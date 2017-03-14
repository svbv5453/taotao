package com.sh.ssm.taotao.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JackSun.
 * @Date 2017/3/14 18:32.
 * @Version 1.0
 * @Description
 */
@RequestMapping("/front")
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex() {
        return "front/index";
    }
}
