package com.anthony.model;

import java.math.BigDecimal;

public class Message {

	Integer id;

	String userId;

	String currencyFrom;

	String currencyTo;

	BigDecimal amountSell;

	BigDecimal amountBuy;

	BigDecimal rate;

	String originatingCountry;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the currencyFrom
	 */
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	/**
	 * @param currencyFrom
	 *            the currencyFrom to set
	 */
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	/**
	 * @return the currencyTo
	 */
	public String getCurrencyTo() {
		return currencyTo;
	}

	/**
	 * @param currencyTo
	 *            the currencyTo to set
	 */
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	/**
	 * @return the amountSell
	 */
	public BigDecimal getAmountSell() {
		return amountSell;
	}

	/**
	 * @param amountSell
	 *            the amountSell to set
	 */
	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	/**
	 * @return the amountBuy
	 */
	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	/**
	 * @param amountBuy
	 *            the amountBuy to set
	 */
	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the originatingCountry
	 */
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	/**
	 * @param originatingCountry
	 *            the originatingCountry to set
	 */
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
}
