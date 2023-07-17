package ca.jent.funwithdddaggsimple.aggregates.customerportfolio;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("customer")
public record Customer(@Id Long id, String fn, String ln, LocalDate dob) {
}
