package alkemy.challenge.Challenge.Alkemy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_testimonials")
@SQLDelete(sql = "UPDATE db_testimonials SET deleted WHERE name =?")
@FilterDef(name = "deletedTestimonyFilter", parameters = @ParamDef(name = "isDeleted", type
        = "boolean"))
@Filter(name = "deletedTestimonyFilter", condition = "deleted = :isDeleted")
public class Testimony implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column
    private boolean deleted = Boolean.FALSE;

    //create the timestamp and save in db
    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;
    //modify the timestamp and update
    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

}
