package ca.jent.funwithdddaggsimple.repository.customerportfolio;

import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.Address;
import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.Asset;
import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.Customer;
import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.CustomerPortfolio;
import ca.jent.funwithdddaggsimple.aggregates.customerportfolio.Portfolio;
import ca.jent.funwithdddaggsimple.types.AssetType;
import ca.jent.funwithdddaggsimple.types.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CustomerPortfolioRepositoryTest {

    @Autowired
    CustomerPortfolioRepository customerPortfolioRepository;

    @Test
    void test() {
        Address a1 = new Address(10, "Roger", "AB", "Canada");
        Asset stock = new Asset(AssetType.STOCK, Money.of(125.55));
        Asset bond = new Asset(AssetType.BONDS, Money.of(58.98));
        Portfolio p1 = new Portfolio(null, "P1", Set.of(stock, bond));
        Customer jack = new Customer(null, "Jack", "Lafontaine", LocalDate.of(1999, Month.DECEMBER, 25));
        CustomerPortfolio jackPortfolio = new CustomerPortfolio(null, jack, p1, a1);

        CustomerPortfolio savedCustPortfolio = customerPortfolioRepository.save(jackPortfolio);

        assertNotNull(savedCustPortfolio.id());
    }
}