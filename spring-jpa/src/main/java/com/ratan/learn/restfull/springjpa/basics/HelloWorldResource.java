package com.ratan.learn.restfull.springjpa.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;


@RestController
public class HelloWorldResource {


    @Autowired
    private MessageSource messageSource;


    @GetMapping(path = "/welcome")
    public String welcomeMessage(){
        return "Hellow there!!!";
    }


    @GetMapping(path = "/welcome-bean")
    public HelloWorlBean welcomeMessageBean(){

        HelloWorlBean helloWorlBean = new HelloWorlBean("ratan",26);

        return helloWorlBean;
    }

    @GetMapping(path = "/welcome-bean/{name}")
    public String welcomeMessageBeanPathVariable(@PathVariable String name){

        return String.format("Hello there %s", name);
    }

//  public String welcomeMessageInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
    @GetMapping(path = "/welcome-inter")
    public String welcomeMessageInternationalized(){


        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());


    }
}
