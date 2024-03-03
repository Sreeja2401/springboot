package com.epam.ui;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LibrarySelection {
	@Autowired
    QuestionLibraryUI questionLibraryUI;
    @Autowired
    QuizzLibraryUI quizzLibraryUI;
    Logger logger = LogManager.getLogger( LibrarySelection.class);
	private  Map<Integer, Selection> userOption;
	public LibrarySelection()
	{
		userOption = new HashMap<>();
		userOption.put(1, () -> questionLibraryUI.questionLibraryUI());
		userOption.put( 2, () ->quizzLibraryUI.quizzLibraryUI());
		userOption.put(3, () -> System.exit(0));
	}
	public void createUser(int userType) {
		Selection command =userOption.get(userType);
		
		if (command == null)
		{
			logger.info("choose the valid option !!");
		}
		else
		{
			command.select();
		}
	}
}

