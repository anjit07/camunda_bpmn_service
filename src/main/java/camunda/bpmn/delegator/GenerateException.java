package camunda.bpmn.delegator;

import camunda.bpmn.exception.CustomProcessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("generateException")
public class GenerateException implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(GenerateException.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {


        LOGGER.info("ErrorHandlingDL..!! {} ", delegateExecution.getBusinessKey());
        String errorMessage = prepareError();
        LOGGER.info("ErrorHandlingDL errorMessage {} ##### ", errorMessage);



           throw new BpmnError("global_exception",errorMessage );

        //throw new CustomProcessException("test",errorMessage);


    }


    private String prepareError() throws JsonProcessingException {
        // Prepare JSON error details
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("errorCode", "SERVICE_FAILURE");
        errorDetails.put("message", "External service failed");
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("additionalInfo", "Retry after 10 seconds");

        // Convert Map to JSON string
        ObjectMapper objectMapper = new ObjectMapper();


        return objectMapper.writeValueAsString(errorDetails);
    }

}