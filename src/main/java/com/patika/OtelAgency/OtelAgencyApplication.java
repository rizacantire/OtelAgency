package com.patika.OtelAgency;

import com.patika.OtelAgency.business.abstracts.OtelService;
import com.patika.OtelAgency.business.abstracts.OtelTypeService;
import com.patika.OtelAgency.business.concretes.OtelManager;
import com.patika.OtelAgency.core.Helper.Helper;
import com.patika.OtelAgency.dataAccess.abstracts.OtelDao;
import com.patika.OtelAgency.entities.Otel;
import com.patika.OtelAgency.view.OtelGUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class OtelAgencyApplication {
	private static OtelService otelService;


	public static void main(String[] args) {

		//SpringApplication.run(OtelAgencyApplication.class, args);

		ConfigurableApplicationContext context = new SpringApplicationBuilder(OtelAgencyApplication.class).headless(false).run(args);
		OtelGUI otelGui = context.getBean(OtelGUI.class);
		Helper.setLayout();
		otelGui.setVisible(true);


	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

}
