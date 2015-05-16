package com.project.app.web.manageruser;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.domain.model.User;
import com.project.app.domain.service.user.UserService;

@Slf4j
@RestController
@RequestMapping(value = "managerUser")
public class ManagerUserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "load", method = RequestMethod.GET)
    public Map<String,Object> loadData(@PageableDefault Pageable pageable) {
		Map<String,Object> resultMap = new HashMap<>();
		Page<User> page = userService.searchUser(pageable);
		resultMap.put("data", page.getContent());
		return resultMap;
    }

}
