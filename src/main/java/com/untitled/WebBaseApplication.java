package com.untitled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;

import com.untitled.aspect.AuditingDateTimeProvider;
import com.untitled.security.entity.User;

@SpringBootApplication
@EntityScan(basePackages = { "com.untitled.data.entity" })
@EnableJpaRepositories(basePackages = { "com.untitled.data.repo" })
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class WebBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBaseApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			// ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED,
			// "/401.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
			// ErrorPage error500Page = new
			// ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

			container.addErrorPages(
					// error401Page,
					// error500Page,
					error404Page);
		});
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new com.untitled.aspect.SpringSecurityAuditorAware();
	}

	@Bean
	DateTimeProvider dateTimeProvider() {
		return new AuditingDateTimeProvider();
	}
}
