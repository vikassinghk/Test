package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.aop.annotation.ParmsAudit;

@Aspect
public class AuditAspect {

@Before(value="execution(@uk.co.billcomer.audit.ParmsAudit * *(..)) &&   @annotation(parmsAudit)", argNames="parmsAudit")
public void logTheAuditActivity(JoinPoint aPoint, ParmsAudit parmsAudit) {
 String userName = getUserName();
 mlogger.info("Parms Auditing User Name: " + userName);
 mlogger.info("auditType:" + parmsAudit.auditType().getDescription());

 String arguments = getArgs(aPoint.getArgs());

 if (arguments.length() > 0) {
 mlogger.info("args-" + arguments);
 }
}

private String getArgs(Object[] args) {
 String arguments = "";
 int argCount = 0;

 for (Object object : args) {
   if (argCount > 0) {
     arguments += ", ";
   }
   arguments += "arg[" + ++argCount + "]=" + "[" + object + "]";
 }
 return arguments;
}

private String getUserName() {
   return "Unknown User";
}
}