# Java fun with ddd and Aggregate Root (simple) with JDBC

Simple demo showing how to save an Aggregate Root (simple one) to Postgres without the complexity of JPA.

# Aggregate Root

We will choose a CustomerPortfolio Aggregate Root which will be composed of a Customer entity, a
Portfolio entity, composed of Asset Value Object, and an Address Value Object.  

# Postgres

Postgres will have three tables:

1. Customer
2. Portfolio - [Asset]
3. Address

# Objective

For this POC, we want to keep it as simple as possible.