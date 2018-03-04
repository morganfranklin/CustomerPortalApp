**** SECTION A. ADF application installation instructions.

1. Install JDeveloper 12.2.1 and Oracle XE release 12 on your machine

2. Run a sample Web ADF application (any) to make sure the Weblogic is installed.  During the first weblogic installation, prior to its build, write down the exact location where the weblogic is installed.  You will need it in Step 4e.

3. Place the content of CovCustomerPortal010_170531a.zip in Java Developer work folder

4. There are two properties file in the main CovCustomerPortal010 application folder: cybs.properties and xpe_aws.properties.  These hold references to other directories, pointers to files and credentials to the database, credentials to credit card provided test instance.

4a. In the application, project Model, file CyberSourceAdapter.java, change propertyFileCybs attribute value to point to the exact location of cybs.properties file on your machine.

4b. In the application, project Model, file GenericDataHandler.java, change propertyFileCfg attribute value to point to the exact location of xpe_aws.properties file on your machine.

4c. In the cybs.properties file, change the property value of keysDirectory (now set to C:/JDeveloper/mywork/CovCustomerPortal010/keys) to where the [keys] subfolder resides on your machine.  The keys subfolder is in the main CovCustomer010 portal folder and contains one encryption key file called morganfranklin.p12 used to communicate with CyberSource.

other properties values should remain intact

4d. In the xpe_aws.properties file, change ps_config_user and ps_config_passwd to your local machine's Orcle XE database user credentials.  Please note that I commented out password decryption in the GenericDataHandler.java file so that you can enter your password in plain text.

ps_config_url property in this file should be changed to a JDBC URL pointing to your local database.

4e. Make sure that weblogic instance, after initial build and testing a sample ADF application is shut down.

Locate your WebLogic installation (from Step 2), its Oracle Home folder and then oracle_common/jdk/jre/lib/security folder.  For me, it is 

C:\Oracle\Middleware\Oracle_Home3\oracle_common\jdk\jre\lib\security

Replace local_policy.jar and US_export_policy.jar with jar files in the CovCustomerPortal010 project file, subfolder lib4weblogic (For me C:\JDeveloper\mywork\CovCustomerPortal010\lib4weblogic).

