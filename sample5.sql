--------------------------------------------------------
--  File created - Wednesday-May-31-2017   
--------------------------------------------------------
REM INSERTING into test.PS_CUST_ADDRESS
SET DEFINE OFF;
Insert into test.PS_CUST_ADDRESS (SETID,CUST_ID,ADDRESS_SEQ_NUM,EFFDT,EFF_STATUS,ALT_NAME1,ALT_NAME2,LANGUAGE_CD,TAX_CD,COUNTRY,ADDRESS1,ADDRESS2,ADDRESS3,ADDRESS4,CITY,NUM1,NUM2,HOUSE_TYPE,ADDR_FIELD1,ADDR_FIELD2,ADDR_FIELD3,COUNTY,STATE,POSTAL,GEO_CODE,IN_CITY_LIMIT,COUNTRY_CODE,PHONE,EXTENSION,FAX,PHYSICAL_NATURE,VAT_SVC_PERFRM_FLG,LAST_EXP_CHK_DTTM,LAST_MAINT_OPRID,DATE_LAST_MAINT,LASTUPDDTTM,URL_LONG) values ('SHARE','AUS01',1,to_date('01-JAN-00','DD-MON-RR'),'A',' ',' ','ENG',' ','AUS','240 Northumberland Drive',' ',' ',' ','Sydney',' ',' ',' ',' ',' ',' ',' ','NSW','2200',' ',' ','011','12722123',' ','01112722122',' ','1',null,'SAMPLE',to_date('24-JUL-09','DD-MON-RR'),to_timestamp('24-JUL-09 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),' ');
