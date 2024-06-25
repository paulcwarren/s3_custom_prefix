package spring_content.examples.s3_custom_prefix;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ContentId
    private UUID contentId;
    @ContentLength
    private long contentLength;
}