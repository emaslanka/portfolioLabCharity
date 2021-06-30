package pl.coderslab.charity.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.charity.converter.CategoryConverter;
import pl.coderslab.charity.converter.InstitutionConverter;


import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.coderslab")
@EnableTransactionManagement
@EnableJpaRepositories("pl.coderslab.charity.repositories")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(getInstitutionConverter());
        registry.addConverter(getCategoryConverter());
        }

    @Bean
    public CategoryConverter getCategoryConverter() {
        return new CategoryConverter();
    }

    @Bean
    public InstitutionConverter getInstitutionConverter() {
        return new InstitutionConverter();
    }
}
