package com.cybersource.schemas.transaction_data.transactionprocessor;

import com.cybersource.schemas.transaction_data_1.ReplyMessage;
import com.cybersource.schemas.transaction_data_1.RequestMessage;

import javax.jws.WebService;

@WebService(serviceName = "TransactionProcessor",
            targetNamespace = "urn:schemas-cybersource-com:transaction-data:TransactionProcessor", portName = "portXML",
            endpointInterface = "com.cybersource.schemas.transaction_data.transactionprocessor.ITransactionProcessor",
            wsdlLocation = "/WEB-INF/wsdl/TransactionProcessor.wsdl")
public class ITransactionProcessorImpl {
    public ITransactionProcessorImpl() {
    }

    public ReplyMessage runTransaction(RequestMessage input) {
        return null;
    }
}
