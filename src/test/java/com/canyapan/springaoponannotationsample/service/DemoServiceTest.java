package com.canyapan.springaoponannotationsample.service;

import com.canyapan.springaoponannotationsample.aspect.CustomAnnotationAspect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DemoServiceTest {
    @Autowired
    private DemoService service;

    @SpyBean
    private CustomAnnotationAspect aspect;

    @Test
    void shouldRunServiceTriggerAnnotation() throws Throwable {
        service.myTargetMethod();

        verify(aspect).executionLogger(any());

        // Output: 2021-03-03 00:15:45.596  INFO 9795 --- [    Test worker] c.c.s.aspect.CustomAnnotationAspect      : Method with the CustomAnnotation on com.canyapan.springaoponannotationsample.service.DemoService executed! took: PT0.011574S
    }

}