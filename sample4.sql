--------------------------------------------------------
--  File created - Wednesday-May-31-2017   
--------------------------------------------------------
REM INSERTING into test.PS_CUST_ADDR_SEQ
SET DEFINE OFF;
Insert into test.PS_CUST_ADDR_SEQ (SETID,CUST_ID,ADDRESS_SEQ_NUM,DESCR,BILL_TO_ADDR,SHIP_TO_ADDR,SOLD_TO_ADDR,CRSPD_TO_ADDR,BROKER_ADDR,INDIRECT_ADDR,RFID_ENABLED,LAST_MAINT_OPRID,DATE_LAST_MAINT) values ('SHARE','AUS01',1,'Main','Y','Y','Y','Y','N','N','N','BNDF',to_date('15-FEB-00','DD-MON-RR'));
