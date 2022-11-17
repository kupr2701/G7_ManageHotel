create table reservations (
  id_reservation bigint not null,
  num_chambre integer not null,
  nbre_personne integer not null,
  date date not null,
  primary key (id_reservation)
) engine=InnoDB;