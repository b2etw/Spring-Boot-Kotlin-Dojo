package org.yfr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2Lower implements Service {

    @Autowired
    private Repository repositoryQ;

    @Override
    public String findName() {
        return repositoryQ.findName().toLowerCase();
    }
}