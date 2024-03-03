package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.epam.ui.Main;

public class App {
public static void main(String[] args)
{
	ApplicationContext context=SpringApplication.run(SpringQuizAplication.class,args);
	Main main=context.getBean(Main.class);
	main.main();
}
}
