package eu.ibacz.swsc.spring.di.testdependencyinjection.aspect;

import eu.ibacz.swsc.spring.commons.springdemocommons.Notifier;
import eu.ibacz.swsc.spring.commons.springdemocommons.SysOutNotifier;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class BankServiceLoggingAspect {
    private Notifier notifier;

   
    
    
    
    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }
    
    
    @Around("execution(* eu.ibacz.swsc.spring.di.testdependencyinjection.service.BankService.createNewCustomer(..)) && args(firstname, lastname) )")
    public Object onNewCustomerCreated(ProceedingJoinPoint pjp, String firstname, String lastname) throws Throwable { 
        StringBuilder messageBuilder = new StringBuilder("Tesne pred vytvorenim noveho klienta se jmenem '").append(firstname)
                .append("' a prijmenim '").append(lastname).append("'.");
        notifier.notify(messageBuilder.toString());
        
        Object result = pjp.proceed(); //tady se zavola puvodni metoda, na kterou je aspekt zaveseny
        
        messageBuilder = new StringBuilder("Klient '").append(firstname).append(" ").append(lastname)
                .append("' byl uspesne vytvoren.");
        notifier.notify(messageBuilder.toString());
        
        return result;
    }
    
    @Around("execution(* eu.ibacz.swsc.spring.di.testdependencyinjection.service.BankService.getAllCustomers(..)) )")
    public Object onGetAllCustomers(ProceedingJoinPoint pjp) throws Throwable {
        notifier.notify("Tesne pred vybratim vsetkych klientov");
        Object result = pjp.proceed();
        return result;
    }
    
}
