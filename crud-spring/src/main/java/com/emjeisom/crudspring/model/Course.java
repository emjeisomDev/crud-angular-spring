package com.emjeisom.crudspring.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "courses")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;
    
    @NotBlank
    @NotNull
    @Length(min=3, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "back-end|front-end")
    @Column(name = "category", length = 20, nullable = false)
    private String category;

}