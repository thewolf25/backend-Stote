package org.ecommerce.config;

import java.util.Optional;

import org.ecommerce.entities.Category;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.geo.GeoModule;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.mediatype.hal.CurieProvider;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.mvc.RepresentationModelProcessorInvoker;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ExposeEntityIdRestConfiguration extends RepositoryRestMvcConfiguration {

    

	public ExposeEntityIdRestConfiguration(ApplicationContext context,
			ObjectFactory<ConversionService> conversionService, Optional<LinkRelationProvider> relProvider,
			Optional<CurieProvider> curieProvider, Optional<HalConfiguration> halConfiguration,
			ObjectProvider<ObjectMapper> objectMapper, ObjectProvider<RepresentationModelProcessorInvoker> invoker,
			MessageResolver resolver, GeoModule geoModule) {
		super(context, conversionService, relProvider, curieProvider, halConfiguration, objectMapper, invoker, resolver,
				geoModule);
		// TODO Auto-generated constructor stub
	}

	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Category.class);
    }
}