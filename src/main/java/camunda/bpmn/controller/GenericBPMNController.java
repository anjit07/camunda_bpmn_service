package camunda.bpmn.controller;

import camunda.bpmn.service.EvaluateBPMNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bpmn")
public class GenericBPMNController {

    @Autowired
    private EvaluateBPMNService evaluateDMNService;


    @PostMapping(value = "/{processKey}/start",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> evaluate(@PathVariable("processKey") String processKey, @RequestBody Map<String,Object> variables){

        return evaluateDMNService.startProcess(processKey,variables);
    }

}
