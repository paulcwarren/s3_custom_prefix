package spring_content.examples.s3_custom_prefix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.content.commons.property.PropertyPath;
import org.springframework.content.commons.store.SetContentParams;

import java.io.ByteArrayInputStream;

@SpringBootTest
class SpringApplicationTests {

	@Autowired
	private SampleRepository repo;

	@Autowired
	private SampleContentStore store;

	@Test
	void contextLoads() {
		Sample s = repo.save(new Sample());
		s = store.setContent(s, PropertyPath.from("content"), new ByteArrayInputStream("foo".getBytes()), SetContentParams.builder().build());
	}
}
