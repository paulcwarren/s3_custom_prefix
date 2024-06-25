package spring_content.examples.s3_custom_prefix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.content.commons.config.ContentPropertyInfo;
import org.springframework.content.s3.S3ObjectId;
import org.springframework.content.s3.config.S3StoreConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;

import java.util.UUID;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}

	@Configuration
	public static class S3Config {

		@Bean
		protected S3StoreConfigurer configurer() {
			return new S3StoreConfigurer() {
				@Override
				public void configureS3StoreConverters(ConverterRegistry converterRegistry) {
					converterRegistry.addConverter(new Converter<ContentPropertyInfo<Sample, UUID>, S3ObjectId>() {

						@Override
						public S3ObjectId convert(ContentPropertyInfo<Sample, UUID> source) {
							if (source == null) {
								throw new IllegalArgumentException("ContentId cannot be null");
							}

							// Create the S3 object key by appending the prefix
							String objectKey = "custom_prefix/" + source.contentId().toString();

							// Return the S3ObjectId with the bucket name and generated object key
							return new S3ObjectId("spring-eg-content-s3", objectKey);
						}
					});
				}
			};
		}
	}
}
