package com.enterprise.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * JavaDoc: API文档
 * Swagger: 自动化API文档
 *
 * @author agony
 * @date 2020/5/24 23:01
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.enterprise.swagger2"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .description("swagger2")
                        .contact(new Contact("qing3gan", "https://github.com/qing3gan", "qing3gan@gmail.com"))
                        .version("1.0")
                        .title("swagger2")
                        .license("Apache2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSES-2.0")
                        .build()
                );
    }
}
