package com.ict01.jpaproject01;

public class ResourceNotFoundExeption extends Exception {

    public static final long serialVersionUID = 1L;
    // 직렬화 버전 UID

    public ResourceNotFoundExeption(Object resourceId){
        super(resourceId != null ? resourceId.toString() : null);
        // 원하는 id를 Spring으로 가져옴
    }
}
