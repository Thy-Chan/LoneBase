/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     2015-5-26 16:29:20                           */
/*==============================================================*/
create database PmSystem
use PmSystem
if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����_ҵ��')
alter table ����
   drop constraint FK_����_����_ҵ��
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����2_��ҵ�շѱ�׼')
alter table ����
   drop constraint FK_����_����2_��ҵ�շѱ�׼
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ʹ��') and o.name = 'FK_ʹ��_ʹ��_ҵ��')
alter table ʹ��
   drop constraint FK_ʹ��_ʹ��_ҵ��
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ʹ��') and o.name = 'FK_ʹ��_ʹ��2_��ҵ��Դ')
alter table ʹ��
   drop constraint FK_ʹ��_ʹ��2_��ҵ��Դ
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Ѱ��') and o.name = 'FK_Ѱ��_Ѱ��_ҵ��')
alter table Ѱ��
   drop constraint FK_Ѱ��_Ѱ��_ҵ��
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Ѱ��') and o.name = 'FK_Ѱ��_Ѱ��2_������Ա')
alter table Ѱ��
   drop constraint FK_Ѱ��_Ѱ��2_������Ա
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Ͷ��') and o.name = 'FK_Ͷ��_Ͷ��_ҵ��')
alter table Ͷ��
   drop constraint FK_Ͷ��_Ͷ��_ҵ��
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Ͷ��') and o.name = 'FK_Ͷ��_Ͷ��2_�����Ա')
alter table Ͷ��
   drop constraint FK_Ͷ��_Ͷ��2_�����Ա
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����_�������˾')
alter table ����
   drop constraint FK_����_����_�������˾
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����2_ҵ��')
alter table ����
   drop constraint FK_����_����2_ҵ��
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('��ҵ������Ա') and o.name = 'FK_��ҵ������Ա_ʵʩ��װ_��ҵ��Դ')
alter table ��ҵ������Ա
   drop constraint FK_��ҵ������Ա_ʵʩ��װ_��ҵ��Դ
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('��ҵ������Ա') and o.name = 'FK_��ҵ������Ա_��Ӷ_�����Ա')
alter table ��ҵ������Ա
   drop constraint FK_��ҵ������Ա_��Ӷ_�����Ա
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('��ҵ��Դ') and o.name = 'FK_��ҵ��Դ_RELATIONS_�ֿ�')
alter table ��ҵ��Դ
   drop constraint FK_��ҵ��Դ_RELATIONS_�ֿ�
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('��ҵ��Դ') and o.name = 'FK_��ҵ��Դ_����_�����˵�')
alter table ��ҵ��Դ
   drop constraint FK_��ҵ��Դ_����_�����˵�
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('��ҵ��Դ') and o.name = 'FK_��ҵ��Դ_����_��Դ�г�')
alter table ��ҵ��Դ
   drop constraint FK_��ҵ��Դ_����_��Դ�г�
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('�����Ա') and o.name = 'FK_�����Ա_ѡ��_��Դ�г�')
alter table �����Ա
   drop constraint FK_�����Ա_ѡ��_��Դ�г�
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����_�����Ա')
alter table ����
   drop constraint FK_����_����_�����Ա
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('����') and o.name = 'FK_����_����2_��ҵ��Դ')
alter table ����
   drop constraint FK_����_����2_��ҵ��Դ
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ҵ��')
            and   type = 'U')
   drop table ҵ��
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('����')
            and   type = 'U')
   drop table ����
go

if exists (select 1
            from  sysobjects
           where  id = object_id('�ֿ�')
            and   type = 'U')
   drop table �ֿ�
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ʹ��')
            and   name  = 'ʹ��2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ʹ��.ʹ��2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ʹ��')
            and   name  = 'ʹ��_FK'
            and   indid > 0
            and   indid < 255)
   drop index ʹ��.ʹ��_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ʹ��')
            and   type = 'U')
   drop table ʹ��
go

