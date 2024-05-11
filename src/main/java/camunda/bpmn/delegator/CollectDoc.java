package camunda.bpmn.delegator;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("collectDoc")
public class CollectDoc implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(CollectDoc.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Collect document ");
        LOGGER.info("Pan : "+delegateExecution.getVariable("pan"));
        LOGGER.info("Aadhar :  "+delegateExecution.getVariable("aadhar"));
    }
}
