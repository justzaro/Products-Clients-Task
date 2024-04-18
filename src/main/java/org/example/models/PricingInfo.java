package org.example.models;

public class PricingInfo {
    private double unitCost;
    private boolean isMarkupPercentage;
    private double markupValue;
    private boolean isPromotionPercentage;
    private double promotionValue;


    public PricingInfo(double unitCost, boolean isMarkupPercentage, double markupValue, boolean isPromotionPercentage, double promotionValue) {
        this.unitCost = unitCost;
        this.isMarkupPercentage = isMarkupPercentage;
        this.markupValue = markupValue;
        this.isPromotionPercentage = isPromotionPercentage;
        this.promotionValue = promotionValue;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public boolean isMarkupPercentage() {
        return isMarkupPercentage;
    }

    public void setMarkupPercentage(boolean markupPercentage) {
        isMarkupPercentage = markupPercentage;
    }

    public double getMarkupValue() {
        return markupValue;
    }

    public void setMarkupValue(double markupValue) {
        this.markupValue = markupValue;
    }

    public boolean isPromotionPercentage() {
        return isPromotionPercentage;
    }

    public void setPromotionPercentage(boolean promotionPercentage) {
        isPromotionPercentage = promotionPercentage;
    }

    public double isPromotionValue() {
        return promotionValue;
    }

    public void setPromotionValue(double promotionValue) {
        this.promotionValue = promotionValue;
    }

    @Override
    public String toString() {
        return "PricingInfo{" +
                "unitCost=" + unitCost +
                ", isMarkupPercentage=" + isMarkupPercentage +
                ", markupValue=" + markupValue +
                ", isPromotionPercentage=" + isPromotionPercentage +
                ", promotionValue=" + promotionValue +
                '}';
    }
}
