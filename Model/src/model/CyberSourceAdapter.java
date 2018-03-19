package model;

import com.cybersource.ws.client.Client;
import com.cybersource.ws.client.ClientException;
import com.cybersource.ws.client.FaultException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;


public class CyberSourceAdapter {

    public CyberSourceAdapter() {
        super();
    }

    //Constants implementation specific
  // private static final String propertyFileCybs = "/tmp/GvcaProperties/cybs.properties";
  // local
  //private static final String propertyFileCybs = "C:\\JDeveloper\\mywork\\CovCustomerPortal010_2132018\\CovCustomerPortal010\\cybs.properties";
  // omcs
  private static final String propertyFileCybs = "/tcva3t/shared/config/domains/ohsdomain/servers/AdminServer/logs/cyber/cybs.properties";
  //private static final String propertyFileCybs = "/autofs/ood_implementation/lib4wls/xpe_batch/cybs.properties";

    private static void displayMap(String header, Map map) {
        /**
                     * Displays the content of the Map object.
                     *
                     * @param header        Header text.
                     * @param map           Map object to display.
                     */



        System.out.println(header);

        StringBuffer dest = new StringBuffer();

        if (map != null && !map.isEmpty()) {
            Iterator iter = map.keySet().iterator();
            String key, val;
            while (iter.hasNext()) {
                key = (String) iter.next();
                val = (String) map.get(key);
                dest.append(key + "=" + val + "\n");
            }
        }

        System.out.println(dest.toString());
    }

    public void populateCreditCardProfilesArray(ArrayList<PaymentProfileEntry> profileList, String selectedCustomer) {
        // Prashant's code here - construct objects from com.cybersource.schemas package to run retrieveCustomer
        // webservice you have tested in SoapUI and populate profileList

        String profileAccount;
        String profilePayMethod;
        String merchantRefCode;
        String subscriptionId;
        String profileExpiryDate;
        String profileName;
        String reasonCode;
        String email;
        profileList.clear();
        GenericDataHandler dataAdapter = new GenericDataHandler();

        System.out.println("selectedCustomer : " + selectedCustomer);


        //    Map<String, String> resultSet = dataAdapter.getCybsAllProfiles(dataAdapter.connectDb());
        Map<String, String> resultSet = dataAdapter.getCybCustomerProfiles(dataAdapter.connectDb(), selectedCustomer);


        //   displayMap( "Customer SQL :", resultSet );

        System.out.println("resultSet size " + resultSet.size());

        for (Map.Entry<String, String> entry : resultSet.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            merchantRefCode = entry.getValue();
            subscriptionId = entry.getKey();
            System.out.println("merchantRefCode : " + merchantRefCode);
            System.out.println("subscriptionId : " + subscriptionId);
            // merchantRefCode = "COV-003";

            // Example           subscriptionIDV= "4946131492786437104010";
            //             merchantRefCodeV = "COV-001";
            ///*
            //get profile details
            Map<String, String> mapProfile = retrieveProfile(subscriptionId, merchantRefCode);

            //get the reason code for success = 100
            reasonCode = mapProfile.get("paySubscriptionRetrieveReply_reasonCode").toString();

            //check the return code for success
            if (reasonCode.equals("100")) {
                profileAccount = mapProfile.get("paySubscriptionRetrieveReply_cardAccountNumber").toString();
                System.out.println("profileAcctount : " + profileAccount);
                profilePayMethod = mapProfile.get("paySubscriptionRetrieveReply_paymentMethod").toString();
                System.out.println("profilePayMethod " + profilePayMethod);
                profileExpiryDate =
                    mapProfile.get("paySubscriptionRetrieveReply_cardExpirationMonth").toString() + "/" +
                    mapProfile.get("paySubscriptionRetrieveReply_cardExpirationYear").toString();
                System.out.println("profileExpiryDate " + profileExpiryDate);
                profileName =
                    mapProfile.get("paySubscriptionRetrieveReply_firstName").toString() + " " +
                    mapProfile.get("paySubscriptionRetrieveReply_lastName").toString();
                email = mapProfile.get("paySubscriptionRetrieveReply_email");
                System.out.println("profileName " + profileName);
                String profileDetail = subscriptionId;
                profileList.add(new PaymentProfileEntry(profileDetail, merchantRefCode, profileAccount,
                                                        profilePayMethod, profileExpiryDate, profileName, email));
            }
        }
    }

