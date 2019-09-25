package com.sony.sonyservice;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter
{
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }
 
    @Bean(name = "cotizaciones")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema sonySchema)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CotizacionPort");
        wsdl11Definition.setLocationUri("/ws/cotizaciones");
        wsdl11Definition.setTargetNamespace("http://www.sony.com/sonyservice/cotizaciones");
        wsdl11Definition.setSchema(sonySchema);
        return wsdl11Definition;
    }
    
    @Bean(name = "validaciones")
    public DefaultWsdl11Definition defaultWsdl11DefinitionValidar(XsdSchema sonySchemaValidador)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ValidacionPort");
        wsdl11Definition.setLocationUri("/ws/validaciones");
        wsdl11Definition.setTargetNamespace("http://www.sony.com/sonyservice/validaciones");
        wsdl11Definition.setSchema(sonySchemaValidador);
        return wsdl11Definition;
    }
 
    @Bean
    public XsdSchema sonySchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("sony.xsd"));
    }
    
    @Bean
    public XsdSchema sonySchemaValidador()
    {
        return new SimpleXsdSchema(new ClassPathResource("sonyValidar.xsd"));
    }
}