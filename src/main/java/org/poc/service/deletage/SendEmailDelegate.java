package org.poc.service.deletage;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendEmailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Enviando email com aprovação com status: "
                + execution.getVariable("approved"));
    }
}
