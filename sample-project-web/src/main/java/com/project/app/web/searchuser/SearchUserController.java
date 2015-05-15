package com.project.app.web.searchuser;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping(value = "searchuser")
@SessionAttributes(types = SearchUserForm.class)
public class SearchUserController {
	
	@Autowired
	UserService userService;
	/**
     * pre-initialization of form backed bean
     * @param model
     * @return
     */
    @ModelAttribute
    public SearchUserForm setUpSearchUserForm() {
    	SearchUserForm searchTourForm = new SearchUserForm();
    	
        return searchTourForm;
    }

	@RequestMapping(value = "search", method = RequestMethod.GET, params = "form")
    public String searchForm(SessionStatus status) {
		log.info("Search Form Initation");
        status.setComplete();
        return "searchuser/searchForm";
    }
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(@Validated SearchUserForm searchTourForm,
            BindingResult result, Model model,
            @PageableDefault Pageable pageable) {
		Page<User> page = userService.searchUser(pageable);
        model.addAttribute("page", page);
		return "searchuser/searchForm";
	}
}
