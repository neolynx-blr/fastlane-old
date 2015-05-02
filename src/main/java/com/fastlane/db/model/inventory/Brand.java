package com.fastlane.db.model.inventory;

import lombok.Data;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "brand")
@Builder(fluent = false)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tag_line")
    private String tagLine;

    @Column(name = "description")
    private String description;

    /**
     * Using the JSON structure to store image URLs along with the dimension and possibly other artifacts about
     * the image. Need to look at alternative data structure for optimisation.
     *
     * Brand will be created for every vendor for which Image, Tag line etc. could be missing
     */
    @Column(name = "image_json")
    private String imageURLJSON;

    // Date when this brand on-boarded on the system
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

}