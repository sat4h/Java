package com.example.demo.jms;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAspectDatabaseChanges {
    @Autowired
    private JmsSendEvent jmsSendEvent;

    private void sendJmsEvent(String name, String retVal) {
        if (name.contains(EventType.save.name())) {
            jmsSendEvent.sendEvent("event", new WatchDog(retVal, EventType.save));
            jmsSendEvent.sendEvent("email", new EmailEntity("test@example.ru", retVal));
        } else if (name.contains(EventType.delete.name())) {
            jmsSendEvent.sendEvent("event", new WatchDog(retVal, EventType.delete));
            jmsSendEvent.sendEvent("email", new EmailEntity("test@example.ru", ""));
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.repository.EnergyRepository.*(..))", returning = "retVal")
    public void trackDatabaseEnergyChanges(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().toString();
        if (retVal == null) {
            sendJmsEvent(name, "Energy");
        } else {
            sendJmsEvent(name, retVal.toString());
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.repository.GameRepository.*(..))", returning = "retVal")
    public void trackDatabaseGameChanges(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().toString();
        if (retVal == null) {
            sendJmsEvent(name, "Game");
        } else {
            sendJmsEvent(name, retVal.toString());
        }
    }
}
