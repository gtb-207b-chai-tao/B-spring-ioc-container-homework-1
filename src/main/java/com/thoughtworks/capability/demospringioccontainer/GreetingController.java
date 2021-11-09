package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    GreetingService greetingService;

    @GetMapping("/greet")
    public String greet() {
        this.greetingService = this.getGreetingService();
        System.out.println(greetingService);
        return greetingService.sayHi();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public GreetingService getGreetingService() {
        return this.applicationContext.getBean(GreetingService.class);
    }
}
