package com.test.doc;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;
import com.google.common.net.HostAndPort;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig  {
	private final String HOST = "http://127.0.0.1:8080";
	/**
     * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */
    @Bean
    public Docket customDocket(){
       Docket docket = new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(getCustom())
               .paths(this.pathsCustom())
               .build();
       docket.apiInfo(getCustomerApiInfo()).groupName("user").host(HOST).pathMapping("/app/v2");
       return docket;
    }
   
   
    @Bean
    public UiConfiguration uiConfig() {
    	return UiConfiguration.DEFAULT;
    }
    private ApiInfo getCustomerApiInfo(){
    	ApiInfoBuilder builder = new ApiInfoBuilder();
    	return builder.title("title").description("desc").version("v2").license("private")
    			.licenseUrl("http://www.example.com").build();
    }
   
    @SuppressWarnings("unchecked")
    private Predicate<String> pathsCustom() {
      return or(regex("/.*"));
    }
    
    private Predicate<RequestHandler> getCustom(){
    	return RequestHandlerSelectors.basePackage("com.test.action");
    }
   
}
