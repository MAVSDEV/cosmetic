CREATE TABLE product_category (
    id INT NOT NULL,
    name VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

 
CREATE TABLE product (
    id INT NOT NULL,
    url VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    directions VARCHAR(255) NULL,
    main_image VARCHAR(255) NULL,
    brand VARCHAR(45) NULL,
    brief_description VARCHAR(45) NULL,
    other_images VARCHAR(45) NULL,
    property VARCHAR(45) NULL,
    description VARCHAR(45) NULL,
    price INT NULL,
    overall_rating INT NULL,
    PRIMARY KEY (id)
);

 
ALTER TABLE product ADD COLUMN category_id INT NULL;
CREATE INDEX fk_category_id_idx ON product (category_id);

ALTER TABLE product
ADD CONSTRAINT fk_category_id
 FOREIGN KEY (category_id)
 REFERENCES product_category (id)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION;