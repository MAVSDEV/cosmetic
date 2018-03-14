CREATE TABLE public.product_category (
    id bigint NOT NULL,
    name VARCHAR(255) NULL,
    constraint pk_product_category primary key (id)
);

 
CREATE TABLE public.product (
    id bigint NOT NULL,
    url VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    main_image VARCHAR(255) NULL,
    brand VARCHAR(255) NULL,
    brief_description VARCHAR(255) NULL,
    other_images VARCHAR(600) NULL,
    properties VARCHAR(600) NULL,
    description VARCHAR(600) NULL,
    price bigint NULL,
    overall_rating bigint NULL,
    volume VARCHAR(255) NULL,
    creation_date DATE NOT NULL DEFAULT '2011-01-26 14:30:00',
    product_category_id bigint,
    constraint pk_product primary key (id)
);

CREATE SEQUENCE product_id_seq MINVALUE 10;
ALTER TABLE product ALTER id SET DEFAULT nextval('product_id_seq');
ALTER SEQUENCE product_id_seq OWNED BY product.id;

CREATE SEQUENCE product_category_id_seq MINVALUE 10;
ALTER TABLE product_category ALTER id SET DEFAULT nextval('product_category_id_seq');
ALTER SEQUENCE product_category_id_seq OWNED BY product_category.id;

--drop sequence if exists product_category_seq;
--
--drop sequence if exists product_seq;
--
--drop table product;
--
--drop table product_category ;
--
