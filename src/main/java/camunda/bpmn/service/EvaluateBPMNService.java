package camunda.bpmn.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.dmn.DecisionEvaluationBuilder;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessInstanceWithVariablesImpl;
import org.camunda.bpm.engine.impl.pvm.ProcessDefinitionBuilder;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.rest.sub.repository.impl.ProcessDefinitionResourceImpl;
import org.camunda.bpm.engine.rest.util.EngineUtil;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.graalvm.shadowed.org.jcodings.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class EvaluateBPMNService {

    public Map<String,Object> startProcess(String processKey,Map<String,Object> variables){

        Map<String,Object> response = null;

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        String businessKey  = processKey+"-"+rand_int1;
        // Initialize the process engine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processKey,businessKey, variables);
        response = prepareResponse(processEngine,processInstance);
        return response;
    }

    private Map<String,Object> prepareResponse( ProcessEngine processEngine,ProcessInstance processInstance){

        Map<String,Object> processResponse = new HashMap<>();
        processResponse.put("id",processInstance.getId());
        processResponse.put("definitionId",processInstance.getProcessDefinitionId());
        processResponse.put("businessKey",processInstance.getBusinessKey());
        processResponse.put("caseInstanceId",processInstance.getCaseInstanceId());
        processResponse.put("ended",processInstance.isEnded());
        processResponse.put("suspended",processInstance.isSuspended());
        processResponse.put("tenantId",processInstance.getTenantId());
        processResponse.put("variables", processEngine.getRuntimeService().getVariables(processInstance.getId()));

        return processResponse;
    }

}