if exists (select 1
            from  sysobjects
           where  id = object_id('������Ա')
            and   type = 'U')
   drop table ������Ա
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Ѱ��')
            and   name  = 'Ѱ��2_FK'
            and   indid > 0
            and   indid < 255)
   drop index Ѱ��.Ѱ��2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Ѱ��')
            and   name  = 'Ѱ��_FK'
            and   indid > 0
            and   indid < 255)
   drop index Ѱ��.Ѱ��_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Ѱ��')
            and   type = 'U')
   drop table Ѱ��
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Ͷ��')
            and   name  = 'Ͷ��2_FK'
            and   indid > 0
            and   indid < 255)
   drop index Ͷ��.Ͷ��2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Ͷ��')
            and   name  = 'Ͷ��_FK'
            and   indid > 0
            and   indid < 255)
   drop index Ͷ��.Ͷ��_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Ͷ��')
            and   type = 'U')
   drop table Ͷ��
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('����')
            and   type = 'U')
   drop table ����
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('��ҵ������Ա')
            and   name  = 'ʵʩ��װ_FK'
            and   indid > 0
            and   indid < 255)
   drop index ��ҵ������Ա.ʵʩ��װ_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('��ҵ������Ա')
            and   name  = '��Ӷ_FK'
            and   indid > 0
            and   indid < 255)
   drop index ��ҵ������Ա.��Ӷ_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('��ҵ������Ա')
            and   type = 'U')
   drop table ��ҵ������Ա
go

if exists (select 1
            from  sysobjects
           where  id = object_id('��ҵ�շѱ�׼')
            and   type = 'U')
   drop table ��ҵ�շѱ�׼
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('��ҵ��Դ')
            and   name  = '����_FK'
            and   indid > 0
            and   indid < 255)
   drop index ��ҵ��Դ.����_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('��ҵ��Դ')
            and   name  = '����_FK'
            and   indid > 0
            and   indid < 255)
   drop index ��ҵ��Դ.����_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('��ҵ��Դ')
            and   name  = 'Relationship_9_FK'
            and   indid > 0
            and   indid < 255)
   drop index ��ҵ��Դ.Relationship_9_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('��ҵ��Դ')
            and   type = 'U')
   drop table ��ҵ��Դ
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('�����Ա')
            and   name  = 'ѡ��_FK'
            and   indid > 0
            and   indid < 255)
   drop index �����Ա.ѡ��_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('�����Ա')
            and   type = 'U')
   drop table �����Ա
go

if exists (select 1
            from  sysobjects
           where  id = object_id('�����˵�')
            and   type = 'U')
   drop table �����˵�
go

if exists (select 1
            from  sysobjects
           where  id = object_id('�������˾')
            and   type = 'U')
   drop table �������˾
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('����')
            and   name  = '����_FK'
            and   indid > 0
            and   indid < 255)
   drop index ����.����_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('����')
            and   type = 'U')
   drop table ����
go

if exists (select 1
            from  sysobjects
           where  id = object_id('��Դ�г�')
            and   type = 'U')
   drop table ��Դ�г�
go

/*==============================================================*/
/* Table: ҵ��                                                    */
/*==============================================================*/
create table ҵ�� (
   o_id                 int                  not null,
   o_xm                 varchar(20)          null,
   o_nl                 int                  null,
   o_jtzz               varchar(100)         null,
   o_sfzhm              int                  null,
   o_rzsj               datetime             null,
   o_lxfs               int                  null,
   o_zhmj               int                  null,
   constraint PK_ҵ�� primary key nonclustered (o_id)
)
go

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ���� (
   o_id                 int                  not null,
   wy_id                int                  not null,
   constraint PK_���� primary key (o_id, wy_id)
)
go

/*==============================================================*/
/* Index: ����_FK                                                 */
/*==============================================================*/
create index ����_FK on ���� (
o_id ASC
)
go

/*==============================================================*/
/* Index: ����2_FK                                                */
/*==============================================================*/
create index ����2_FK on ���� (
wy_id ASC
)
go

/*==============================================================*/
/* Table: �ֿ�                                                    */
/*==============================================================*/
create table �ֿ� (
   k_name               varchar(16)          not null,
   k_leibie             varchar(20)          null,
   k_wuping             int                  null,
   k_shuliang           int                  null,
   constraint PK_�ֿ� primary key nonclustered (k_name)
)
go

/*==============================================================*/
/* Table: ʹ��                                                    */
/*==============================================================*/
create table ʹ�� (
   o_id                 int                  not null,
   zy_id                int                  not null,
   constraint PK_ʹ�� primary key (o_id, zy_id)
)
go

/*==============================================================*/
/* Index: ʹ��_FK                                                 */
/*==============================================================*/
create index ʹ��_FK on ʹ�� (
o_id ASC
)
go

/*==============================================================*/
/* Index: ʹ��2_FK                                                */
/*==============================================================*/
create index ʹ��2_FK on ʹ�� (
zy_id ASC
)
go

/*==============================================================*/
/* Table: ������Ա                                                  */
/*==============================================================*/
create table ������Ա (
   wl_id                int                  not null,
   wl_xm                varchar(20)          null,
   wl_xb                varchar(10)          null,
   wl_sfzhm             int                  null,
   wl_shiyou            char(10)             null,
   constraint PK_������Ա primary key nonclustered (wl_id)
)
go

