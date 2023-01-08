package com.Hb03.ManyToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book08 {
    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "student")
    private List<Student08> books=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student08> getBooks() {
        return books;
    }

    public void setBooks(List<Student08> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
