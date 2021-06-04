package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Getter
@Setter
@NoArgsConstructor
@Table(name="CATEGORIES")
@Entity
@SQLDelete(sql = "UPDATE CATEGORIES SET deleted = true WHERE ID_CATEGORIES=?")
@Where(clause = "deleted=false")
public class CategoriesModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID_CATEGORIES")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="NAMES")
    private String names;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="IMAGES")
    private String images;
    
    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;
    
    @Column(name = "DELETE")
    private boolean delete = Boolean.FALSE;
    
}
