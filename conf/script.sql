CREATE TABLE product_category (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

 
CREATE TABLE product (
    id VARCHAR(255) NOT NULL,
    url VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    main_image VARCHAR(255) NULL,
    brand VARCHAR(255) NULL,
    brief_description VARCHAR(255) NULL,
    other_images VARCHAR(600) NULL,
    properties VARCHAR(600) NULL,
    description VARCHAR(600) NULL,
    price INT NULL,
    overall_rating INT NULL,
    volume VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

 
ALTER TABLE product ADD COLUMN product_category_id VARCHAR(255) NULL;
CREATE INDEX fk_product_category_id_idx ON product (product_category_id);

ALTER TABLE product
ADD CONSTRAINT fk_product_category_id
 FOREIGN KEY (product_category_id)
 REFERENCES product_category (id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION;
