package com.canyapan.springaoponannotationsample.service;

import com.canyapan.springaoponannotationsample.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @CustomAnnotation
    public void myTargetMethod() {
        // Runs some business logic...
        // Please see the tests.
    }
}
