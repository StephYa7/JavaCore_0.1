package Prac_Vs_ITVDN.JSON.gson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyRate {

    private String Date;
    private String PreviousDate;
    private String PreviousURL;
    private Object Timestamp;
    private Valute Valute;

    @Override
    public String toString() {
        return
                "Курс валют на дату'" + Date + '\'' +
                ", Valute=" + Valute +
                '}';
    }

    @Data
    @AllArgsConstructor
    class Valute {
        private GBP GBP;
        private GBP BYN;
        private GBP EUR;

        @Data
        @AllArgsConstructor
        class GBP {


            private String ID;
            private String NumCode;
            private String CharCode;
            private String Nominal;
            private String Name;
            private String Value;
            private String Previous;
        }

//    @SerializedName("ccy")
    }

}