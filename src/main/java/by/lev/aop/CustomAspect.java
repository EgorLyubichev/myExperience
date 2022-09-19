package by.lev.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAspect {

    private static final Logger log = Logger.getLogger(CustomAspect.class);

    @Pointcut("execution(* by.lev.repository.jdbctemplate.JdbcTemplateUserRepository.*(..))")
    public void aroundRepositoryPointcut(){

    }

    @Around("aroundRepositoryPointcut()")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable{

        //Use StopWatch

        log.info("Method " + joinPoint.getSignature().getName() + " start.");
        Object proceed = joinPoint.proceed();
        log.info("Method " + joinPoint.getSignature().getName() + " finish.\n");
        return proceed;
    }
}
