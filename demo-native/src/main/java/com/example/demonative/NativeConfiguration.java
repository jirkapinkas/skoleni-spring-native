package com.example.demonative;

import com.example.demonative.pojo.Stuff;
import com.example.demonative.service.MessageService;
import org.springframework.context.annotation.Configuration;
import org.springframework.nativex.hint.*;

// Toto je konfigurace pres anotace (zakladni). Bud se pouziva tato konfigurace,
// nebo se pouziva konfigurace z CustomClientNativeConfigurationProcessor
//@NativeHint(options = "--enable-https -H:+AddAllCharsets")
//@TypeHint(types = {
//        Stuff.class,
//}, access = {TypeAccess.DECLARED_METHODS, TypeAccess.DECLARED_CONSTRUCTORS})
//@AotProxyHint(targetClass= MessageService.class, proxyFeatures = ProxyBits.IS_STATIC)
//@Configuration
public class NativeConfiguration {
}
