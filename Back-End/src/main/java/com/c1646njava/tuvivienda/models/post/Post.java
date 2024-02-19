package com.c1646njava.tuvivienda.models.post;

import java.util.List;

import com.c1646njava.tuvivienda.models.administrator.Administrator;
import com.c1646njava.tuvivienda.models.image.ImagePost;
import com.c1646njava.tuvivienda.models.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "post")
public class Post {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "bedrooms")
    private Integer bedrooms;
    @Column(name = "address")
    private String address;
    @Column(name = "views")
    private Long views;
    @Column(name = "price")
    private Long price;
    @Column(name = "comments")
    private List<String> comments;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "id")
    private Administrator administrator;

    @OneToMany
    private List<ImagePost> image;

}
