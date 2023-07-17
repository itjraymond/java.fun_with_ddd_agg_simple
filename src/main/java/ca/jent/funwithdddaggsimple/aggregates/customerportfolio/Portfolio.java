package ca.jent.funwithdddaggsimple.aggregates.customerportfolio;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("portfolio")
public record Portfolio(@Id Long id, String name, Set<Asset> assets) {
}
