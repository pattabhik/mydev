package com.pattabhi.interest;

public class InterestCalculatorInput {
    private final String fromDtStr;
    private final String toDtStr;
    private final double principal;
    private final double rate;

    // Private constructor to enforce object creation through the Builder
    private InterestCalculatorInput(Builder builder) {
        this.fromDtStr = builder.fromDtStr;
        this.toDtStr = builder.toDtStr;
        this.principal = builder.principal;
        this.rate = builder.rate;
    }

    // Getters
    public String getFromDtStr() {
        return fromDtStr;
    }

    public String getToDtStr() {
        return toDtStr;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterestPercentage() {
        return rate / 100;
    }

    // Static Builder class
    public static class Builder {
        private String fromDtStr;
        private String toDtStr;
        private double principal;
        private double rate;

        // Setter methods for each field returning the Builder instance
        public Builder setFromDtStr(String fromDtStr) {
            this.fromDtStr = fromDtStr;
            return this;
        }

        public Builder setToDtStr(String toDtStr) {
            this.toDtStr = toDtStr;
            return this;
        }

        public Builder setPrincipal(int principal) {
            this.principal = principal;
            return this;
        }

        public Builder setRate(double rate) {
            this.rate = rate;
            return this;
        }

        // Method to build the final InterestCalculationInput object
        public InterestCalculatorInput build() {
            return new InterestCalculatorInput(this);
        }
    }

    @Override
    public String toString() {
        return "From Date='" + fromDtStr + '\'' + ", To Date='" + toDtStr + '\'' + ", principal=" + principal
                + ", rate=" + rate;
    }
}
