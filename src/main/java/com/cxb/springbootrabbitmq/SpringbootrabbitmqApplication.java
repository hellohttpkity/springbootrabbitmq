package com.cxb.springbootrabbitmq;

import com.cxb.springbootrabbitmq.config.PersonTet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.Sun;

import java.util.*;

@SpringBootApplication
@Transactional
public class SpringbootrabbitmqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootrabbitmqApplication.class, args);
        PersonTet personTet = run.getBean(PersonTet.class);
        System.out.println(personTet);

        HashSet<Object> set = new HashSet<>();
        set.add("a");
        boolean b = set.add("b");
        boolean a = set.add("a");
        System.out.println(a);
//        new TreeSet<>();
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("k", "v1");
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        Set<Object> keySet = map.keySet();
//        Collections.sort();
//        Collections.binarySearch();
//        Collections.swap();
//        Collections.synchronizedSet();
//        Collections.synchronizedMap();
        System.out.println("test001");
        System.out.println("test001");
        System.out.println("test001");

        for (Object o : keySet) {

        }

        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();

        }
    }

}
