package ca.jent.funwithdddaggsimple.aggregates.customerportfolio;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("customerportfolio")
public record CustomerPortfolio(@Id Long id, Customer customer, Portfolio portfolio, Address address) {
}
