create table reservations (
  id_reservation bigint not null AUTO_INCREMENT,
  ch_id bigint not null,
  nbre_personne integer not null,
  date date not null,
  primary key (id_reservation),
  foreign key (ch_id) references chambres(id_chambre)

) engine=InnoDB;

ALTER TABLE reservations ADD us_id bigint not null;

ALTER TABLE reservations ADD FOREIGN KEY (us_id) REFERENCES users(id_user);