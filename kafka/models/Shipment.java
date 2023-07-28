package com.prasad.scm.springapplication.models;

import javax.validation.constraints.Email;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Shipmentdetails")
public class Shipment {

    private int shipmentNumber; // Shipment number associated with the shipment
    private int containerNumber; // Container number of the shipment
    private String descripton; // Description of the shipment
    private String route; // Route of the shipment
    private String goods; // Goods information of the shipment
    private String country; // Country of the shipment
    private String deliveryDate; // Delivery date of the shipment
    private int pONumber; // Purchase order number associated with the shipment
    private int deliveryNumber; // Delivery number of the shipment
    private int nDCNumber; // NDC (National Drug Code) number of the shipment
    private int batchId; // Batch ID of the shipment
    private int serialNumberOfGoods; // Serial number of the goods in the shipment

    @Email
    private String email; // Email address associated with the shipment

    /**
     * Get the email address associated with the shipment.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address associated with the shipment.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the shipment number.
     *
     * @return The shipment number.
     */
    public int getShipmentNumber() {
        return shipmentNumber;
    }

    /**
     * Set the shipment number.
     *
     * @param shipmentNumber The shipment number.
     */
    public void setShipmentNumber(int shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    /**
     * Get the container number of the shipment.
     *
     * @return The container number.
     */
    public int getContainerNumber() {
        return containerNumber;
    }

    /**
     * Set the container number of the shipment.
     *
     * @param containerNumber The container number.
     */
    public void setContainerNumber(int containerNumber) {
        this.containerNumber = containerNumber;
    }

    /**
     * Get the description of the shipment.
     *
     * @return The description.
     */
    public String getDescripton() {
        return descripton;
    }

    /**
     * Set the description of the shipment.
     *
     * @param descripton The description.
     */
    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    /**
     * Get the route of the shipment.
     *
     * @return The route.
     */
    public String getRoute() {
        return route;
    }

    /**
     * Set the route of the shipment.
     *
     * @param route The route.
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * Get the goods information of the shipment.
     *
     * @return The goods information.
     */
    public String getGoods() {
        return goods;
    }

    /**
     * Set the goods information of the shipment.
     *
     * @param goods The goods information.
     */
    public void setGoods(String goods) {
        this.goods = goods;
    }

    /**
     * Get the country of the shipment.
     *
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country of the shipment.
     *
     * @param country The country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the delivery date of the shipment.
     *
     * @return The delivery date.
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Set the delivery date of the shipment.
     *
     * @param deliveryDate The delivery date.
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Get the purchase order number associated with the shipment.
     *
     * @return The purchase order number.
     */
    public int getpONumber() {
        return pONumber;
    }

    /**
     * Set the purchase order number associated with the shipment.
     *
     * @param pONumber The purchase order number.
     */
    public void setpONumber(int pONumber) {
        this.pONumber = pONumber;
    }

    /**
     * Get the delivery number of the shipment.
     *
     * @return The delivery number.
     */
    public int getDeliveryNumber() {
        return deliveryNumber;
    }

    /**
     * Set the delivery number of the shipment.
     *
     * @param deliveryNumber The delivery number.
     */
    public void setDeliveryNumber(int deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    /**
     * Get the NDC (National Drug Code) number of the shipment.
     *
     * @return The NDC number.
     */
    public int getnDCNumber() {
        return nDCNumber;
    }

    /**
     * Set the NDC (National Drug Code) number of the shipment.
     *
     * @param nDCNumber The NDC number.
     */
    public void setnDCNumber(int nDCNumber) {
        this.nDCNumber = nDCNumber;
    }

    /**
     * Get the batch ID of the shipment.
     *
     * @return The batch ID.
     */
    public int getBatchId() {
        return batchId;
    }

    /**
     * Set the batch ID of the shipment.
     *
     * @param batchId The batch ID.
     */
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    /**
     * Get the serial number of the goods in the shipment.
     *
     * @return The serial number.
     */
    public int getSerialNumberOfGoods() {
        return serialNumberOfGoods;
    }

    /**
     * Set the serial number of the goods in the shipment.
     *
     * @param serialNumberOfGoods The serial number.
     */
    public void setSerialNumberOfGoods(int serialNumberOfGoods) {
        this.serialNumberOfGoods = serialNumberOfGoods;
    }
}
