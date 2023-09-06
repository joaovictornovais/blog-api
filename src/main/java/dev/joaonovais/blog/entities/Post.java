package dev.joaonovais.blog.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.joaonovais.blog.dtos.PostDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.w3c.dom.Text;

import java.time.Instant;

@Entity
@Table(name = "tb_post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant date;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(PostDTO postDTO) {
        BeanUtils.copyProperties(postDTO, this);
    }

}
