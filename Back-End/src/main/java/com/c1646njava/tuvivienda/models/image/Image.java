package com.c1646njava.tuvivienda.models.image;

import com.c1646njava.tuvivienda.models.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Table(name  = "image")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class Image {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "public_id")
        private String publicId;
        @Column(name = "url")
        private String url;
        @Column(name = "secure_url")
        private String secureUrl;
        @Column(name = "format")
        private String format;



        public Image(String publicId, String url, String secureUrl, String format) {
            this.publicId = publicId;
            this.url = url;
            this.secureUrl = secureUrl;
            this.format = format;
        }
    }