package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comments implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coments")
    private Long id;
    
    @ManyToOne
    @JoinColumn
    private News post_id;
    
    private String body;
    
    @ManyToOne
    @JoinColumn
    private  User user_id;

    public Comments(News post_id, String body, User user_id) {
        this.post_id = post_id;
        this.body = body;
        this.user_id = user_id;
    }
}
