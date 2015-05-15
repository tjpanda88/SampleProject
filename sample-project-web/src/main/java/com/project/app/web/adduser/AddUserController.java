package com.project.app.web.adduser;

import lombok.extern.slf4j.Slf4j;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.app.domain.model.User;
import com.project.app.domain.service.user.UserService;

@Slf4j
@Controller
@RequestMapping(value = "adduser")
@SessionAttributes(types = AddUserForm.class)
public class AddUserController {
	
	@Autowired
	UserService userService;

	@ModelAttribute
    public AddUserForm setUpAddUserForm() {
		AddUserForm addUserForm = new AddUserForm();
    	
        return addUserForm;
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET, params = "form")
    public String addForm(SessionStatus status) {
		log.info("Search Form Initation");
        status.setComplete();
        return "adduser/addForm";
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
    public String search(@Validated AddUserForm addUserForm,
            BindingResult result, Model model) {
		Mapper mapper = new DozerBeanMapper();
		User user = (User) mapper.map(addUserForm, User.class);
//		User user = new User();
//		user.setId(addUserForm.getId());
//		user.setName(addUserForm.getName());
//		user.setPassword(addUserForm.getPassword());
//		user.setType(addUserForm.getType());

		userService.saveUser(user);
		return "adduser/addForm";
	}
}