5. In JDeveloper, after opening the Gvca010.jws application, change database connection properties to point to your local machine (should be the same password / user name / JDBC as in step 4d.  Test database connection.

6. In the application, project Model, you will find an offline database definition ORCL12C.  It has three tables definitions. Generate them to your local Oracle instance from JDeveloper (right click on Offline Database Sources, Generate to database connection gvccp).

7. Execute sample_data1.sql (main project folder) against your database - this should insert sample data into your five tables, necessary for the demo to work.

8. Go to Gvca010 application properties in Java Developer.  Go to Libraries and Classpath. Add the following jar's, one by one from the [lib] subfolder in your main project work location (for me: C:\JDeveloper\mywork\CovCustomerPortal010\lib).

commons-lang3-3.5.jar
commons-logging-1.2.jar
cybersource-sdk-java-6.2.4.jar
wwss4j-1.6.19.jar
xmlsec-1.5.8.jar

9. Clean and rebuild the application - should compile successfully.

10. Run default page flow (project ViewController, Web Content, WEB-INF, adfc-config.xml).  This should display the main page.

**** SECTION B. CyberSource test site

In order to test the communication with CyberSource service (which credentials are provided for the application in the cybs.properties file), you may want to have access to their portal, to seach for customers and their transactions, independent from the ADF application.  Credentials as follows:

URL
https://ebctest.cybersource.com/ebctest/login/Login.do

Account / Merchant id: morganfranklin
User name: tomasz_zarzycki
Password: MorganFranklin123


After logging in, go to Payment Tokenization, then Search, you will see a list of test customers.  Profile Id (token) is stored PS_XPE_CUST_CYBER.PS_CUSTOM_SUBSCRIPTION_ID field, Merchant reference number (our customer id) is in PS_XPE_CUST_CYBER.CUST_ID

When you click on Profile id, then Payment History tab, you will see transactions posted by our ADF application.

**** SECTION C. Brief overview of the prototype application structure.

1. Project Model

- Application Sources

-- com.cybersource.schemas are CyberSource libraries and SDK, used to communicate with the CyberSource test site, accessing webservices provided by CyberSource

-- model

--- CustomerView is the main customer VO (SQL - based), used to pick customer which balances and payment profiles you'd like to see, it is linked via Customer2ProfileViewLink to PaymentProfileViewObject (populated and controlled programmatically through underlying implementation of *ViewObjectImpl.java and *ObjectRowImpl.java).

---- PaymentProfileViewObjectImpl.java, overriden method  executeQueryForCollection, creates an instance of CyberSourceAdapter.java class, and calls its populateCreditCardProfilesArray method to call CyberSource webservices, to get a list of selected customer's profiles and fill in an array list of POJO class PaymentProfileEntry.java with customers profiles;  other overriden methods in PaymentProfileViewObjectImpl make sure that the corresponding ViewObject lists all payment profiles

--- GenericDataHandler.java is a common library between this application and our previous application that has common meta-data configuration methods and billing calculation - for now, it is used by CyberSourceAdapter.java to retrieve token ids for a selected customer id from PS_XPE_CUST_CYBER table before calling CyberSource services

--- OpenItems VO displays open items for a customer, please note that right now I have hardcoded (within underlying SQL) customer id to AUS01.  It needs to be opened up, and linked to CustomerVIew VO so that OpenItems displays only items for a selected customer.  I prefer any generally supported and clean methods, the simpler, the better; preferring as code-less approach as possible (i.e. standar use of links etc).

--- LovCountries, LovMonths, LovYear, LookupHelper are temporary VOs used to provide LOVs to new credit card entry, they will need to be cleaned up at some point

2. Project ViewController

-- WebContent

--- GvaaHome1.jsf is customer portal main page, with navigation bars on the left and top hand side; top navigation bar is dormant now; left hand side is linked (via view.MainDynamicRegionBean.java) to the main page fragment in the middle that displays page fragments, as user clicks on hyperlinks on the left hand side

--- most of the page flows under Web Content, WEB-INF are simply pointing to a page fragment and are used by view.MainDynamicRegionBean.java for navigation

--- ViewController>WebContent>WEB-INF>paymentProfiles.xml is the main page flow developed for the main flow in the customer portal -> finding a customer, then either

(a) displaying all payment profiles for the customer or adding new payment profile, then selecting open items to be credited and crediting credit card for the client (from default paymentsProfileNew to paymentProfileNew and deeper)

or 

(b) displaying all open items and payment profiles on the same page, allowing to pay whatever open items with selected payment profile (from default paymentsProfileNew to openInvoicesWithProfileView and back)

--- NewPaymentProfileBean.java is used by WebContent>WEB-INF>paymentProfiles.xml page flow to deal with new credit card addition and transferring page flow variables between page fragments in paymentProfiles.xml

**** SECTION D - IMMEDIATE ACTION ITEMS AFTER INSTALLING THE APP AND FAMILIARIZING WITH THE CONTENT

1. For new credit card addition, please make sure that all properties on the PaymentProfiles flow, view newProfileEntryView (pointing to newProfileEntry.jsff) are transferred from the entry page to CyberSource WebService.  I might have hardcoded some of them for demo purposes, given limited time to prepare the prototype.

2. For existing open item payment page, PaymentProfiles flow, view invoicesListView pointing to invoicesList.jsff please develop the following extensions and modifications

---- upon entry of specific invoices amounts to Payment Amount column and upon pressing [Update] button, sum of all invoices amounts from Payment Amount column should be populated in TotalPaymentAmount field

---- value of TotalPaymentAmount field should be transferred to CyberSourceAdapter upon hitting [Charge] button, right now it is hardcoded

---- pressing [Apply Against Oldest] button should spread amount from Total Payment Amount field to Payment Amount column, starting from the oldest invoice (as per by Due Date column), until the total amount in Total Payment field is exhausted.

---- add Pay All button that will populate Payment Amount with Open Amount (USD) and total with sum of invoices

---- add Pay this Invoice button to each row of open items, to call the CyberSource adapter with that invoice amount

