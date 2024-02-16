package com.c1646njava.tuvivienda.models.administrator;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.models.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Administrator")
public class Administrator extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany
    private Post posts;
}
