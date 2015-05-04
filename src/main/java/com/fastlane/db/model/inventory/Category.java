package com.fastlane.db.model.inventory;

import lombok.Data;
import lombok.experimental.Builder;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
@Builder(fluent = false)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
