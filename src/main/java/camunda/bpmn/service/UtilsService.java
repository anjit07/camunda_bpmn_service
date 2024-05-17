package camunda.bpmn.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("utilsService")
public class UtilsService {



    public String createSystemUser(String name){

        System.out.println("CreateSystemUser : "+name);

        return "System user created successfully";
    }


    public List<String> getDocList(){

        List<String> list = new ArrayList<>();
        list.add("PAN");
        list.add("Adhar");
        return list;
    }

    public String sampleMesg(String msg){

        System.out.println("INFO : "+msg);

        return msg;
    }

}
