create TABLE customerportfolio (
    id          bigserial primary key
);

create TABLE customer (
    id          bigserial primary key ,
    fn          VARCHAR(100),
    ln          VARCHAR(100),
    dob         DATE,
    customerportfolio bigint,
    FOREIGN KEY (customerportfolio) references customerportfolio(id)
);

create TABLE portfolio (
    id          bigserial primary key ,
    name        VARCHAR(100),
    customerportfolio    bigint,
    FOREIGN KEY (customerportfolio) references customerportfolio(id)
);

create TABLE assets (
      asset_type    VARCHAR,
      money         NUMERIC,
      portfolio     bigint,
      FOREIGN KEY (portfolio) references portfolio(id)
);

create TABLE address (
    number          int,
    street          VARCHAR(100),
    province        VARCHAR(100),
    country         VARCHAR(100),
    customerportfolio        bigint,
    FOREIGN KEY (customerportfolio) references customerportfolio(id)
);