package view;

import java.io.Serializable;

public class GvcMain implements Serializable{
    @SuppressWarnings("compatibility:-4876225057947137724")
    private static final long serialVersionUID = 1L;
    private String taskFlowId = "/WEB-INF/portalPayment.xml#portalPayment";
    public GvcMain() {
        super();
    }

    public void setTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String getTaskFlowId() {
        return taskFlowId;
    }
}
