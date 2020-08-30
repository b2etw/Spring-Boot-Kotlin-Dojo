package org.yfr;

public class Service2Lower implements Service {

    private Repository repository;

    public Service2Lower(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String findName() {
        return repository.findName().toLowerCase();
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}