package org.yfr;

@org.springframework.stereotype.Repository
public class RepositoryQ implements Repository {

    @Override
    public String findName() {
        return "QQ Chan";
    }
}
