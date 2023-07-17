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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
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

        Stream<Asset> assets = Stream.concat(savedCustPortfolio.portfolio().assets().stream(), Set.of(new Asset(AssetType.REAL_ESTATE, Money.of(120000.21))).stream());
        CustomerPortfolio newCustPort = new CustomerPortfolio(savedCustPortfolio.id(), savedCustPortfolio.customer(), new Portfolio(savedCustPortfolio.portfolio().id(), savedCustPortfolio.portfolio().name(), assets.collect(toSet())), savedCustPortfolio.address());


        CustomerPortfolio save2 = customerPortfolioRepository.save(newCustPort);

        assertEquals(3, save2.portfolio().assets().size());

        assertEquals(savedCustPortfolio.id(), save2.id());
        assertEquals(savedCustPortfolio.portfolio().id(), save2.portfolio().id());
        assertEquals(savedCustPortfolio.address().street(), save2.address().street());

        save2.portfolio().assets().forEach(System.out::println);
    }
}