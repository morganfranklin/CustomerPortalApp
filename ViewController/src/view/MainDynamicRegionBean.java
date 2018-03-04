package view;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;

public class MainDynamicRegionBean {

    // @SuppressWarnings("oracle.jdeveloper.java.field-not-serializable")
    private RichRegion regionbinding;
    GvcMain myPageFlowBean;

    public MainDynamicRegionBean() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(myPageFlowBean.getTaskFlowId());
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.myPageFlowBean.setTaskFlowId(taskFlowId);
    }

    public String portalPayment() {
        setDynamicTaskFlowId("/WEB-INF/portalPayment.xml#portalPayment");
        regionbinding.refresh(FacesContext.getCurrentInstance());
        return null;
    }

    public String paymentProfiles() {
        setDynamicTaskFlowId("/WEB-INF/paymentProfiles.xml#paymentProfiles");
        regionbinding.refresh(FacesContext.getCurrentInstance());
        return null;
    }
   
    public String paymentProfileNew() {
        setDynamicTaskFlowId("/WEB-INF/paymentProfileNew.xml#paymentProfileNew");
        regionbinding.refresh(FacesContext.getCurrentInstance());
        return null;
    }

    public void setRegionbinding(RichRegion regionbinding) {
        this.regionbinding = regionbinding;
    }

    public RichRegion getRegionbinding() {
        return regionbinding;
    }

    public void setMyPageFlowBean(GvcMain myPageFlowBean) {
        this.myPageFlowBean = myPageFlowBean;
    }

    public GvcMain getMyPageFlowBean() {
        return myPageFlowBean;
    }
}
