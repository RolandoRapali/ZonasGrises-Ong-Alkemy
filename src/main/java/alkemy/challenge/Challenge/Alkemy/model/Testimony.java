package alkemy.challenge.Challenge.Alkemy.model;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_testimonials")
@SQLDelete(sql = "UPDATE db_testimonials SET deleted WHERE name =?")
@FilterDef(name = "deletedTestimonyFilter", parameters = @ParamDef(name = "isDeleted", type =
"boolean"))
@Filter(name = "deletedTestimonyFilter", condition = "deleted = :isDeleted")
public class Testimony implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "NAME")
    private String name;

    @Nullable
    @Column(name = "IMAGE")
    private String image;

    @Nullable
    @Column(name = "CONTENT")
    private String content;

    @Column
    private boolean deleted = Boolean.FALSE;

    //create the timestamp and save in db
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;
    //modify the timestamp and update
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updatedDate;


}
