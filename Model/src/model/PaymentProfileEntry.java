package model;

public class PaymentProfileEntry {
    
    public PaymentProfileEntry(String newPaymentProfileId, String newCustomerId, String newProfileAccount
                               , String newProfilePayMethod, String newExpiryDate, String newProfileName,String email) {
        super();
        this.setPaymentProfileId(newPaymentProfileId);
        this.setCustomerId(newCustomerId);
        this.setProfileAcctount(newProfileAccount);
        this.setProfilePayMethod(newProfilePayMethod);
        this.setExpiryDate(newExpiryDate);
        this.setProfileName(newProfileName);   
        this.setEmail(email);
    }
    
    private String paymentProfileId = "unknown profile";
    private String customerId = "unknown customer";
    private String profileAccount = "unknown profile";
    private String profilePayMethod = "unknown paymentMethod";
    private String expiryDate = "unknown expiryDate";
    private String profileName = "unknown customer";
    private String email;
    
    public void setPaymentProfileId(String givenPaymentProfileId) {
        this.paymentProfileId = givenPaymentProfileId;
    }
    
    public String getPaymentProfileId() {
        return this.paymentProfileId;
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
  
    public void setProfileAcctount(String givenProfileAccount) {
        this.profileAccount = givenProfileAccount;
    }

    public String setProfileAcctount() {
        return profileAccount;
    }  
  
    public void setProfilePayMethod(String givenProfilePayMethod) {
        this.profilePayMethod = givenProfilePayMethod;
    }

    public String getProfilePayMethod() {
        return profilePayMethod;
    }    
  
    public void setExpiryDate(String givenExpiryDate) {
        this.expiryDate = givenExpiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }    
 
    public void setProfileName(String givenProfileName) {
        this.profileName = givenProfileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfileAccount() {
        return profileAccount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
