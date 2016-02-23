create table STUDENT2
(
  STID      VARCHAR2(25),
  STNAME    VARCHAR2(10),
  STSEX     VARCHAR2(10),
  STAGE     VARCHAR2(10),
  STTEL     VARCHAR2(20),
  STDEPT    VARCHAR2(20),
  STADDRESS VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

-- Create sequence 
create sequence STU2_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 25
increment by 1
nocache;

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('24', '����', '��', '23', '15866742101', 'ҽѧϵ', 'ɽ��Ϋ����');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('15', '������', '��', '19', '13653548652', '��ѧϵ', 'ɽ��������');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('17', '����', 'Ů', '20', '16535476665', 'ũѧϵ', 'ɽ��Ϋ����');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('18', 'С��', 'Ů', '21', '15695845635', '����ϵ', 'ɽ��������');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('19', '����', 'Ů', '22', '12355668542', '����ϵ', 'ɽ��������');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('20', '���', 'Ů', '18', '16546542363', '��ʷϵ', 'ɽ���ൺ��');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('21', '����', '��', '18', '14365976365', '����ϵ', 'ɽ��������');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS)
values ('22', '�����', '��', '20', '15899635412', '�����ϵ', 'ɽ��������');

