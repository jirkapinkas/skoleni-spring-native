package com.example.demonative;

import com.example.demonative.pojo.Stuff;
import com.example.demonative.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.aot.context.bootstrap.generator.infrastructure.nativex.BeanFactoryNativeConfigurationProcessor;
import org.springframework.aot.context.bootstrap.generator.infrastructure.nativex.NativeConfigurationRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.nativex.hint.*;

@NativeHint(options = "--enable-https -H:+AddAllCharsets")
@TypeHint(types = {
        Stuff.class,
}, access = {TypeAccess.DECLARED_METHODS, TypeAccess.DECLARED_CONSTRUCTORS})
@AotProxyHint(targetClass = MessageService.class, proxyFeatures = ProxyBits.IS_STATIC)
@Slf4j
public class CustomClientNativeConfigurationProcessor implements BeanFactoryNativeConfigurationProcessor {
    public void process(ConfigurableListableBeanFactory beanFactory, NativeConfigurationRegistry registry) {
        var rootPackage = DemoNativeApplication.class.getPackageName();
        log.info("scan for DTOs in root package (and it's subpackages): {}", rootPackage);
        var classesSet = new Reflections(rootPackage).getTypesAnnotatedWith(Dto.class);
        log.info("registered DTOs: {}", classesSet);
        classesSet.forEach(aClass -> {
            registry.reflection().forType(aClass)
                    .withAccess(TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.DECLARED_METHODS);
        });
    }
}