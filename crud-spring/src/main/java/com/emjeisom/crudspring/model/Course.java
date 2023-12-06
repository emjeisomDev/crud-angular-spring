package com.emjeisom.crudspring.model;

import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
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
@SQLDelete(sql = "UPDATE Course SET status = 'inactive' WHERE id = ? ")
@Entity(name = "course")
@Where(clause = "status ='active'")
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

    @NotBlank
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "active|inactive")
    @Column(length = 20, nullable = false)
    private String status = "active";

	public Course() {}

	public Course(Long id, @NotBlank @NotNull @Length(min = 3, max = 100) String name,
			@NotBlank @NotNull @Length(max = 10) @Pattern(regexp = "back-end|front-end") String category,
			@NotBlank @NotNull @Length(max = 10) @Pattern(regexp = "active|inactive") String status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", category=" + category + ", status=" + status + "]";
	}
	
}