package com.teste.johndeere.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CorreiosConfig extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

  private static final List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("pt"));

  @Override
  @NonNull
  public Locale resolveLocale(final HttpServletRequest request) {
    final String headerLang = request.getHeader("Accept-Language");
    return headerLang == null || headerLang.isEmpty() ? Locale.getDefault()
        : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    final ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
    rs.setBasename("i18n/messages");
    rs.setDefaultEncoding("UTF-8");
    rs.setUseCodeAsDefaultMessage(true);
    return rs;
  }

  @Bean
  public RestTemplate restTemplate(final RestTemplateBuilder builder, final Environment env){
    Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
    converter.setSupportDtd(true);

    return builder.messageConverters(converter).build();
  }

}
