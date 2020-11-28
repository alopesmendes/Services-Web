/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.corp.bank;

public interface BankService extends java.rmi.Remote {
    public void transfer(java.lang.String fromAccount, java.lang.String toAccount, long amount) throws java.rmi.RemoteException;
    public long deposit(java.lang.String account, long amount) throws java.rmi.RemoteException;
    public long withdraw(java.lang.String account, long amount) throws java.rmi.RemoteException;
    public long getBalance(java.lang.String account) throws java.rmi.RemoteException;
}
