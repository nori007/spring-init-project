package com.sample.common.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tbl-gen")
    @TableGenerator(name = "tbl-gen", pkColumnName = "entity_tbl_name", allocationSize = 10, table = "entity_ids")
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreatedDate
    @Column(name="created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private Date updatedAt;

}
