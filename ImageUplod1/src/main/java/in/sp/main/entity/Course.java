package in.sp.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Image")
public class Course {

@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int id;
@Column
private String course_name;
@Column
private String course_detail;
@Column
private String image;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public String getCourse_detail() {
	return course_detail;
}
public void setCourse_detail(String course_detail) {
	this.course_detail = course_detail;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
