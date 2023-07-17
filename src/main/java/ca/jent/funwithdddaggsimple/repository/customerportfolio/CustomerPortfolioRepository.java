package ca.jent.funwithdddaggsimple.repository.customerportfolio;

import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.CustomerPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPortfolioRepository extends CrudRepository<CustomerPortfolio, Long> {
}
