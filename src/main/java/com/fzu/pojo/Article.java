/*
 * 文章
 */

package com.fzu.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_article")
@DynamicInsert
@Getter @Setter
public class Article extends BaseModel {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "public_name", referencedColumnName = "public_name")
    private Exclusive exclusive;//用户的独家号

    @Column(length = 50)
    private String title;//文章的标题

    @Column(length = 50)
    private String url;//文章的地址

    @Column(name = "create_time")
    private Date createTime;//发布的时间

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    private Set<Comment> comments = new HashSet<Comment>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")
    private Set<Collect> collects = new HashSet<Collect>();

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}