package model;

import model.GenericDataHandler.ProjectVariable;

import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.Map;

import model.GenericDataHandler;

public class Execution {
    public static void main(String args[]) {
            GenericDataHandler dataAdapter = new GenericDataHandler();
            String execPlanCode;
            String userCfgFile = "";
            String userIdSelected ="";
            String runType = "";
              
            //Constants
              userCfgFile = "C:\\pbbdat\\projects\\XPE\\cfg\\xpe_uat.properties";
            
            userIdSelected = "COVANTA";
              
            runType = "TST";  //TST or PRD
            
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
            Date fromDate = new Date (System.currentTimeMillis());
            Date toDate  = new Date (System.currentTimeMillis());
            try
            {
                fromDate = simpleDate.parse("2016-08-01");
                toDate = simpleDate.parse("2016-08-31");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
                  
            System.out.println("fromDate" + fromDate);
            
          execPlanCode = "TEST_EXEC_PLAN";
    
            dataAdapter.setExecutionParameters(execPlanCode, fromDate, toDate);
            
            dataAdapter.setConfig(userCfgFile);
            dataAdapter.setUserId(userIdSelected);
            dataAdapter.setRunType(runType);
         
            System.out.println("INFO starting as a new thread");
            
    //        Thread newThread = new Thread(dataAdapter);
    //           newThread.start();
            
    
          }
           
}
