DROP TABLE IF EXISTS MASTER_ITEMS;

create table MASTER_ITEMS
(
  ID INTEGER IDENTITY ,
  ITEM_NAME varchar(30) not null,
  PRICE int not null,
  CREATION_DATE date not null,
  
  PRIMARY KEY(ID)
);


DROP TABLE IF EXISTS TX_ORDERS;

create table TX_ORDERS
(
  ID INTEGER IDENTITY ,
  ITEM_NAME varchar(30) not null,
  SOLD_DATE date not null,
  NUMBER_OF_ORDERS_TODAY INTEGER NOT NULL,
  
  PRIMARY KEY(ID)
);
