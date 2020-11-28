/**
 * CurrencyServerSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public interface CurrencyServerSoap extends java.rmi.Remote {

    /**
     * Returns a semicolon-separated list of active currencies.
     */
    public java.lang.String activeCurrencies(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Adds the specified FX feed to the feeds list, optionally replacing
     * the existing feeds. Access to this administrative operation may be
     * restricted.
     */
    public void adminFXFeed(java.lang.String licenseKey, java.lang.String feedID, java.lang.String URL, java.lang.String userID, java.lang.String userName, java.lang.String password, com.currencysystem.webservices.currencyserver.CurncsrvFXFeedAction action) throws java.rmi.RemoteException;

    /**
     * Sets the FX mode (defining how data is loaded and updated in
     * general, and from multiple FX feeds). Access to this administrative
     * operation may be restricted.
     */
    public void adminFXMode(java.lang.String licenseKey, com.currencysystem.webservices.currencyserver.CurncsrvFXModeMultiple multiple, com.currencysystem.webservices.currencyserver.CurncsrvFXModeLock lockCurrencies) throws java.rmi.RemoteException;

    /**
     * Loads a settings file. Access to this administrative operation
     * may be restricted.
     */
    public void adminLoad(java.lang.String licenseKey, java.lang.String file) throws java.rmi.RemoteException;

    /**
     * Sends a message as specified in the notification options. Access
     * to this administrative operation may be restricted.
     */
    public void adminMessage(java.lang.String licenseKey, java.lang.String text, com.currencysystem.webservices.currencyserver.CurncsrvMessageType type) throws java.rmi.RemoteException;

    /**
     * Resets all software settings to their default values. Access
     * to this administrative operation may be restricted.
     */
    public void adminReset(java.lang.String licenseKey, com.currencysystem.webservices.currencyserver.CurncsrvResetFlags flags) throws java.rmi.RemoteException;

    /**
     * Saves a settings file. Access to this administrative operation
     * may be restricted.
     */
    public void adminSave(java.lang.String licenseKey, java.lang.String file) throws java.rmi.RemoteException;

    /**
     * Establishes a connection to the data source(s) and updates
     * the currency data. Access to this administrative operation may be
     * restricted.
     */
    public void adminUpdateNow(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Returns a semicolon-separated list of currencies.
     */
    public java.lang.String allCurrencies(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Converts a currency amount. The result is either a number or
     * a string which can optionally be rounded and formatted. When a string
     * is returned, either fromCurrency or toCurrency (but not both) may
     * contain a list of semicolon-separated active currencies. Leave the
     * time and type parameters empty for forward compatibility.
     */
    public java.lang.Object convert(java.lang.String licenseKey, java.lang.String fromCurrency, java.lang.String toCurrency, double amount, boolean rounding, java.lang.String format, com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * Returns the copyright information provided by the data source(s),
     * if any.
     */
    public java.lang.String copyright(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Returns a currency code (ISO 4217 Alpha-3) associated to the
     * specified country code (ISO 3166 Alpha-2).
     */
    public java.lang.String countryToCurrency(java.lang.String licenseKey, java.lang.String country, boolean activeOnly) throws java.rmi.RemoteException;

    /**
     * Returns a country code (ISO 3166 Alpha-2) associated to the
     * specified currency (ISO 4217 Alpha-3).
     */
    public java.lang.Object currencyToCountry(java.lang.String licenseKey, java.lang.String currency, com.currencysystem.webservices.currencyserver.CurncsrvReturnCountry returnCountry) throws java.rmi.RemoteException;

    /**
     * Returns a domain suffix (IANA TLD) associated to the specified
     * currency code (ISO 4217 Alpha-3).
     */
    public java.lang.String currencyToDomain(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns a locale identifier (Windows LCID or RFC 4646) associated
     * to the specified currency code (ISO 4217 Alpha-3).
     */
    public java.lang.Object currencyToLocale(java.lang.String licenseKey, java.lang.String currency, com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale returnLocale) throws java.rmi.RemoteException;

    /**
     * Returns the currency custom string, based on the specified
     * locale. The currency parameter may contain a list of semicolon-separated
     * active currencies.
     */
    public java.lang.String currencyCustom(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale) throws java.rmi.RemoteException;

    /**
     * Returns the name of the entity associated to the currency,
     * based on the specified locale, denomination (short or official) and
     * title style. The currency parameter may contain a list of semicolon-separated
     * active currencies.
     */
    public java.lang.String currencyEntity(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination denomination, boolean titleStyle) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean value indicating whether the currency is
     * included in the list of active currencies or of all currencies.
     */
    public boolean currencyExists(java.lang.String licenseKey, java.lang.String currency, boolean activeOnly) throws java.rmi.RemoteException;

    /**
     * Returns the number of FX feeds providing exchange rate data
     * for the currency.
     */
    public long currencyFeeds(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the number of times this currency has been referenced
     * by a COM object or by the Web service.
     */
    public long currencyHits(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean value indicating whether the currency is
     * legal tender.
     */
    public boolean currencyLegalTender(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the extended name of the currency, based on the specified
     * locale and title style. The currency parameter may contain a list
     * of semicolon-separated active currencies.
     */
    public java.lang.String currencyName(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, boolean titleStyle) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean value indicating whether the currency is
     * a physical currency.
     */
    public boolean currencyPhysical(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the currency popularity value (1 = high, 2 = medium,
     * 3 = low). The value is the inverse of the Currency Rank (1 = low,
     * 2 = medium, 3 = high).
     */
    public long currencyPopularity(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the identifier of a regime or monetary union, or an
     * empty string. The currency parameter may contain a list of semicolon-separated
     * active currencies.
     */
    public java.lang.String currencyRegime(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the smallest unit for the currency. Trailing zero characters
     * are used to specify the preferred format for rounding. The currency
     * parameter may contain a list of semicolon-separated active currencies.
     */
    public java.lang.String currencySmallestUnit(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the subunit name, based on the specified locale, inflection
     * (singular or plural) and title style. The currency parameter may contain
     * a list of semicolon-separated active currencies.
     */
    public java.lang.String currencySubunit(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvSubunitInflection inflection, boolean titleStyle) throws java.rmi.RemoteException;

    /**
     * Returns the currency symbol, based on the specified locale.
     * The currency parameter may contain a list of semicolon-separated active
     * currencies.
     */
    public java.lang.String currencySymbol(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean value indicating whether the currency is
     * a subunit of BaseUnit at a constant rate.
     */
    public boolean currencyTriangulation(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns the unit name, based on the specified locale, inflection
     * (singular or plural) and title style. The currency parameter may contain
     * a list of semicolon-separated active currencies.
     */
    public java.lang.String currencyUnit(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvUnitInflection inflection, boolean titleStyle) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean value indicating whether the currency has
     * been referenced by a recent warning condition.
     */
    public boolean currencyWarning(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException;

    /**
     * Returns a currency code (ISO 4217 Alpha-3) associated to the
     * specified domain name (string ending with IANA TLD).
     */
    public java.lang.String domainToCurrency(java.lang.String licenseKey, java.lang.String domain, boolean activeOnly) throws java.rmi.RemoteException;

    /**
     * Returns a string with information on the active currencies
     * in the specified format.
     */
    public java.lang.String export(java.lang.String licenseKey, java.lang.String format, java.lang.String encoding, java.lang.String baseCurrency, java.lang.String locale, java.lang.String flags, java.lang.String serviceLicenseKey, java.lang.String serviceExpirationTime, java.lang.String serviceRenewalURL, java.lang.String errorCode, java.lang.String errorMessage, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * Returns a currency code (ISO 4217 Alpha-3) associated to the
     * specified locale identifier (Windows LCID or ISO 639-2 Alpha-2).
     */
    public java.lang.String localeToCurrency(java.lang.String licenseKey, java.lang.String locale, boolean activeOnly) throws java.rmi.RemoteException;

    /**
     * Returns the message(s) from the data source(s), if any.
     */
    public java.lang.String message(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Returns the exchange (conversion) rate. The result is either
     * a number or a string which can optionally be rounded and formatted.
     * When a string is returned, either baseCurrency or toCurrency (but
     * not both) may contain a list of semicolon-separated active currencies.
     * Leave the time and type parameters empty for forward compatibility.
     */
    public java.lang.Object rate(java.lang.String licenseKey, java.lang.String baseCurrency, java.lang.String toCurrency, boolean rounding, java.lang.String format, com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * Returns the name(s) of the data source(s).
     */
    public java.lang.String source(java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * Returns time information about the specified currency or currencies,
     * or the current time.
     */
    public java.lang.Object time(java.lang.String licenseKey, java.lang.String currencies, com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation information, com.currencysystem.webservices.currencyserver.CurncsrvTimePriority priority, com.currencysystem.webservices.currencyserver.CurncsrvReturnTime returnTime, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * Returns the software version.
     */
    public java.lang.String version(java.lang.String licenseKey) throws java.rmi.RemoteException;
}
