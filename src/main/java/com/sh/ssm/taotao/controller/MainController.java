package com.sh.ssm.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/2/22.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/rest/page/{page}")
    public String showPage(@PathVariable String page) {

        return page;
    }
}
