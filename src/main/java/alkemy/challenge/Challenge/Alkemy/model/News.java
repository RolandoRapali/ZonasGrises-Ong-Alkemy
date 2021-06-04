package alkemy.challenge.Challenge.Alkemy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;
    private String name;
    private String image;
    @Column(columnDefinition = "text")
    private String content;
    @CreationTimestamp
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_category_id")
    private Category categoryId;
    private boolean isDeleted;

    private static final long serialVersionUID = 1L;
}
