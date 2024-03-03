package com.epam.ui;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSelection {
	
	@Autowired
	AdminDetailsUi adminDetailsUi;
    @Autowired
    UserDetailsUi userDetailsUi;
	
	private Map<Integer, Selection> userOption ;
	Logger logger = LogManager.getLogger(UserSelection.class);
    public UserSelection()
    {
	userOption = new HashMap<>();
	userOption.put(1, () -> adminDetailsUi.adminDetailsUi());
	userOption.put(2, () -> userDetailsUi.userDetailsUi());
	userOption.put(3, () -> System.exit(0));
	}

	public void createUser(int userType) {
		Selection command = userOption.get(userType);

		if (command==null) {
			logger.info("choose the valid option from above !!");
		}
		else
		{
			command.select();
		}
	}

}