package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@NoArgsConstructor
@Table(name="CATEGORIES")
@Entity
@SQLDelete(sql = "UPDATE table_CATEGORIES SET deleted = true WHERE ID_CATEGORIES=?")
@Where(clause = "deleted=false")
public class CategoriesModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
    
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
    
    private String timeStamp = date.format(new Date());
    
    private boolean delete = Boolean.FALSE;
    
}