    public Map<String, String> retrieveProfile(String subscriptionIDV, String merchantRefCodeV) {
        /*
         * Input
         * subscriptionIDV
         * merchantRefCodeV
         *
        Output : Customer details in a map
        *
         */



        String reasonCode;
        String subscriptionId;

        Properties props = new Properties();

        try {

            File file = new File(propertyFileCybs);
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();

            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                //debug info                 System.out.println("Key : " + key + ", Value : " + value);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        HashMap request = new HashMap();

        // Add required fields
        request.put("merchantReferenceCode", merchantRefCodeV);

        request.put("recurringSubscriptionInfo_subscriptionID", subscriptionIDV);
        request.put("paySubscriptionRetrieveService_run", "true");

        displayMap("PROFILE REQUEST:", request);

        // Add optional fields here according to your business needs.
        // For information about processing the reply,
        // see Using the Decision and Reason Code Fields.
        try {
            Map<String, String> replyMap = Client.runTransaction(request, props);

            displayMap("REPLY:", replyMap);
            reasonCode = replyMap.get("paySubscriptionRetrieveReply_reasonCode").toString();
            return replyMap;

        } //try

        catch (ClientException e) {
            System.out.println("Client exception ");
            System.out.println(e.getMessage());
        } catch (FaultException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String createProfile(Map<String, String> customerDataCybs) {

        /*
 * Input Map<String, String>
//Structure of customerDataCybs
//  billTo_firstName,  billTo_lastName, billTo_street1, billTo_city, billTo_state, billTo_postalCode, billTo_country,
// billTo_email,purchaseTotals_currency,card_accountNumber, card_expirationMonth, card_expirationYear, card_cardType
//   merchantID, merchantReferenceCode

Output : subscriptio_Id
*
 */
        String reasonCode = "";
        String subscriptionId;


        //read property file
        Properties props = new Properties();
        try {

            File file = new File(propertyFileCybs);
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();

            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                //debgug info                 System.out.println("Key : " + key + ", Value : " + value);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        HashMap request = new HashMap();

        // Add required fields
        request.put("billTo_firstName", customerDataCybs.get("billTo_firstName").toString());
        request.put("billTo_lastName", customerDataCybs.get("billTo_lastName").toString());
        request.put("billTo_street1", customerDataCybs.get("billTo_street1").toString());
        request.put("billTo_city", customerDataCybs.get("billTo_city").toString());
        request.put("billTo_state", customerDataCybs.get("billTo_state").toString());
        request.put("billTo_postalCode", customerDataCybs.get("billTo_postalCode").toString());
        request.put("billTo_country", customerDataCybs.get("billTo_country").toString());
        request.put("billTo_email", customerDataCybs.get("billTo_email").toString());
        request.put("purchaseTotals_currency", customerDataCybs.get("purchaseTotals_currency").toString());
        request.put("card_accountNumber", customerDataCybs.get("card_accountNumber").toString());
        request.put("card_expirationMonth", customerDataCybs.get("card_expirationMonth").toString());
        request.put("card_expirationYear", customerDataCybs.get("card_expirationYear").toString());
        request.put("card_cardType", customerDataCybs.get("card_cardType").toString());
        request.put("merchantID", customerDataCybs.get("merchantID").toString());
        request.put("merchantReferenceCode", customerDataCybs.get("merchantReferenceCode").toString());
        request.put("recurringSubscriptionInfo_frequency", "on-demand");
        request.put("paySubscriptionCreateService_run", "true");

        displayMap("PROFILE REQUEST:", request);

        // Add optional fields here according to your business needs.
        // For information about processing the reply,
        // see Using the Decision and Reason Code Fields.
        try {
            Map<String, String> replyMap = Client.runTransaction(request, props);

            displayMap("REPLY:", replyMap);
            reasonCode = replyMap.get("ccAuthReply_reasonCode").toString();

            if (reasonCode.equals("100")) {
                subscriptionId = replyMap.get("paySubscriptionCreateReply_subscriptionID").toString();
                return (subscriptionId);
            } else {
                return null;
            }

        } //try
        catch (ClientException e) {
            System.out.println("Client exception ");
            System.out.println(e.getMessage());
        } catch (FaultException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Map<String, String> chargeCustomer(Map<String, String> customerChargeDataCybs) {

        /*
    * Input Map<String, String>
    //Structure of customerChargeDataCybs
     //   merchantID, merchantReferenceCode, purchaseTotals_currency
    // purchaseTotals_grandTotalAmount, recurringSubscriptionInfo_subscriptionID

    Output : Auth code
    *
    */
        String decision = "";
        String subscriptionId;
        String requestID;


        //read property file
        Properties props = new Properties();
        try {

            File file = new File(propertyFileCybs);
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();

            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }
        } //try
        catch (IOException io) {
            io.printStackTrace();
        } //catch
        
        
        HashMap request = new HashMap();

        System.out.println("DEBUG merchantId: " + customerChargeDataCybs.get("merchantID").toString());
        System.out.println("DEBUG merchantId: " + customerChargeDataCybs.get("merchantReferenceCode").toString());
        System.out.println("DEBUG merchantId: " + customerChargeDataCybs.get("purchaseTotals_currency").toString());
        System.out.println("DEBUG purchaseTotals_grandTotalAmount: " + 
                    customerChargeDataCybs.get("purchaseTotals_grandTotalAmount").toString());
        System.out.println("DEBUG subscriptionID: " + 
                    customerChargeDataCybs.get("subscriptionID").toString());
        
        request.put("merchantID", customerChargeDataCybs.get("merchantID").toString());
        request.put("merchantReferenceCode", customerChargeDataCybs.get("merchantReferenceCode").toString());
        request.put("purchaseTotals_currency", customerChargeDataCybs.get("purchaseTotals_currency").toString());
        request.put("purchaseTotals_grandTotalAmount",
                    customerChargeDataCybs.get("purchaseTotals_grandTotalAmount").toString());
        request.put("recurringSubscriptionInfo_subscriptionID",
                    customerChargeDataCybs.get("subscriptionID").toString());
        request.put("ccAuthService_run", "true");
        request.put("ccCaptureService_run", "true");
//        request.put("alternate_tax_indicator", customerChargeDataCybs.get("alternate_tax_indicator"));
//        request.put("alternate_tax_amount", customerChargeDataCybs.get("alternate_tax_amount"));
        
        displayMap("PROFILE REQUEST:", request);

        // Add optional fields here according to your business needs.
        // For information about processing the reply,
        // see Using the Decision and Reason Code Fields.
        try {
            Map<String, String> replyMap = Client.runTransaction(request, props);

            displayMap("REPLY:", replyMap);
            decision = replyMap.get("decision").toString();

            if (decision.equals("ACCEPT")) {
                requestID = replyMap.get("requestID").toString();
                return replyMap;
            } else {
                return null;
            }


        } //try
        catch (ClientException e) {
            System.out.println("Client exception ");
            System.out.println(e.getMessage());
        } catch (FaultException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String resolvEl(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
        String Message = valueExp.getValue(elContext).toString();
        return Message;
    }


    public void createProfileAction(HashMap dataMap) {
        String newSubscriptionId;
        String requestID;

        HashMap createCusData = null;

        if (dataMap == null) {

            createCusData = new HashMap();

            //Example of CreateProfile or new subscription
            // Add required fields
            createCusData.put("billTo_firstName", "Jack");
            createCusData.put("billTo_lastName", "Dowel");
            createCusData.put("billTo_street1", "2100 pacific dr");
            createCusData.put("billTo_city", "mclean");
            createCusData.put("billTo_state", "VA");
            createCusData.put("billTo_postalCode", "22102");
            createCusData.put("billTo_country", "US");
            createCusData.put("billTo_email", "jack@morgan.com");
            createCusData.put("purchaseTotals_currency", "USD");
            createCusData.put("card_accountNumber", "4111111111111111");
            createCusData.put("card_expirationMonth", "12");
            createCusData.put("card_expirationYear", "2017");
            createCusData.put("card_cardType", "001");
            createCusData.put("merchantID", "morganfranklin");
            createCusData.put("merchantReferenceCode", "COV_003");


        } else {
            createCusData = dataMap;
        }
        newSubscriptionId = createProfile(createCusData);
        System.out.println("Subscription creation " + newSubscriptionId);

    }

    public Map<String, String> createPurchaseAction(BigDecimal amount, String currencyCd, String subscriptionId) {
        String newSubscriptionId;
        String requestID;
        HashMap createCusData = new HashMap();

        //read property file
        Properties props = new Properties();
        try {

            File file = new File(propertyFileCybs);
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();

            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }
        } //try
        catch (IOException io) {
            io.printStackTrace();
        } //catch

        // Add required fields
        createCusData.put("merchantID", props.getProperty("merchantID"));
        createCusData.put("merchantReferenceCode", "COV-3424233");
        createCusData.put("purchaseTotals_currency", currencyCd);
        createCusData.put("purchaseTotals_grandTotalAmount", amount.toString());
        createCusData.put("subscriptionID", subscriptionId);
        System.out.println("DEBUG 2: subscriptionId: "+subscriptionId);
//        createCusData.put("alternate_tax_amount", "10");
//        createCusData.put("alternate_tax_indicator", "1");*/

        Map<String, String> replyMap = chargeCustomer(createCusData);
        //System.out.println("requestID " + requestID);
        return replyMap;
    }

    static public void main(String args[]) {

        String newSubscriptionId;
        String requestID;
        String customerId;

        ArrayList<PaymentProfileEntry> myList = new ArrayList<PaymentProfileEntry>();
        myList.clear();
        CyberSourceAdapter cyb = new CyberSourceAdapter();
        HashMap createCusData = new HashMap();


        // Example populate cardprofileArray

        customerId = "COV_001";
        //           cyb.populateCreditCardProfilesArray(myList,customerId);
        //*/

        /*
 //Example of CreateProfile or new subscription
      // Add required fields
      createCusData.put( "billTo_firstName", "Jack" );
      createCusData.put( "billTo_lastName", "Dowel" );
      createCusData.put( "billTo_street1", "2100 pacific dr" );
      createCusData.put( "billTo_city", "mclean" );
      createCusData.put( "billTo_state", "VA" );
      createCusData.put( "billTo_postalCode", "22102" );
      createCusData.put( "billTo_country", "US" );
      createCusData.put( "billTo_email", "jack@morgan.com" );
      createCusData.put( "purchaseTotals_currency", "USD" );
      createCusData.put( "card_accountNumber", "4111111111111111" );
      createCusData.put( "card_expirationMonth", "12" );
      createCusData.put( "card_expirationYear", "2017" );
      createCusData.put( "card_cardType", "001" );
      createCusData.put( "merchantID","morganfranklin" );
        createCusData.put( "merchantReferenceCode","COV_003" );

      newSubscriptionId = cyb.createProfile(createCusData);
       System.out.println( "Subscription creation " +newSubscriptionId );
// End of create profile
*/

        /*
 //Example of charge on a given subscription
      // Add required fields
       createCusData.put( "merchantID","morganfranklin" );
        createCusData.put( "merchantReferenceCode","COV_003" );
           createCusData.put( "purchaseTotals_currency","USD" );
           createCusData.put( "purchaseTotals_grandTotalAmount","100.00" );
           createCusData.put( "recurringSubscriptionInfo_subscriptionID","4954944072756352504011" );

      requestID = cyb.chargeCustomer(createCusData);
       System.out.println( "requestID " +requestID );
// End of charge
 */
    }
}
