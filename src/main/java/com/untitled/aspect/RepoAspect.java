package com.untitled.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.untitled.data.entity.BaseEntity;
import com.untitled.security.entity.User;
import com.untitled.security.repo.UserRepository;


@Aspect
@Component
public class RepoAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(RepoAspect.class);
	
	@Autowired
	UserRepository repo;
	/*
	@Pointcut("execution(public !void org.springframework.data.repository.Repository+.save(..))")
	public void save() {}
	
	@Around("save()") 
	public Object doBeforeTask(ProceedingJoinPoint pjp) throws Throwable{
		LOGGER.info(Long.toString(pjp.getArgs().length));
		for (final Object argument : pjp.getArgs())
        {
			LOGGER.info(argument.getClass().getName());
            if (argument instanceof BaseEntity) 
            {
            	String name = SecurityContextHolder.getContext().getAuthentication().getName();
            	User loggedUser;
            	if(!name.equals("anonymousUser")){
            		loggedUser = repo.findByUserName(name);
            		loggedUser.setPassword("");
            		LOGGER.info("+++"+loggedUser.getUserName());
            	}
            	else{
            		loggedUser = null;
            	}
            	
            	
            	BaseEntity entity = (BaseEntity) argument;
            	entity.setDateCreated(new Date(System.currentTimeMillis()));
            	entity.setCreatedBy(loggedUser);
            	
            	

            }
            else{
            	LOGGER.info(argument.getClass().getName()+" is not a BaseEntity");
            }

        }
		
		Object obj = pjp.proceed();
		
		LOGGER.info("Saving "+obj.getClass().toString()+" executed by "+SecurityContextHolder.getContext().getAuthentication().getName());
		
		return obj;
	}
*/
}
