package spring_content.examples.s3_custom_prefix;

import org.springframework.content.s3.store.S3ContentStore;

import java.util.UUID;

public interface SampleContentStore extends S3ContentStore<Sample , UUID> {}

