package camunda.bpmn.delegator;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendEmailDelegate implements JavaDelegate {


    private final Logger LOGGER = LoggerFactory.getLogger(SendEmailDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Send Email Delegate");
        delegateExecution.setVariable("emailStatus","Email Send successfully");
    }
}
