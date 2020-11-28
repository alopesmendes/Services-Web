package com.currencysystem.webservices.currencyserver;

public class CurrencyServerSoapProxy implements com.currencysystem.webservices.currencyserver.CurrencyServerSoap {
  private String _endpoint = null;
  private com.currencysystem.webservices.currencyserver.CurrencyServerSoap currencyServerSoap = null;
  
  public CurrencyServerSoapProxy() {
    _initCurrencyServerSoapProxy();
  }
  
  public CurrencyServerSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCurrencyServerSoapProxy();
  }
  
  private void _initCurrencyServerSoapProxy() {
    try {
      currencyServerSoap = (new com.currencysystem.webservices.currencyserver.CurrencyServerLocator()).getCurrencyServerSoap();
      if (currencyServerSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)currencyServerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)currencyServerSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (currencyServerSoap != null)
      ((javax.xml.rpc.Stub)currencyServerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.currencysystem.webservices.currencyserver.CurrencyServerSoap getCurrencyServerSoap() {
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap;
  }
  
  public java.lang.String activeCurrencies(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.activeCurrencies(licenseKey);
  }
  
  public void adminFXFeed(java.lang.String licenseKey, java.lang.String feedID, java.lang.String URL, java.lang.String userID, java.lang.String userName, java.lang.String password, com.currencysystem.webservices.currencyserver.CurncsrvFXFeedAction action) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminFXFeed(licenseKey, feedID, URL, userID, userName, password, action);
  }
  
  public void adminFXMode(java.lang.String licenseKey, com.currencysystem.webservices.currencyserver.CurncsrvFXModeMultiple multiple, com.currencysystem.webservices.currencyserver.CurncsrvFXModeLock lockCurrencies) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminFXMode(licenseKey, multiple, lockCurrencies);
  }
  
  public void adminLoad(java.lang.String licenseKey, java.lang.String file) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminLoad(licenseKey, file);
  }
  
  public void adminMessage(java.lang.String licenseKey, java.lang.String text, com.currencysystem.webservices.currencyserver.CurncsrvMessageType type) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminMessage(licenseKey, text, type);
  }
  
  public void adminReset(java.lang.String licenseKey, com.currencysystem.webservices.currencyserver.CurncsrvResetFlags flags) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminReset(licenseKey, flags);
  }
  
  public void adminSave(java.lang.String licenseKey, java.lang.String file) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminSave(licenseKey, file);
  }
  
  public void adminUpdateNow(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    currencyServerSoap.adminUpdateNow(licenseKey);
  }
  
  public java.lang.String allCurrencies(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.allCurrencies(licenseKey);
  }
  
  public java.lang.Object convert(java.lang.String licenseKey, java.lang.String fromCurrency, java.lang.String toCurrency, double amount, boolean rounding, java.lang.String format, com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.convert(licenseKey, fromCurrency, toCurrency, amount, rounding, format, returnRate, time, type);
  }
  
  public java.lang.String copyright(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.copyright(licenseKey);
  }
  
  public java.lang.String countryToCurrency(java.lang.String licenseKey, java.lang.String country, boolean activeOnly) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.countryToCurrency(licenseKey, country, activeOnly);
  }
  
  public java.lang.Object currencyToCountry(java.lang.String licenseKey, java.lang.String currency, com.currencysystem.webservices.currencyserver.CurncsrvReturnCountry returnCountry) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyToCountry(licenseKey, currency, returnCountry);
  }
  
  public java.lang.String currencyToDomain(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyToDomain(licenseKey, currency);
  }
  
  public java.lang.Object currencyToLocale(java.lang.String licenseKey, java.lang.String currency, com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale returnLocale) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyToLocale(licenseKey, currency, returnLocale);
  }
  
  public java.lang.String currencyCustom(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyCustom(licenseKey, currency, locale);
  }
  
  public java.lang.String currencyEntity(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination denomination, boolean titleStyle) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyEntity(licenseKey, currency, locale, denomination, titleStyle);
  }
  
  public boolean currencyExists(java.lang.String licenseKey, java.lang.String currency, boolean activeOnly) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyExists(licenseKey, currency, activeOnly);
  }
  
  public long currencyFeeds(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyFeeds(licenseKey, currency);
  }
  
  public long currencyHits(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyHits(licenseKey, currency);
  }
  
  public boolean currencyLegalTender(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyLegalTender(licenseKey, currency);
  }
  
  public java.lang.String currencyName(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, boolean titleStyle) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyName(licenseKey, currency, locale, titleStyle);
  }
  
  public boolean currencyPhysical(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyPhysical(licenseKey, currency);
  }
  
  public long currencyPopularity(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyPopularity(licenseKey, currency);
  }
  
  public java.lang.String currencyRegime(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyRegime(licenseKey, currency);
  }
  
  public java.lang.String currencySmallestUnit(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencySmallestUnit(licenseKey, currency);
  }
  
  public java.lang.String currencySubunit(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvSubunitInflection inflection, boolean titleStyle) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencySubunit(licenseKey, currency, locale, inflection, titleStyle);
  }
  
  public java.lang.String currencySymbol(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencySymbol(licenseKey, currency, locale);
  }
  
  public boolean currencyTriangulation(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyTriangulation(licenseKey, currency);
  }
  
  public java.lang.String currencyUnit(java.lang.String licenseKey, java.lang.String currency, java.lang.String locale, com.currencysystem.webservices.currencyserver.CurncsrvUnitInflection inflection, boolean titleStyle) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyUnit(licenseKey, currency, locale, inflection, titleStyle);
  }
  
  public boolean currencyWarning(java.lang.String licenseKey, java.lang.String currency) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.currencyWarning(licenseKey, currency);
  }
  
  public java.lang.String domainToCurrency(java.lang.String licenseKey, java.lang.String domain, boolean activeOnly) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.domainToCurrency(licenseKey, domain, activeOnly);
  }
  
  public java.lang.String export(java.lang.String licenseKey, java.lang.String format, java.lang.String encoding, java.lang.String baseCurrency, java.lang.String locale, java.lang.String flags, java.lang.String serviceLicenseKey, java.lang.String serviceExpirationTime, java.lang.String serviceRenewalURL, java.lang.String errorCode, java.lang.String errorMessage, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.export(licenseKey, format, encoding, baseCurrency, locale, flags, serviceLicenseKey, serviceExpirationTime, serviceRenewalURL, errorCode, errorMessage, time, type);
  }
  
  public java.lang.String localeToCurrency(java.lang.String licenseKey, java.lang.String locale, boolean activeOnly) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.localeToCurrency(licenseKey, locale, activeOnly);
  }
  
  public java.lang.String message(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.message(licenseKey);
  }
  
  public java.lang.Object rate(java.lang.String licenseKey, java.lang.String baseCurrency, java.lang.String toCurrency, boolean rounding, java.lang.String format, com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.rate(licenseKey, baseCurrency, toCurrency, rounding, format, returnRate, time, type);
  }
  
  public java.lang.String source(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.source(licenseKey);
  }
  
  public java.lang.Object time(java.lang.String licenseKey, java.lang.String currencies, com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation information, com.currencysystem.webservices.currencyserver.CurncsrvTimePriority priority, com.currencysystem.webservices.currencyserver.CurncsrvReturnTime returnTime, java.lang.String time, java.lang.String type) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.time(licenseKey, currencies, information, priority, returnTime, time, type);
  }
  
  public java.lang.String version(java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (currencyServerSoap == null)
      _initCurrencyServerSoapProxy();
    return currencyServerSoap.version(licenseKey);
  }
  
  
}