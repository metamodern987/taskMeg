package metamodern7.testspringboot.securityConfig;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by igor on 02.06.2020
 */

public class WebAppInitial extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            WebFluxAutoConfiguration.WebFluxConfig
        .class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};             //для перехвата всех запросов диспетчером
    }
}
