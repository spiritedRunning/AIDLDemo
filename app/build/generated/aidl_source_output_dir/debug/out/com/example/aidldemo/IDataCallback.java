/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.aidldemo;
// Declare any non-default types here with import statements

public interface IDataCallback extends android.os.IInterface
{
  /** Default implementation for IDataCallback. */
  public static class Default implements com.example.aidldemo.IDataCallback
  {
    @Override public int changeData(int index) throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.aidldemo.IDataCallback
  {
    private static final java.lang.String DESCRIPTOR = "com.example.aidldemo.IDataCallback";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.aidldemo.IDataCallback interface,
     * generating a proxy if needed.
     */
    public static com.example.aidldemo.IDataCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.aidldemo.IDataCallback))) {
        return ((com.example.aidldemo.IDataCallback)iin);
      }
      return new com.example.aidldemo.IDataCallback.Stub.Proxy(obj);
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
        case TRANSACTION_changeData:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _result = this.changeData(_arg0);
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.aidldemo.IDataCallback
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
      @Override public int changeData(int index) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(index);
          boolean _status = mRemote.transact(Stub.TRANSACTION_changeData, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().changeData(index);
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.aidldemo.IDataCallback sDefaultImpl;
    }
    static final int TRANSACTION_changeData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.example.aidldemo.IDataCallback impl) {
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
    public static com.example.aidldemo.IDataCallback getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public int changeData(int index) throws android.os.RemoteException;
}
