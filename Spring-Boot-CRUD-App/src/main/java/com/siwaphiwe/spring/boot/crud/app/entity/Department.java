package com.siwaphiwe.spring.boot.crud.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "tbl_department")
public class Department {
    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String department_name;

    @Column
    private String location;

    @Column
    private String country;


}
