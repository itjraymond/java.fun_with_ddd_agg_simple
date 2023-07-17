package ca.jent.funwithdddaggsimple.aggregates.customerportfolio;

import ca.jent.funwithdddaggsimple.types.AssetType;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("assets")
public record Asset(AssetType assetType, BigDecimal money) {
}
