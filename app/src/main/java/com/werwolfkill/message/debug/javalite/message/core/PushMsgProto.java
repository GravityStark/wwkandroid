// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core/PushMsg.proto

package message.core;

public final class PushMsgProto {
  private PushMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  /**
   * <pre>
   * 推送数据类型
   * </pre>
   *
   * Protobuf enum {@code message.core.PushType}
   */
  public enum PushType
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *玩家数据  PlayerMsg
     * </pre>
     *
     * <code>PUSH_PLAYER = 1;</code>
     */
    PUSH_PLAYER(1),
    /**
     * <pre>
     *玩家加入游戏   JoinerInfoMsg
     * </pre>
     *
     * <code>PUSH_JOIN_GAME = 2;</code>
     */
    PUSH_JOIN_GAME(2),
    /**
     * <pre>
     *玩家离开游戏    JoinerInfoMsg
     * </pre>
     *
     * <code>PUSH_QUIT_GAME = 3;</code>
     */
    PUSH_QUIT_GAME(3),
    /**
     * <pre>
     *文本信息推送   GameMsgPro
     * </pre>
     *
     * <code>PUSH_SEND_TXT_MSG = 4;</code>
     */
    PUSH_SEND_TXT_MSG(4),
    /**
     * <pre>
     *语音信息推送
     * </pre>
     *
     * <code>PUSH_SEND_VOICE_MSG = 5;</code>
     */
    PUSH_SEND_VOICE_MSG(5),
    /**
     * <pre>
     *房间信息变更  RoomMsg
     * </pre>
     *
     * <code>PUSH_ROOM_MSG = 6;</code>
     */
    PUSH_ROOM_MSG(6),
    ;

    /**
     * <pre>
     *玩家数据  PlayerMsg
     * </pre>
     *
     * <code>PUSH_PLAYER = 1;</code>
     */
    public static final int PUSH_PLAYER_VALUE = 1;
    /**
     * <pre>
     *玩家加入游戏   JoinerInfoMsg
     * </pre>
     *
     * <code>PUSH_JOIN_GAME = 2;</code>
     */
    public static final int PUSH_JOIN_GAME_VALUE = 2;
    /**
     * <pre>
     *玩家离开游戏    JoinerInfoMsg
     * </pre>
     *
     * <code>PUSH_QUIT_GAME = 3;</code>
     */
    public static final int PUSH_QUIT_GAME_VALUE = 3;
    /**
     * <pre>
     *文本信息推送   GameMsgPro
     * </pre>
     *
     * <code>PUSH_SEND_TXT_MSG = 4;</code>
     */
    public static final int PUSH_SEND_TXT_MSG_VALUE = 4;
    /**
     * <pre>
     *语音信息推送
     * </pre>
     *
     * <code>PUSH_SEND_VOICE_MSG = 5;</code>
     */
    public static final int PUSH_SEND_VOICE_MSG_VALUE = 5;
    /**
     * <pre>
     *房间信息变更  RoomMsg
     * </pre>
     *
     * <code>PUSH_ROOM_MSG = 6;</code>
     */
    public static final int PUSH_ROOM_MSG_VALUE = 6;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static PushType valueOf(int value) {
      return forNumber(value);
    }

    public static PushType forNumber(int value) {
      switch (value) {
        case 1: return PUSH_PLAYER;
        case 2: return PUSH_JOIN_GAME;
        case 3: return PUSH_QUIT_GAME;
        case 4: return PUSH_SEND_TXT_MSG;
        case 5: return PUSH_SEND_VOICE_MSG;
        case 6: return PUSH_ROOM_MSG;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<PushType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        PushType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<PushType>() {
            public PushType findValueByNumber(int number) {
              return PushType.forNumber(number);
            }
          };

    private final int value;

    private PushType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.core.PushType)
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
