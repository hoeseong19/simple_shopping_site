package me.hskwon.simple_shopping_site.controllers;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/backdoor")
public class BackdoorController {
    private final JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/setup-database")
    @Transactional
    void setupDatabase() {
        deleteProductOptionItems();
        deleteProductOptions();
        deleteImages();
        deleteProducts();
        deleteCategories();

        setupCategories();
        setupProducts();
        setupImages();
        setupProductOptions();
        setupProductOptionItems();
    }

    private void deleteProductOptionItems() {
        jdbcTemplate.update("DELETE FROM product_option_items");
    }

    private void deleteProductOptions() {
        jdbcTemplate.update("DELETE FROM product_options");
    }

    private void deleteImages() {
        jdbcTemplate.update("DELETE FROM images");
    }

    private void deleteProducts() {
        jdbcTemplate.update("DELETE FROM products");
    }

    private void deleteCategories() {
        jdbcTemplate.update("DELETE FROM categories");
    }

    private void setupCategories() {
        List<HashMap<String, Object>> categories = List.of(
                new HashMap<>() {{
                    put("id", "0BV000CAT0001");
                    put("name", "top");
                }},
                new HashMap<>() {{
                    put("id", "0BV000CAT0002");
                    put("name", "outer");
                }},
                new HashMap<>() {{
                    put("id", "0BV000CAT0003");
                    put("name", "bottom");
                }},
                new HashMap<>() {{
                    put("id", "0BV000CAT0004");
                    put("name", "acc");
                }}
        );

        for (HashMap<String, Object> category : categories) {
            jdbcTemplate.update("""
                        INSERT INTO categories (id, name)
                        VALUES (?, ?)
                    """, category.get("id"), category.get("name")
            );
        }
    }

    private void setupProducts() {
        List<HashMap<String, Object>> products = List.of(
                new HashMap<>() {{
                    put("id", "0BV000PRO0001");
                    put("category_id", "0BV000CAT0001");
                    put("name", "CBCL 하트자수맨투맨");
                    put("price", 128000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0002");
                    put("category_id", "0BV000CAT0001");
                    put("name", "CBCL 사틴셔츠");
                    put("price", 118000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0003");
                    put("category_id", "0BV000CAT0001");
                    put("name", "CBCL 레이어드 탑");
                    put("price", 89000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0004");
                    put("category_id", "0BV000CAT0001");
                    put("name", "CBCL 배색 후드");
                    put("price", 89000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0005");
                    put("category_id", "0BV000CAT0002");
                    put("name", "박시롱코트");
                    put("price", 298000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0006");
                    put("category_id", "0BV000CAT0002");
                    put("name", "CBCL 레귤러핏 야구점퍼");
                    put("price", 397000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0007");
                    put("category_id", "0BV000CAT0002");
                    put("name", "CBCL 핀턱자수후드");
                    put("price", 158000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0008");
                    put("category_id", "0BV000CAT0003");
                    put("name", "밴딩스커트");
                    put("price", 966000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0009");
                    put("category_id", "0BV000CAT0003");
                    put("name", "CBCL 하트자수셋업조거");
                    put("price", 138000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0010");
                    put("category_id", "0BV000CAT0004");
                    put("name", "CBCL EARRING Silver");
                    put("price", 62000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0011");
                    put("category_id", "0BV000CAT0004");
                    put("name", "CBCL EARRING Green");
                    put("price", 82000L);
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0012");
                    put("category_id", "0BV000CAT0004");
                    put("name", "CBCL EARRING Purple");
                    put("price", 72000L);
                }}
        );

        for (HashMap<String, Object> product : products) {
            jdbcTemplate.update("""
                                INSERT INTO products (id, category_id, name, price)
                                VALUES (?, ?, ?, ?)
                            """,
                    product.get("id"),
                    product.get("category_id"),
                    product.get("name"),
                    product.get("price")
            );
        }
    }

    private void setupImages() {
        List<HashMap<String, String>> images = List.of(
                new HashMap<>() {{
                    put("id", "0BV000PRO0001");
                    put("product_id", "0BV000PRO0001");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/01.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0002");
                    put("product_id", "0BV000PRO0002");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/02.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0003");
                    put("product_id", "0BV000PRO0003");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/03.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0004");
                    put("product_id", "0BV000PRO0004");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/04.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0005");
                    put("product_id", "0BV000PRO0005");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/05.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0006");
                    put("product_id", "0BV000PRO0006");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/06.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0007");
                    put("product_id", "0BV000PRO0007");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/07.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0008");
                    put("product_id", "0BV000PRO0008");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/08.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0009");
                    put("product_id", "0BV000PRO0009");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/09.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0010");
                    put("product_id", "0BV000PRO0010");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/10.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0011");
                    put("product_id", "0BV000PRO0011");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/11.jpg");
                }},
                new HashMap<>() {{
                    put("id", "0BV000PRO0012");
                    put("product_id", "0BV000PRO0012");
                    put("url", "https://ahastudio.github.io/my-image-assets/images/cbcl-products/12.jpg");
                }}
        );

        for (HashMap<String, String> image : images) {
            jdbcTemplate.update("""
                            INSERT INTO images (id, product_id, url)
                            VALUES (?, ?, ?)
                            """,
                    image.get("id"),
                    image.get("product_id"),
                    image.get("url")
            );
        }
    }

    private void setupProductOptions() {
        List<HashMap<String, String>> productOptions = List.of(
                new HashMap<>() {{
                    put("id", "0BV000OPT0001");
                    put("product_id", "0BV000PRO0001");
                    put("name", "컬러");
                }},
                new HashMap<>() {{
                    put("id", "0BV000OPT0002");
                    put("product_id", "0BV000PRO0001");
                    put("name", "사이즈");
                }}
        );

        for (HashMap<String, String> option : productOptions) {
            jdbcTemplate.update("""
                            INSERT INTO product_options (id, product_id, name)
                            VALUES (?, ?, ?)
                            """,
                    option.get("id"),
                    option.get("product_id"),
                    option.get("name")
            );
        }
    }

    private void setupProductOptionItems() {
        List<HashMap<String, String>> productOptionItems = List.of(
                new HashMap<>() {{
                    put("id", "0BV000ITEM001");
                    put("product_option_id", "0BV000OPT0001");
                    put("name", "black");
                }},
                new HashMap<>() {{
                    put("id", "0BV000ITEM002");
                    put("product_option_id", "0BV000OPT0001");
                    put("name", "grey");
                }},
                new HashMap<>() {{
                    put("id", "0BV000ITEM003");
                    put("product_option_id", "0BV000OPT0001");
                    put("name", "blue");
                }},
                new HashMap<>() {{
                    put("id", "0BV000ITEM004");
                    put("product_option_id", "0BV000OPT0001");
                    put("name", "brown");
                }},
                new HashMap<>() {{
                    put("id", "0BV000ITEM005");
                    put("product_option_id", "0BV000OPT0002");
                    put("name", "ONE");
                }}
        );

        for (HashMap<String, String> item : productOptionItems) {
            jdbcTemplate.update("""
                            INSERT INTO product_option_items (id, product_option_id, name)
                            VALUES (?, ?, ?)
                            """,
                    item.get("id"),
                    item.get("product_option_id"),
                    item.get("name")
            );
        }
    }
}
