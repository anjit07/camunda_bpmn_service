package camunda.bpmn.listeners;

import camunda.bpmn.delegator.CollectDoc;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("userTaskListener")
public class UserTaskListener implements ExecutionListener {

    private final Logger LOGGER = LoggerFactory.getLogger(UserTaskListener.class.getName());

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Reject document :"+ delegateExecution.getVariable("rejectDoc"));
    }
}
