package camunda.bpmn.delegator;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("prepareSubProcessData")
public class PrepareSubProcessData implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(CollectDoc.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info("PrepareSubProcessData..!! ");

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<Integer> ids2 = new ArrayList<>();
        ids2.add(55);
        ids2.add(66);

        Map<String,Object> orignal = new HashMap<>();
        orignal.put("refId",123);
        orignal.put("ismixContain",true);
        orignal.put("ids",ids);


        Map<String,Object> additional = new HashMap<>();
        additional.put("refId",999);
        additional.put("ismixContain",false);
        additional.put("ids",ids2);

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(orignal);
        list.add(additional);
        delegateExecution.setVariable("list",list);


        LOGGER.info("PrepareSubProcessData reviewCollection=== "+delegateExecution.getVariable("test"));


    }
}