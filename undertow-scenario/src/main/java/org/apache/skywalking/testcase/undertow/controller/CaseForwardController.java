package org.apache.skywalking.testcase.undertow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright @ 2018/8/11
 *
 * @author cloudgc
 */
@RestController
@RequestMapping("/case/backup")
public class CaseForwardController {

    private final static Logger log = LoggerFactory.getLogger(CaseForwardController.class);

    @RequestMapping("/forwardone")
    public void startForwardOne(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("request:{},response:{}", request, response);
        request.getRequestDispatcher("/case/forwardtwo").forward(request, response);
    }

    @RequestMapping("/forwardtwo")
    public void startForwardTwo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("request:{},response:{}", request, response);
        request.getRequestDispatcher("/case/forwardend").forward(request, response);
    }

    @RequestMapping("/forwardend")
    public String forardEnd() {
        return "success";
    }

}