/*==============================================================*/
/* Table: Ѱ��                                                    */
/*==============================================================*/
create table Ѱ�� (
   o_id                 int                  not null,
   wl_id                int                  not null,
   constraint PK_Ѱ�� primary key (o_id, wl_id)
)
go

/*==============================================================*/
/* Index: Ѱ��_FK                                                 */
/*==============================================================*/
create index Ѱ��_FK on Ѱ�� (
o_id ASC
)
go

/*==============================================================*/
/* Index: Ѱ��2_FK                                                */
/*==============================================================*/
create index Ѱ��2_FK on Ѱ�� (
wl_id ASC
)
go

/*==============================================================*/
/* Table: Ͷ��                                                    */
/*==============================================================*/
create table Ͷ�� (
   o_id                 int                  not null,
   w_id                 int                  not null,
   constraint PK_Ͷ�� primary key (o_id, w_id)
)
go

/*==============================================================*/
/* Index: Ͷ��_FK                                                 */
/*==============================================================*/
create index Ͷ��_FK on Ͷ�� (
o_id ASC
)
go

/*==============================================================*/
/* Index: Ͷ��2_FK                                                */
/*==============================================================*/
create index Ͷ��2_FK on Ͷ�� (
w_id ASC
)
go

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ���� (
   sh_id                int                  not null,
   o_id                 int                  not null,
   constraint PK_���� primary key (sh_id, o_id)
)
go

/*==============================================================*/
/* Index: ����_FK                                                 */
/*==============================================================*/
create index ����_FK on ���� (
sh_id ASC
)
go

/*==============================================================*/
/* Index: ����2_FK                                                */
/*==============================================================*/
create index ����2_FK on ���� (
o_id ASC
)
go

/*==============================================================*/
/* Table: ��ҵ������Ա                                                */
/*==============================================================*/
create table ��ҵ������Ա (
   gz_bianhao           int                  not null,
   zy_id                int                  null,
   w_id                 int                  null,
   gz_xx                varchar(20)          null,
   gz_nb                varchar(20)          null,
   gz_qk                varchar(20)          null,
   constraint PK_��ҵ������Ա primary key nonclustered (gz_bianhao)
)
go

/*==============================================================*/
/* Index: ��Ӷ_FK                                                 */
/*==============================================================*/
create index ��Ӷ_FK on ��ҵ������Ա (
w_id ASC
)
go

/*==============================================================*/
/* Index: ʵʩ��װ_FK                                               */
/*==============================================================*/
create index ʵʩ��װ_FK on ��ҵ������Ա (
zy_id ASC
)
go

/*==============================================================*/
/* Table: ��ҵ�շѱ�׼                                                */
/*==============================================================*/
create table ��ҵ�շѱ�׼ (
   wy_id                int                  not null,
   wy_zl                varchar(50)          null,
   wy_bzjg              int                  null,
   wy_time              datetime             null,
   constraint PK_��ҵ�շѱ�׼ primary key nonclustered (wy_id)
)
go

/*==============================================================*/
/* Table: ��ҵ��Դ                                                  */
/*==============================================================*/
create table ��ҵ��Դ (
   zy_id                int                  not null,
   z_id                 int                  null,
   s_nb                 int                  null,
   k_name               varchar(16)          null,
   zy_leibie            varchar(20)          null,
   zy_name              varchar(20)          null,
   zy_qingkuang         varchar(50)          null,
   zy_guisu             varchar(50)          null,
   constraint PK_��ҵ��Դ primary key nonclustered (zy_id)
)
go

/*==============================================================*/
/* Index: Relationship_9_FK                                     */
/*==============================================================*/
create index Relationship_9_FK on ��ҵ��Դ (
k_name ASC
)
go

/*==============================================================*/
/* Index: ����_FK                                                 */
/*==============================================================*/
create index ����_FK on ��ҵ��Դ (
s_nb ASC
)
go

/*==============================================================*/
/* Index: ����_FK                                                 */
/*==============================================================*/
create index ����_FK on ��ҵ��Դ (
z_id ASC
)
go

/*==============================================================*/
/* Table: �����Ա                                                  */
/*==============================================================*/
create table �����Ա (
   w_id                 int                  not null,
   s_nb                 int                  null,
   w_xm                 varchar(20)          null,
   w_nl                 int                  null,
   w_sg                 int                  null,
   w_jtzz               varchar(100)         null,
   w_jg                 varchar(40)          null,
   w_sfzhm              int                  null,
   w_lxfs               int                  null,
   w_time               datetime             null,
   constraint PK_�����Ա primary key nonclustered (w_id)
)
go

