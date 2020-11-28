package fr.uge.corp.bank;

public class BankServiceProxy implements fr.uge.corp.bank.BankService {
  private String _endpoint = null;
  private fr.uge.corp.bank.BankService bankService = null;
  
  public BankServiceProxy() {
    _initBankServiceProxy();
  }
  
  public BankServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServiceProxy();
  }
  
  private void _initBankServiceProxy() {
    try {
      bankService = (new fr.uge.corp.bank.BankServiceServiceLocator()).getBankService();
      if (bankService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankService != null)
      ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.corp.bank.BankService getBankService() {
    if (bankService == null)
      _initBankServiceProxy();
    return bankService;
  }
  
  @Override
public void transfer(java.lang.String fromAccount, java.lang.String toAccount, long amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    bankService.transfer(fromAccount, toAccount, amount);
  }
  
  @Override
public long deposit(java.lang.String account, long amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.deposit(account, amount);
  }
  
  @Override
public long withdraw(java.lang.String account, long amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.withdraw(account, amount);
  }
  
  @Override
public long getBalance(java.lang.String account) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.getBalance(account);
  }
  
  
}