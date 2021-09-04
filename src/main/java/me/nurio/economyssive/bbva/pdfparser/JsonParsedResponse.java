package me.nurio.economyssive.bbva.pdfparser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonParsedResponse {

    String operationDate;
    String valueDate;
    String operationType;
    String description;
    double amount;
    double balance;

    public JsonParsedResponse(String line) {
        // OPERATION DATE|VALUE DATE|OPERATION TYPE|DESCRIPTION|AMOUNT|BALANCE
        String[] split = line.split("\\|");
        operationDate = split[0];
        valueDate = split[1];
        operationType = split[2];
        description = split[3];
        amount = Double.parseDouble(split[4]);
        balance = Double.parseDouble(split[5]);
    }

}