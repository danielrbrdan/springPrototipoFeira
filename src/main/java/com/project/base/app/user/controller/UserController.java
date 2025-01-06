package com.project.base.app.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.app.user.dto.CreateUserDTO;
import com.project.base.app.user.entity.User;
import com.project.base.app.user.service.UserService;
import com.project.base.utils.controller.BaseController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, CreateUserDTO> {
    UserController(UserService userService) {
        super(userService);
    }
}
