create table tenant
(
    tenant_type      varchar(31)  not null,
    tenant_id        bigint       not null identity
        primary key,
    name             varchar(255) not null
        constraint tenant_name_unique
            unique,
    parent_tenant_id bigint null
        constraint fk_parent_tenant
            references tenant
)
go

create table customer
(
    customer_id bigint not null identity
        primary key,
    name        varchar(255),
    tenant_id   bigint not null
        constraint fk_customer_tenant
            references tenant
)
go

create table tenant_user
(
    user_id   bigint not null identity
        primary key,
    login     varchar(255),
    name      varchar(255),
    tenant_id bigint
        constraint fk_user_tenant
            references tenant
)
go

insert into tenant (tenant_type, name)
values ('SYSTEM', 'ROOT');

declare @root_tenant_id bigint;
set @root_tenant_id = @@identity;

insert into tenant_user (login, name, tenant_id)
values ('info@transactrule.com', 'Admin', @root_tenant_id);

insert into tenant (tenant_type, name, parent_tenant_id)
values ('SYSTEM', 'Subscriptions', @root_tenant_id);
