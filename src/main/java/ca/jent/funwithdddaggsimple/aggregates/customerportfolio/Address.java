package ca.jent.funwithdddaggsimple.aggregates.customerportfolio;

import org.springframework.data.relational.core.mapping.Table;

@Table("address")
public record Address(int number, String street, String province, String country) {
}
