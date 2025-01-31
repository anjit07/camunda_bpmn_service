package camunda.bpmn.delegator;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("exceptionHandler")
public class ExceptionHandler implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info("DelegateExecution catcherrorMessage {} ",delegateExecution.getVariable("catcherrorMessage"));

        String errorJson = (String) delegateExecution.getVariable("catcherrorMessage");

        // Convert JSON string to Map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> errorDetails = objectMapper.readValue(errorJson,new TypeReference<Map<String,Object>>() {});
        LOGGER.info("DelegateExecution message {} ",errorDetails.get("message"));




    }


}
