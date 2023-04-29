package ProjetoClientes.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {
	
	@Bean
	public MessageSource messagesource() {
		ReloadableResourceBundleMessageSource messaSource = new ReloadableResourceBundleMessageSource();
		messaSource.setBasename("messages");
		messaSource.setDefaultEncoding("ISO-8859-1");
		messaSource.setDefaultLocale(Locale.getDefault());
		return messaSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messagesource());
		
		return bean;
		
	}

}
