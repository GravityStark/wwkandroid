// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AccountMsg.proto

package message;

public final class AccountProto {
  private AccountProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  /**
   * Protobuf enum {@code message.LOGIN_TYPE}
   */
  public enum LOGIN_TYPE
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     * </pre>
     *
     * <code>LOGIN = 1;</code>
     */
    LOGIN(1),
    /**
     * <pre>
     * </pre>
     *
     * <code>CREATE = 2;</code>
     */
    CREATE(2),
    ;

    /**
     * <pre>
     * </pre>
     *
     * <code>LOGIN = 1;</code>
     */
    public static final int LOGIN_VALUE = 1;
    /**
     * <pre>
     * </pre>
     *
     * <code>CREATE = 2;</code>
     */
    public static final int CREATE_VALUE = 2;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static LOGIN_TYPE valueOf(int value) {
      return forNumber(value);
    }

    public static LOGIN_TYPE forNumber(int value) {
      switch (value) {
        case 1: return LOGIN;
        case 2: return CREATE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<LOGIN_TYPE>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        LOGIN_TYPE> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<LOGIN_TYPE>() {
            public LOGIN_TYPE findValueByNumber(int number) {
              return LOGIN_TYPE.forNumber(number);
            }
          };

    private final int value;

    private LOGIN_TYPE(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.LOGIN_TYPE)
  }

  /**
   * Protobuf enum {@code message.LOGIN_RESULT_TYPE}
   */
  public enum LOGIN_RESULT_TYPE
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *账号不存在
     * </pre>
     *
     * <code>NO_ACCOUNT = 1;</code>
     */
    NO_ACCOUNT(1),
    /**
     * <pre>
     *密码错误
     * </pre>
     *
     * <code>PWD_ERROR = 2;</code>
     */
    PWD_ERROR(2),
    /**
     * <pre>
     *成功
     * </pre>
     *
     * <code>SUCCESS = 3;</code>
     */
    SUCCESS(3),
    /**
     * <pre>
     *账号名存在
     * </pre>
     *
     * <code>CREATE_NAME_EXIST = 4;</code>
     */
    CREATE_NAME_EXIST(4),
    ;

    /**
     * <pre>
     *账号不存在
     * </pre>
     *
     * <code>NO_ACCOUNT = 1;</code>
     */
    public static final int NO_ACCOUNT_VALUE = 1;
    /**
     * <pre>
     *密码错误
     * </pre>
     *
     * <code>PWD_ERROR = 2;</code>
     */
    public static final int PWD_ERROR_VALUE = 2;
    /**
     * <pre>
     *成功
     * </pre>
     *
     * <code>SUCCESS = 3;</code>
     */
    public static final int SUCCESS_VALUE = 3;
    /**
     * <pre>
     *账号名存在
     * </pre>
     *
     * <code>CREATE_NAME_EXIST = 4;</code>
     */
    public static final int CREATE_NAME_EXIST_VALUE = 4;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static LOGIN_RESULT_TYPE valueOf(int value) {
      return forNumber(value);
    }

    public static LOGIN_RESULT_TYPE forNumber(int value) {
      switch (value) {
        case 1: return NO_ACCOUNT;
        case 2: return PWD_ERROR;
        case 3: return SUCCESS;
        case 4: return CREATE_NAME_EXIST;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<LOGIN_RESULT_TYPE>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        LOGIN_RESULT_TYPE> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<LOGIN_RESULT_TYPE>() {
            public LOGIN_RESULT_TYPE findValueByNumber(int number) {
              return LOGIN_RESULT_TYPE.forNumber(number);
            }
          };

    private final int value;

    private LOGIN_RESULT_TYPE(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.LOGIN_RESULT_TYPE)
  }

  public interface LoginReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:message.LoginReq)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    boolean hasAccountName();
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    java.lang.String getAccountName();
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    com.google.protobuf.ByteString
        getAccountNameBytes();

    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    boolean hasPassword();
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    java.lang.String getPassword();
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    com.google.protobuf.ByteString
        getPasswordBytes();

    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    boolean hasType();
    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    int getType();
  }
  /**
   * <pre>
   **
   * 登录
   * </pre>
   *
   * Protobuf type {@code message.LoginReq}
   */
  public  static final class LoginReq extends
      com.google.protobuf.GeneratedMessageLite<
          LoginReq, LoginReq.Builder> implements
      // @@protoc_insertion_point(message_implements:message.LoginReq)
      LoginReqOrBuilder {
    private LoginReq() {
      accountName_ = "";
      password_ = "";
    }
    private int bitField0_;
    public static final int ACCOUNTNAME_FIELD_NUMBER = 1;
    private java.lang.String accountName_;
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    public boolean hasAccountName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    public java.lang.String getAccountName() {
      return accountName_;
    }
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAccountNameBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(accountName_);
    }
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    private void setAccountName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      accountName_ = value;
    }
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    private void clearAccountName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      accountName_ = getDefaultInstance().getAccountName();
    }
    /**
     * <pre>
     *账号名
     * </pre>
     *
     * <code>optional string accountName = 1;</code>
     */
    private void setAccountNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      accountName_ = value.toStringUtf8();
    }

    public static final int PASSWORD_FIELD_NUMBER = 2;
    private java.lang.String password_;
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public boolean hasPassword() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public java.lang.String getPassword() {
      return password_;
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(password_);
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    private void setPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      password_ = value;
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    private void clearPassword() {
      bitField0_ = (bitField0_ & ~0x00000002);
      password_ = getDefaultInstance().getPassword();
    }
    /**
     * <pre>
     *密码
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    private void setPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      password_ = value.toStringUtf8();
    }

    public static final int TYPE_FIELD_NUMBER = 3;
    private int type_;
    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    private void setType(int value) {
      bitField0_ |= 0x00000004;
      type_ = value;
    }
    /**
     * <pre>
     *  LOGIN_TYPE
     * </pre>
     *
     * <code>required int32 type = 3;</code>
     */
    private void clearType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      type_ = 0;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeString(1, getAccountName());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeString(2, getPassword());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, type_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getAccountName());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(2, getPassword());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, type_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static message.AccountProto.LoginReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static message.AccountProto.LoginReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static message.AccountProto.LoginReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static message.AccountProto.LoginReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static message.AccountProto.LoginReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static message.AccountProto.LoginReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static message.AccountProto.LoginReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(message.AccountProto.LoginReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     **
     * 登录
     * </pre>
     *
     * Protobuf type {@code message.LoginReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          message.AccountProto.LoginReq, Builder> implements
        // @@protoc_insertion_point(builder_implements:message.LoginReq)
        message.AccountProto.LoginReqOrBuilder {
      // Construct using message.AccountProto.LoginReq.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public boolean hasAccountName() {
        return instance.hasAccountName();
      }
      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public java.lang.String getAccountName() {
        return instance.getAccountName();
      }
      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAccountNameBytes() {
        return instance.getAccountNameBytes();
      }
      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public Builder setAccountName(
          java.lang.String value) {
        copyOnWrite();
        instance.setAccountName(value);
        return this;
      }
      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public Builder clearAccountName() {
        copyOnWrite();
        instance.clearAccountName();
        return this;
      }
      /**
       * <pre>
       *账号名
       * </pre>
       *
       * <code>optional string accountName = 1;</code>
       */
      public Builder setAccountNameBytes(
          com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setAccountNameBytes(value);
        return this;
      }

      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public boolean hasPassword() {
        return instance.hasPassword();
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public java.lang.String getPassword() {
        return instance.getPassword();
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public com.google.protobuf.ByteString
          getPasswordBytes() {
        return instance.getPasswordBytes();
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public Builder setPassword(
          java.lang.String value) {
        copyOnWrite();
        instance.setPassword(value);
        return this;
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public Builder clearPassword() {
        copyOnWrite();
        instance.clearPassword();
        return this;
      }
      /**
       * <pre>
       *密码
       * </pre>
       *
       * <code>optional string password = 2;</code>
       */
      public Builder setPasswordBytes(
          com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setPasswordBytes(value);
        return this;
      }

      /**
       * <pre>
       *  LOGIN_TYPE
       * </pre>
       *
       * <code>required int32 type = 3;</code>
       */
      public boolean hasType() {
        return instance.hasType();
      }
      /**
       * <pre>
       *  LOGIN_TYPE
       * </pre>
       *
       * <code>required int32 type = 3;</code>
       */
      public int getType() {
        return instance.getType();
      }
      /**
       * <pre>
       *  LOGIN_TYPE
       * </pre>
       *
       * <code>required int32 type = 3;</code>
       */
      public Builder setType(int value) {
        copyOnWrite();
        instance.setType(value);
        return this;
      }
      /**
       * <pre>
       *  LOGIN_TYPE
       * </pre>
       *
       * <code>required int32 type = 3;</code>
       */
      public Builder clearType() {
        copyOnWrite();
        instance.clearType();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:message.LoginReq)
    }
    private byte memoizedIsInitialized = -1;
    protected final Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        Object arg0, Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new message.AccountProto.LoginReq();
        }
        case IS_INITIALIZED: {
          byte isInitialized = memoizedIsInitialized;
          if (isInitialized == 1) return DEFAULT_INSTANCE;
          if (isInitialized == 0) return null;

          boolean shouldMemoize = ((Boolean) arg0).booleanValue();
          if (!hasType()) {
            if (shouldMemoize) {
              memoizedIsInitialized = 0;
            }
            return null;
          }
          if (shouldMemoize) memoizedIsInitialized = 1;
          return DEFAULT_INSTANCE;

        }
        case MAKE_IMMUTABLE: {
          return null;
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case VISIT: {
          Visitor visitor = (Visitor) arg0;
          message.AccountProto.LoginReq other = (message.AccountProto.LoginReq) arg1;
          accountName_ = visitor.visitString(
              hasAccountName(), accountName_,
              other.hasAccountName(), other.accountName_);
          password_ = visitor.visitString(
              hasPassword(), password_,
              other.hasPassword(), other.password_);
          type_ = visitor.visitInt(
              hasType(), type_,
              other.hasType(), other.type_);
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
              .INSTANCE) {
            bitField0_ |= other.bitField0_;
          }
          return this;
        }
        case MERGE_FROM_STREAM: {
          com.google.protobuf.CodedInputStream input =
              (com.google.protobuf.CodedInputStream) arg0;
          com.google.protobuf.ExtensionRegistryLite extensionRegistry =
              (com.google.protobuf.ExtensionRegistryLite) arg1;
          try {
            boolean done = false;
            while (!done) {
              int tag = input.readTag();
              switch (tag) {
                case 0:
                  done = true;
                  break;
                default: {
                  if (!parseUnknownField(tag, input)) {
                    done = true;
                  }
                  break;
                }
                case 10: {
                  String s = input.readString();
                  bitField0_ |= 0x00000001;
                  accountName_ = s;
                  break;
                }
                case 18: {
                  String s = input.readString();
                  bitField0_ |= 0x00000002;
                  password_ = s;
                  break;
                }
                case 24: {
                  bitField0_ |= 0x00000004;
                  type_ = input.readInt32();
                  break;
                }
              }
            }
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException(e.setUnfinishedMessage(this));
          } catch (java.io.IOException e) {
            throw new RuntimeException(
                new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this));
          } finally {
          }
        }
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          if (PARSER == null) {    synchronized (message.AccountProto.LoginReq.class) {
              if (PARSER == null) {
                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
              }
            }
          }
          return PARSER;
        }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:message.LoginReq)
    private static final message.AccountProto.LoginReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new LoginReq();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static message.AccountProto.LoginReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<LoginReq> PARSER;

    public static com.google.protobuf.Parser<LoginReq> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }

  public interface LoginRspOrBuilder extends
      // @@protoc_insertion_point(interface_extends:message.LoginRsp)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <code>optional int32 result = 1;</code>
     */
    boolean hasResult();
    /**
     * <code>optional int32 result = 1;</code>
     */
    int getResult();

    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    boolean hasPlayer();
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    message.PlayerProto.PlayerMsg getPlayer();
  }
  /**
   * Protobuf type {@code message.LoginRsp}
   */
  public  static final class LoginRsp extends
      com.google.protobuf.GeneratedMessageLite<
          LoginRsp, LoginRsp.Builder> implements
      // @@protoc_insertion_point(message_implements:message.LoginRsp)
      LoginRspOrBuilder {
    private LoginRsp() {
    }
    private int bitField0_;
    public static final int RESULT_FIELD_NUMBER = 1;
    private int result_;
    /**
     * <code>optional int32 result = 1;</code>
     */
    public boolean hasResult() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 result = 1;</code>
     */
    public int getResult() {
      return result_;
    }
    /**
     * <code>optional int32 result = 1;</code>
     */
    private void setResult(int value) {
      bitField0_ |= 0x00000001;
      result_ = value;
    }
    /**
     * <code>optional int32 result = 1;</code>
     */
    private void clearResult() {
      bitField0_ = (bitField0_ & ~0x00000001);
      result_ = 0;
    }

    public static final int PLAYER_FIELD_NUMBER = 2;
    private message.PlayerProto.PlayerMsg player_;
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    public boolean hasPlayer() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    public message.PlayerProto.PlayerMsg getPlayer() {
      return player_ == null ? message.PlayerProto.PlayerMsg.getDefaultInstance() : player_;
    }
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    private void setPlayer(message.PlayerProto.PlayerMsg value) {
      if (value == null) {
        throw new NullPointerException();
      }
      player_ = value;
      bitField0_ |= 0x00000002;
      }
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    private void setPlayer(
        message.PlayerProto.PlayerMsg.Builder builderForValue) {
      player_ = builderForValue.build();
      bitField0_ |= 0x00000002;
    }
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    private void mergePlayer(message.PlayerProto.PlayerMsg value) {
      if (player_ != null &&
          player_ != message.PlayerProto.PlayerMsg.getDefaultInstance()) {
        player_ =
          message.PlayerProto.PlayerMsg.newBuilder(player_).mergeFrom(value).buildPartial();
      } else {
        player_ = value;
      }
      bitField0_ |= 0x00000002;
    }
    /**
     * <code>optional .message.PlayerMsg player = 2;</code>
     */
    private void clearPlayer() {  player_ = null;
      bitField0_ = (bitField0_ & ~0x00000002);
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, result_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeMessage(2, getPlayer());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, result_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getPlayer());
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static message.AccountProto.LoginRsp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static message.AccountProto.LoginRsp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static message.AccountProto.LoginRsp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static message.AccountProto.LoginRsp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static message.AccountProto.LoginRsp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginRsp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static message.AccountProto.LoginRsp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginRsp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static message.AccountProto.LoginRsp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static message.AccountProto.LoginRsp parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(message.AccountProto.LoginRsp prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * Protobuf type {@code message.LoginRsp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          message.AccountProto.LoginRsp, Builder> implements
        // @@protoc_insertion_point(builder_implements:message.LoginRsp)
        message.AccountProto.LoginRspOrBuilder {
      // Construct using message.AccountProto.LoginRsp.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <code>optional int32 result = 1;</code>
       */
      public boolean hasResult() {
        return instance.hasResult();
      }
      /**
       * <code>optional int32 result = 1;</code>
       */
      public int getResult() {
        return instance.getResult();
      }
      /**
       * <code>optional int32 result = 1;</code>
       */
      public Builder setResult(int value) {
        copyOnWrite();
        instance.setResult(value);
        return this;
      }
      /**
       * <code>optional int32 result = 1;</code>
       */
      public Builder clearResult() {
        copyOnWrite();
        instance.clearResult();
        return this;
      }

      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public boolean hasPlayer() {
        return instance.hasPlayer();
      }
      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public message.PlayerProto.PlayerMsg getPlayer() {
        return instance.getPlayer();
      }
      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public Builder setPlayer(message.PlayerProto.PlayerMsg value) {
        copyOnWrite();
        instance.setPlayer(value);
        return this;
        }
      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public Builder setPlayer(
          message.PlayerProto.PlayerMsg.Builder builderForValue) {
        copyOnWrite();
        instance.setPlayer(builderForValue);
        return this;
      }
      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public Builder mergePlayer(message.PlayerProto.PlayerMsg value) {
        copyOnWrite();
        instance.mergePlayer(value);
        return this;
      }
      /**
       * <code>optional .message.PlayerMsg player = 2;</code>
       */
      public Builder clearPlayer() {  copyOnWrite();
        instance.clearPlayer();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:message.LoginRsp)
    }
    protected final Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        Object arg0, Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new message.AccountProto.LoginRsp();
        }
        case IS_INITIALIZED: {
          return DEFAULT_INSTANCE;
        }
        case MAKE_IMMUTABLE: {
          return null;
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case VISIT: {
          Visitor visitor = (Visitor) arg0;
          message.AccountProto.LoginRsp other = (message.AccountProto.LoginRsp) arg1;
          result_ = visitor.visitInt(
              hasResult(), result_,
              other.hasResult(), other.result_);
          player_ = visitor.visitMessage(player_, other.player_);
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
              .INSTANCE) {
            bitField0_ |= other.bitField0_;
          }
          return this;
        }
        case MERGE_FROM_STREAM: {
          com.google.protobuf.CodedInputStream input =
              (com.google.protobuf.CodedInputStream) arg0;
          com.google.protobuf.ExtensionRegistryLite extensionRegistry =
              (com.google.protobuf.ExtensionRegistryLite) arg1;
          try {
            boolean done = false;
            while (!done) {
              int tag = input.readTag();
              switch (tag) {
                case 0:
                  done = true;
                  break;
                default: {
                  if (!parseUnknownField(tag, input)) {
                    done = true;
                  }
                  break;
                }
                case 8: {
                  bitField0_ |= 0x00000001;
                  result_ = input.readInt32();
                  break;
                }
                case 18: {
                  message.PlayerProto.PlayerMsg.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000002) == 0x00000002)) {
                    subBuilder = player_.toBuilder();
                  }
                  player_ = input.readMessage(message.PlayerProto.PlayerMsg.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(player_);
                    player_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000002;
                  break;
                }
              }
            }
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException(e.setUnfinishedMessage(this));
          } catch (java.io.IOException e) {
            throw new RuntimeException(
                new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this));
          } finally {
          }
        }
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          if (PARSER == null) {    synchronized (message.AccountProto.LoginRsp.class) {
              if (PARSER == null) {
                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
              }
            }
          }
          return PARSER;
        }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:message.LoginRsp)
    private static final message.AccountProto.LoginRsp DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new LoginRsp();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static message.AccountProto.LoginRsp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<LoginRsp> PARSER;

    public static com.google.protobuf.Parser<LoginRsp> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
