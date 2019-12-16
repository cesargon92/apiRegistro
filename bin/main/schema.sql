create table users (user_id UUID not null,
                    name varchar(60) not null, 
                    email varchar(60) not null, 
                    password varchar(40) not null,
                    created date not null,
                    updated date,
                    last_login date,
                    token varchar(255),
                    is_active bit,
                    primary key(user_id));

create table user_phones (id BIGINT not null,
                          user_id UUID not null,
                          phone_number VARCHAR(10) not null,
                          city_code varchar(3) not null,
                          country_code varchar(3) not null,
                          primary key(id));