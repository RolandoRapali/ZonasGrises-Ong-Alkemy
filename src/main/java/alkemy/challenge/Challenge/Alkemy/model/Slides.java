package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "slides")
public class Slides implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_slides;

    private String imageUrl;

    private String text;

    private String order;

    private String organizationId;

}
