create table chambres (
    id_chambre bigint not null,
    num_chambre int not null,
    nbre_place int not null,
    etat varchar(255) not null,
    types varchar(255) not null,
    primary key (id_chambre)
) engine=InnoDB;