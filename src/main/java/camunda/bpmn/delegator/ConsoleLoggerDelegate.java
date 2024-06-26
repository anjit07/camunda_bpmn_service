package camunda.bpmn.delegator;

import jakarta.annotation.PostConstruct;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("logger")
public class ConsoleLoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(ConsoleLoggerDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("Current Activity Name: " + execution.getCurrentActivityName());

        LOGGER.info("getVariableNames : " + execution.getVariableNames());


        LOGGER.info("signalResponse : " + execution.getVariable("signalResponse"));


    }

}