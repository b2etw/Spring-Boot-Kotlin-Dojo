package org.yfr;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    public String findName() {
        return service.findName();
    }

}
