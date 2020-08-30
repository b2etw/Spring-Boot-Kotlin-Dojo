package org.yfr;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public String findName() {
        return service.findName();
    }

    public void setService(Service service) {
        this.service = service;
    }
}
