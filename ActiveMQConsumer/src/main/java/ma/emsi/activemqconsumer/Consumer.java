package ma.emsi.activemqconsumer;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class Consumer {
    @JmsListener(destination = "G3-Centre")
    public void getFromQueue(String msg){
        //Processing
        System.out.println("MSG: " + msg);
    }
}
