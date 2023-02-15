package com.siwaphiwe.spring.boot.crud.app.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String second_name;

    @Column(unique = true)
    private String email;

    @Column
    private String start_date;
    @Column
    private String gender;
    @Column
    private String address;

    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="department_id",referencedColumnName = "id")
     private Department department;







}
