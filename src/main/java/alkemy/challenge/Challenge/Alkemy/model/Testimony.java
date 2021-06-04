package alkemy.challenge.Challenge.Alkemy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.*;


import javax.persistence.*;

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

    @Column(name = "IMAGE")
    private String image;

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
