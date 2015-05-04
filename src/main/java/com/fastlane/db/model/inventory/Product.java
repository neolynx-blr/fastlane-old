package com.fastlane.db.model.inventory;

import com.fastlane.helper.models.Measure;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long id;

    /* This is to record barcode number printed on the product itself */
    @Column(name = "barcode_id", nullable = false)
    private Long barCodeId;

    @Column(name = "vendor_id", nullable = false)
    private Long vendorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    @Column(name = "category_ids")
    private List<Long> categoryIds;

    /**
     * Some products have specificity beyond just tags, that should be covered in description
     * or bring about another tag-line kind of variable, Example: "Car Cleaning Kit, 5 pcs",
     */
    @Column(name = "tag_line")
    private String tagLine;

    @Column(name = "description")
    private String description;


    /**
     * The item specifications, like nutrition value, expected to be available in one of the following formats. Need
     * to explore 3rd party OCR.
     * nutritionValueJSON;
     * ingredientsValueJSON
     */
    @Column(name = "additional_json")
    private String additionalInformation;

    @Column(name = "measure")
    private Measure quantityMeasure;

    /**
     * Captures the generic images of the product shown during searches
     * <p/>
     * Using the JSON structure to store image URLs along with the dimension and possibly other artifacts about the
     * image. Need to look at alternative data structure for optimisation. Also, need to workout something about taking
     * product images or crawling/finding online.
     */
    @Column(name = "image_json")
    private String imageURLJSON;
}
