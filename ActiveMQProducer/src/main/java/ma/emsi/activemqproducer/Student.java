package ma.emsi.activemqproducer;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
public class Student implements Serializable {
    private Integer id;
    private String name;
}
