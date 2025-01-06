package com.project.base.app.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.app.test.dto.TestDTO;
import com.project.base.app.test.entity.Test;
import com.project.base.app.test.service.TestService;
import com.project.base.utils.controller.BaseController;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController<Test, TestDTO> {
    TestController(TestService testService) {
        super(testService);
    }
}
