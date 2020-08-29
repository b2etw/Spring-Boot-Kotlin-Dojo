package org.yfr;

public class Service2Upper implements Service {

    private Repository repository;

//    public Service2Upper(Repository repository) {
//        this.repository = repository;
//    }

    @Override
    public String findName() {
        return repository.findName().toUpperCase();
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
