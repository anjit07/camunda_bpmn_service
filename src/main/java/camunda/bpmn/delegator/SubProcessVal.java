package camunda.bpmn.delegator;

import camunda.bpmn.CamundaBPMNApplication;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("SubProcessVal")
public class SubProcessVal implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(CollectDoc.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("SubProcessVal ");
        LOGGER.info("SubProcessVal refId=== : "+delegateExecution.getVariable("refId"));
        LOGGER.info("SubProcessVal ismixContain=== : "+delegateExecution.getVariable("ismixContain"));
        LOGGER.info("SubProcessVal ids=== : "+delegateExecution.getVariable("ids"));

    }

    public static void main(String[] args) {

        SubProcessVal v = new  SubProcessVal();
        v.tesList();

    }


    public void tesList(){
        List<Integer> addtionBdayId = new ArrayList<>();
       // addtionBdayId.add(7);
        //addtionBdayId.add(6);


        List<Integer> orignal = new ArrayList<>();
        orignal.add(7);
        orignal.add(6);
        orignal.add(5);
        orignal.add(4);
        orignal.add(3);

        List<Integer> finalList = orignal.stream()
                .filter(id -> !addtionBdayId.contains(id)) // Filter out elements present in `addtionBdayId`
                .collect(Collectors.toList()); // Collect the result into a List

        System.out.println("finalList===" + finalList);


    }
}
