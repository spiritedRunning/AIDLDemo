/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.aidldemo;
public interface IMyAidlInterface extends android.os.IInterface
{
  /** Default implementation for IMyAidlInterface. */
  public static class Default implements com.example.aidldemo.IMyAidlInterface
  {
    @Override public void addPerson(com.example.aidldemo.Person person) throws android.os.RemoteException
    {
    }
    @Override public java.lang.String modifyPerson(com.example.aidldemo.Person person) throws android.os.RemoteException
    {
      return null;
    }
    @Override public java.lang.String getPersonInfo(com.example.aidldemo.Person info) throws android.os.RemoteException
    {
      return null;
    }
    @Override public void convertPeople(com.example.aidldemo.Person people) throws android.os.RemoteException
    {
    }
    @Override public java.util.List<com.example.aidldemo.Person> getPersonList() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.aidldemo.IMyAidlInterface
  {
    private static final java.lang.String DESCRIPTOR = "com.example.aidldemo.IMyAidlInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.aidldemo.IMyAidlInterface interface,
     * generating a proxy if needed.
     */
    public static com.example.aidldemo.IMyAidlInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.aidldemo.IMyAidlInterface))) {
        return ((com.example.aidldemo.IMyAidlInterface)iin);
      }
      return new com.example.aidldemo.IMyAidlInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_addPerson:
        {
          data.enforceInterface(descriptor);
          com.example.aidldemo.Person _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.aidldemo.Person.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.addPerson(_arg0);
          return true;
        }
        case TRANSACTION_modifyPerson:
        {
          data.enforceInterface(descriptor);
          com.example.aidldemo.Person _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.aidldemo.Person.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          java.lang.String _result = this.modifyPerson(_arg0);
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_getPersonInfo:
        {
          data.enforceInterface(descriptor);
          com.example.aidldemo.Person _arg0;
          _arg0 = new com.example.aidldemo.Person();
          java.lang.String _result = this.getPersonInfo(_arg0);
          reply.writeNoException();
          reply.writeString(_result);
          if ((_arg0!=null)) {
            reply.writeInt(1);
            _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        case TRANSACTION_convertPeople:
        {
          data.enforceInterface(descriptor);
          com.example.aidldemo.Person _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.aidldemo.Person.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.convertPeople(_arg0);
          reply.writeNoException();
          if ((_arg0!=null)) {
            reply.writeInt(1);
            _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        case TRANSACTION_getPersonList:
        {
          data.enforceInterface(descriptor);
          java.util.List<com.example.aidldemo.Person> _result = this.getPersonList();
          reply.writeNoException();
          reply.writeTypedList(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.aidldemo.IMyAidlInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public void addPerson(com.example.aidldemo.Person person) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((person!=null)) {
            _data.writeInt(1);
            person.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_addPerson, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().addPerson(person);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public java.lang.String modifyPerson(com.example.aidldemo.Person person) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((person!=null)) {
            _data.writeInt(1);
            person.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_modifyPerson, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().modifyPerson(person);
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public java.lang.String getPersonInfo(com.example.aidldemo.Person info) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getPersonInfo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getPersonInfo(info);
          }
          _reply.readException();
          _result = _reply.readString();
          if ((0!=_reply.readInt())) {
            info.readFromParcel(_reply);
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void convertPeople(com.example.aidldemo.Person people) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((people!=null)) {
            _data.writeInt(1);
            people.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_convertPeople, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().convertPeople(people);
            return;
          }
          _reply.readException();
          if ((0!=_reply.readInt())) {
            people.readFromParcel(_reply);
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public java.util.List<com.example.aidldemo.Person> getPersonList() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<com.example.aidldemo.Person> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getPersonList, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getPersonList();
          }
          _reply.readException();
          _result = _reply.createTypedArrayList(com.example.aidldemo.Person.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.aidldemo.IMyAidlInterface sDefaultImpl;
    }
    static final int TRANSACTION_addPerson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_modifyPerson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getPersonInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_convertPeople = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getPersonList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    public static boolean setDefaultImpl(com.example.aidldemo.IMyAidlInterface impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.example.aidldemo.IMyAidlInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void addPerson(com.example.aidldemo.Person person) throws android.os.RemoteException;
  public java.lang.String modifyPerson(com.example.aidldemo.Person person) throws android.os.RemoteException;
  public java.lang.String getPersonInfo(com.example.aidldemo.Person info) throws android.os.RemoteException;
  public void convertPeople(com.example.aidldemo.Person people) throws android.os.RemoteException;
  public java.util.List<com.example.aidldemo.Person> getPersonList() throws android.os.RemoteException;
}
