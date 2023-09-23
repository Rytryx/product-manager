CREATE TABLE `category` (
                            `active` TINYINT(4) NULL DEFAULT NULL,
                            `id` INT(11) NOT NULL,
                            `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                            PRIMARY KEY (`id`) USING BTREE
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB;

CREATE TABLE `product` (
                           `category_id` INT(11) NULL DEFAULT NULL,
                           `price` FLOAT NULL DEFAULT NULL,
                           `stock` INT(11) NULL DEFAULT NULL,
                           `id` BIGINT(20) NOT NULL,
                           `description` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           `image` VARCHAR(1000) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           `name` VARCHAR(500) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           `sku` VARCHAR(100) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `FK1mtsbur82frn64de7balymq9s` (`category_id`) USING BTREE,
                           CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB;

CREATE TABLE `user_role` (
                             `id` INT(11) NOT NULL AUTO_INCREMENT,
                             `role` VARCHAR(255) NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB COLLATE='latin1_swedish_ci';

CREATE TABLE `user` (
                        `birthday` DATE NULL DEFAULT NULL,
                        `id` BIGINT(20) NOT NULL,
                        `city` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `lastname` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `password` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `street_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `street_nr` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `surname` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `username` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `zip_code` VARCHAR(10) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                        `role_id` INT(11) NOT NULL,
                        PRIMARY KEY (`id`) USING BTREE,
                        INDEX `FK_user_role_id_idx` (`role_id`) USING BTREE,
                        CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) COLLATE='latin1_swedish_ci' ENGINE=InnoDB;

-- Insert roles into user_role table
INSERT INTO user_role (`role`) VALUES ('Admin');
INSERT INTO user_role (`role`) VALUES ('User');

-- Insert users with associated roles
INSERT INTO `user` (`id`, `username`, `password`, `surname`, `lastname`, `email`, `birthday`, `street_name`, `street_nr`, `zip_code`, `city`, `role_id`)
VALUES (1, 'Terminator', '1234', 'Arnold', 'Schwarzenegger', 'terminator@example.com', '1947-01-06', 'Hollywoodstreet', '1', '33004', 'Florida', 1);

INSERT INTO `user` (`id`, `username`, `password`, `surname`, `lastname`, `email`, `birthday`, `street_name`, `street_nr`, `zip_code`, `city`, `role_id`)
VALUES (2, 'Pockyred', '1234', 'Noah', 'Wernli', 'noahwernli@example.com', '2004-09-01', 'Aaraustrasse', '2', '5000', 'Aarau', 2);

-- Insert categories
INSERT INTO `category` (`active`, `id`, `name`) VALUES (1, 1, 'Medizin');
INSERT INTO `category` (`active`, `id`, `name`) VALUES (1, 2, 'Spielzeug');

-- Insert products
INSERT INTO `product` (`category_id`, `price`, `stock`, `id`, `description`, `image`, `name`, `sku`)
VALUES (1, 19.99, 100, 1, 'Testosteron ohne Nebenwirkungen', 'product_image.jpg', 'Testosteron', 'SKU123');

INSERT INTO `product` (`category_id`, `price`, `stock`, `id`, `description`, `image`, `name`, `sku`)
VALUES (2, 199.99, 100, 2, 'Für spezielle Abenteuer', 'product_image.jpg', 'Vibrator', 'SKU123');
