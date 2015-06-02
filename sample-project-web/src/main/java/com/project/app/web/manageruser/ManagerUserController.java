package com.project.app.web.manageruser;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.domain.model.User;
import com.project.app.domain.repository.user.UserRepository;
import com.project.app.fw.datatables.controller.DataTablesBaseController;
import com.project.app.web.manageruser.model.UserModel;

@Slf4j
@RestController
@RequestMapping(value = "managerUser")
public class ManagerUserController extends DataTablesBaseController<UserModel, User>{

	@Autowired
	UserRepository userRepository;

	protected List<User> getModelData() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST, params="action=edit")
    public Map<String,Object> edit(@RequestParam(value="data[id]",required=false)String id,
    		@RequestParam(value="data[name]",required=false)String name,
    		@RequestParam(value="data[roleId]",required=false)String roleId)   {

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setRegisterDate(new Date());
		user.setRoleId(roleId);
		user.setPassword("1");

		userRepository.save(user);
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("row", userRepository.findOne(id));
		return resultMap;
    }

	@RequestMapping(value = "edit", method = RequestMethod.POST, params="action=remove")
    public Map<String,Object> delete(@RequestParam(value="data[id]",required=false)String id,
    		@RequestParam(value="data[name]",required=false)String name,
    		@RequestParam(value="data[roleId]",required=false)String roleId)   {

		userRepository.delete(id);
		Map<String,Object> resultMap = new HashMap<>();
		return resultMap;
    }



	@Override
	protected User save(UserModel screenModel) {
		Mapper mapper = new DozerBeanMapper();
		User dataModel = mapper.map(screenModel, User.class);
		dataModel.setRegisterDate(new Date());
		return userRepository.save(dataModel);
	}
}
