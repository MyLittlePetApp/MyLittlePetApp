package br.com.mylittlepet.web.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.mylittlepet.model.entity.Pet;
import br.com.mylittlepet.web.viewresolver.CustomXMLViewResolver;
import br.com.mylittlepet.web.viewresolver.JsonViewResolver;

@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan(value="br.com.mylittlepet")
@PropertySource(value = { "classpath:application.properties" })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(internalResourceViewResolver());
		resolvers.add(new JsonViewResolver());
		resolvers.add(getMarshallingXmlViewResolver());

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		return resolver;
	}

	@Bean
	public CustomXMLViewResolver getMarshallingXmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Pet.class);
		return new CustomXMLViewResolver(marshaller);
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean(name = "messageSource")
	public MessageSource loadBundle() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(env.getProperty("smtp.host"));
		mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
		mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
		mailSenderImpl.setUsername(env.getProperty("smtp.username"));
		mailSenderImpl.setPassword(env.getProperty("smtp.password"));
		Properties javaMailProps = new Properties();
		javaMailProps.put("mail.smtp.auth", true);
		javaMailProps.put("mail.smtp.starttls.enable", true);
		mailSenderImpl.setJavaMailProperties(javaMailProps);
		return mailSenderImpl;
	}

}