create table chambres (
    id_chambre bigint not null,
    num_chambre INTEGER not null,
    nbre_place  INTEGER not null,
    etat varchar(255) not null,
    types varchar(255) not null,
    primary key (id_chambre)
)engine=InnoDB;