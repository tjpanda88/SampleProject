package com.project.app.fw.datatables.controller;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.app.domain.repository.user.UserRepository;
import com.project.app.fw.datatables.beans.EditorFieldErrorModel;
import com.project.app.fw.datatables.beans.EditorInputModel;
import com.project.app.fw.datatables.beans.EditorOutputModel;

public abstract class DataTablesBaseController<S,D> {


	@RequestMapping(method = RequestMethod.GET, params="action=load")
    public Map<String,Object> load() {
		Map<String,Object> resultMap = new HashMap<>();
		List<D> dataModelList = getModelData();
		List<S> screenModelList = new ArrayList<>();

		for(D dataModelItem : dataModelList){
			screenModelList.add(data2Screen(dataModelItem));
		}

		resultMap.put("data", screenModelList);

		return resultMap;
    }

	protected abstract List<D> getModelData();

	@RequestMapping(method = RequestMethod.POST, params="action=create")
	public EditorOutputModel create(EditorInputModel input) {
		EditorOutputModel output = new EditorOutputModel();

		S screenModel = map2Model(input.getData());

		Set<ConstraintViolation<S>> screenModelValidatorResults = validationByScreenModel(screenModel);

		if(!CollectionUtils.isEmpty(screenModelValidatorResults)) {
			output.setFieldErrors(getFiledErrors(screenModelValidatorResults));
			return output;
		}

		D dataModel = save(screenModel);
		output.setRow(data2Screen(dataModel));
		return output;
	}


	protected S data2Screen(D dataModel) {
		Mapper mapper = new DozerBeanMapper();

		Class<S> entityClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return mapper.map(dataModel, entityClass);
	}

	protected List<EditorFieldErrorModel> getFiledErrors(Set<ConstraintViolation<S>> screenModelValidatorResults) {

		List<EditorFieldErrorModel> fieldErrors = new ArrayList<>();

		for(ConstraintViolation<S> errorItem : screenModelValidatorResults) {
			fieldErrors.add(new EditorFieldErrorModel(errorItem.getPropertyPath().toString(), errorItem.getMessage()));
		}

		return fieldErrors;
	}

	protected Set<ConstraintViolation<S>> validationByScreenModel(S screenModel) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		return validator.validate(screenModel);
	}

	protected S map2Model(Map<String,String> data) {
		Mapper mapper = new DozerBeanMapper();
		Class<S> entityClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return (S)mapper.map(data, entityClass);
	}

	protected abstract D save(S screenModel);
}