/*==============================================================*/
/* Index: ѡ��_FK                                                 */
/*==============================================================*/
create index ѡ��_FK on �����Ա (
s_nb ASC
)
go

/*==============================================================*/
/* Table: �����˵�                                                  */
/*==============================================================*/
create table �����˵� (
   z_id                 int                  not null,
   z_lei                varchar(20)          null,
   z_beizhu             varchar(50)          null,
   constraint PK_�����˵� primary key nonclustered (z_id)
)
go

/*==============================================================*/
/* Table: �������˾                                                */
/*==============================================================*/
create table �������˾ (
   sh_id                int                  not null,
   sh_gsmz              varchar(50)          null,
   sh_time              datetime             null,
   constraint PK_�������˾ primary key nonclustered (sh_id)
)
go

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ���� (
   w_id                 int                  not null,
   zy_id                int                  not null,
   constraint PK_���� primary key (w_id, zy_id)
)
go

/*==============================================================*/
/* Index: ����_FK                                                 */
/*==============================================================*/
create index ����_FK on ���� (
w_id ASC
)
go

/*==============================================================*/
/* Index: ����2_FK                                                */
/*==============================================================*/
create index ����2_FK on ���� (
zy_id ASC
)
go

/*==============================================================*/
/* Table: ��Դ�г�                                                  */
/*==============================================================*/
create table ��Դ�г� (
   s_nb                 int                  not null,
   s_name               varchar(20)          null,
   s_leibie             varchar(20)          null,
   constraint PK_��Դ�г� primary key nonclustered (s_nb)
)
go

alter table ����
   add constraint FK_����_����_ҵ�� foreign key (o_id)
      references ҵ�� (o_id)
go

alter table ����
   add constraint FK_����_����2_��ҵ�շѱ�׼ foreign key (wy_id)
      references ��ҵ�շѱ�׼ (wy_id)
go

alter table ʹ��
   add constraint FK_ʹ��_ʹ��_ҵ�� foreign key (o_id)
      references ҵ�� (o_id)
go

alter table ʹ��
   add constraint FK_ʹ��_ʹ��2_��ҵ��Դ foreign key (zy_id)
      references ��ҵ��Դ (zy_id)
go

alter table Ѱ��
   add constraint FK_Ѱ��_Ѱ��_ҵ�� foreign key (o_id)
      references ҵ�� (o_id)
go

alter table Ѱ��
   add constraint FK_Ѱ��_Ѱ��2_������Ա foreign key (wl_id)
      references ������Ա (wl_id)
go

alter table Ͷ��
   add constraint FK_Ͷ��_Ͷ��_ҵ�� foreign key (o_id)
      references ҵ�� (o_id)
go

alter table Ͷ��
   add constraint FK_Ͷ��_Ͷ��2_�����Ա foreign key (w_id)
      references �����Ա (w_id)
go

alter table ����
   add constraint FK_����_����_�������˾ foreign key (sh_id)
      references �������˾ (sh_id)
go

alter table ����
   add constraint FK_����_����2_ҵ�� foreign key (o_id)
      references ҵ�� (o_id)
go

alter table ��ҵ������Ա
   add constraint FK_��ҵ������Ա_ʵʩ��װ_��ҵ��Դ foreign key (zy_id)
      references ��ҵ��Դ (zy_id)
go

alter table ��ҵ������Ա
   add constraint FK_��ҵ������Ա_��Ӷ_�����Ա foreign key (w_id)
      references �����Ա (w_id)
go

alter table ��ҵ��Դ
   add constraint FK_��ҵ��Դ_RELATIONS_�ֿ� foreign key (k_name)
      references �ֿ� (k_name)
go

alter table ��ҵ��Դ
   add constraint FK_��ҵ��Դ_����_�����˵� foreign key (z_id)
      references �����˵� (z_id)
go

alter table ��ҵ��Դ
   add constraint FK_��ҵ��Դ_����_��Դ�г� foreign key (s_nb)
      references ��Դ�г� (s_nb)
go

alter table �����Ա
   add constraint FK_�����Ա_ѡ��_��Դ�г� foreign key (s_nb)
      references ��Դ�г� (s_nb)
go

alter table ����
   add constraint FK_����_����_�����Ա foreign key (w_id)
      references �����Ա (w_id)
go

alter table ����
   add constraint FK_����_����2_��ҵ��Դ foreign key (zy_id)
      references ��ҵ��Դ (zy_id)
go

