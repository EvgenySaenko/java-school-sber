package ru.socialnetwork.persist.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class Info {
    private Long id;

    private Calendar dateOfBirth;

    private String birthPlace;

    private String schoolPlace;

    private String workPlace;

    private String education;

    public Info(Long id, Calendar dateOfBirth, String birthPlace, String schoolPlace, String workPlace, String education) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.birthPlace = birthPlace;
        this.schoolPlace = schoolPlace;
        this.workPlace = workPlace;
        this.education = education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSchoolPlace() {
        return schoolPlace;
    }

    public void setSchoolPlace(String schoolPlace) {
        this.schoolPlace = schoolPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(id, info.id) && Objects.equals(dateOfBirth, info.dateOfBirth) && Objects.equals(birthPlace, info.birthPlace) && Objects.equals(schoolPlace, info.schoolPlace) && Objects.equals(workPlace, info.workPlace) && Objects.equals(education, info.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, birthPlace, schoolPlace, workPlace, education);
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", dateOfBirth=" +  new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth.getTime()) +
                ", birthPlace='" + birthPlace + '\'' +
                ", schoolPlace='" + schoolPlace + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
