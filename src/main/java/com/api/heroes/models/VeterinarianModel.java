package com.api.heroes.models;

import com.api.heroes.models.enumerators.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "veterinarian")
public class VeterinarianModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String license;
    private String fileLicense;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getFileLicense() {
        return fileLicense;
    }

    public void setFileLicense(String fileLicense) {
        this.fileLicense = fileLicense;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
