package camunda.bpmn.listeners;
import camunda.bpmn.exception.CustomProcessException;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("customExceptionListener")
public class CustomExceptionListener implements ExecutionListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionListener.class.getName());

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        try {
            // Get any exception thrown in the process
            LOGGER.info("CustomExceptionListener....!! ");


            Throwable throwable = (Throwable) execution.getVariable("camunda:exception");
            if (throwable instanceof CustomProcessException) {
                CustomProcessException customException = (CustomProcessException) throwable;
                throw new BpmnError(customException.getErrorCode(), customException.getMessage());
            }
        } catch (Exception e) {
            throw new BpmnError("UNHANDLED_ERROR", "An unhandled error occurred: " + e.getMessage());
        }
    }
}